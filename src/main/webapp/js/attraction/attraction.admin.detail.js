$(".attractionTree").addClass("is-expanded");
$(".attractionList").addClass("active");

var E = window.wangEditor;

var editor1 = new E('#editorArea');
// 编辑器菜单设置
editor1.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'link',  // 插入链接
    'quote',  // 引用
    'image',  // 插入图片
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
];
editor1.customConfig.uploadImgServer = '/file/uploadFTP';  // 上传图片到服务器
editor1.customConfig.showLinkImg = false; // 取消网络图片
editor1.customConfig.uploadFileName = 'uploadFile';
editor1.create();

$(function () {
    // 征求 通知权利
    if (Notification && Notification.permission !== "granted") {
        Notification.requestPermission(function (status) {
            if (Notification.permission !== status) {
                Notification.permission = status;
            }
        });
    }
});

$(function () {
    $("#publishBtn").click(function () {
        var content = editor1.txt.html();
        var url ;
        if($("#id").val()==="") {
            url = "/admin/attraction/insertAttraction";
        } else {
            url = "/admin/attraction/updateAttraction";
        }
        var data = {
            id : $("#id").val(),
            attractionName : $("#attractionName").val(),
            attractionStar : $("#attractionStar").val(),
            attractionAddress : $("#attractionAddress").val(),
            attractionSummary : $("#attractionSummary").val(),
            attractionPrice : $("#attractionPrice").val(),
            attractionImg : $("#attractionImg").val(),
            attractionOpenTime : $("#attractionOpenTime").val(),
            attractionEndTime : $("#attractionEndTime").val(),
            attractionDetail : content,
        }
        $.post(url, data, function (obj) {
            if (obj.code==='200') {
                alert("成功");
                location = "/admin/attraction/listPage";
            } else {
                alert("操作失败,请稍后重试");
            }
        }, "json");
    });

    $("#imgUpload").fileinput({
        language: "zh",
        showCaption: false, // 不显示本地文件名
        allowedFileTypes: ['image'], // 只允许上传图片
        allowedFileExtensions: ["jpg", "jpeg", "png", "gif"],
        initialPreview: ['<img style="width: 100%;height: 100%;" src="'+$("#attractionImg").val()+'" />'],
        initialPreviewFileType:'image',
        uploadUrl: "/file/uploadFTP" //上传图片的服务器地址
    }).on('fileuploaded', function(event, data, previewId, index){
        var response = data.response;
        var attractionImg = response.data[0];
        $("#attractionImg").val(attractionImg);
    });
});
