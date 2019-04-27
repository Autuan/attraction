$(".bugTree").addClass("is-expanded");
$(".newBug").addClass("active");

var getManUrl = "/user/getAdminAndTechnology";
var getManCallback = function (obj) {
    for (var i=0;i<obj.length;i++) {
        $("#selectMan").append("<option value='"+obj[i].userUsername+"'>"+obj[i].userUsername+"</option>")
    }
};
$.get(getManUrl, getManCallback, "json");


var E = window.wangEditor;

var editor1 = new E('#editorArea');
// 编辑器菜单设置
editor1.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    // 'italic',  // 斜体
    // 'underline',  // 下划线
    // 'strikeThrough',  // 删除线
    // 'foreColor',  // 文字颜色
    // 'backColor',  // 背景颜色
    'link',  // 插入链接
    // 'list',  // 列表
    // 'justify',  // 对齐方式
    'quote',  // 引用
    // 'emoticon',  // 表情
    'image',  // 插入图片
    // 'table',  // 表格
    // 'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
];
editor1.customConfig.uploadImgServer = '/file/uploadFiles';  // 上传图片到服务器
editor1.customConfig.showLinkImg = false; // 取消网络图片
editor1.customConfig.uploadFileName = 'file';
editor1.create();

$(function () {
    // 征求 通知权利
    if(Notification && Notification.permission !== "granted"){
        Notification.requestPermission(function(status){
            if(Notification.permission !== status){
                Notification.permission = status;
            }
        });
    }
});



// ws.addEventListener("message", function(event) {
//
// });
// websocket over
$(function () {
    $("#publishBtn").click(function () {
        var content =editor1.txt.html();
        $("#feedbackContent").val(content);

        var url = "/feedback/insertFeedback";
        var data = $("#articleForm").serialize();
        $.post(url,data,function (obj) {
            if (obj == "success") {
                alert("成功");
                location = "/feedback/bugList";
                };
        },"text");
    });
});
