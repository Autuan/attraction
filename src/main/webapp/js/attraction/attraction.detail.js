var globalMap;
// 地图路线 -> 驾车
function driveRoute() {
    var driving = new BMap.DrivingRoute(globalMap, {
        renderOptions: {
            map: globalMap,
            autoViewport: true
        }
    });
    driving.search($("#setStartLocal").val(), $("#attractionAddress").val());
}
// 地图路线 -> 公交
function transitRoute() {
    var transit = new BMap.TransitRoute(globalMap, {
        renderOptions: {map: globalMap}
    });
    transit.search($("#setStartLocal").val(), $("#attractionAddress").val());
}
// 地图路线 -> 步行
function walkRoute() {
    var walk = new BMap.WalkingRoute(globalMap, {
        renderOptions: {map: globalMap}
    });
    walk.search($("#setStartLocal").val(), $("#attractionAddress").val());
}
// 地图
function activeBaiduMap() {
    var map = new BMap.Map("container");
    var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
    map.centerAndZoom(point,12);
    var geolocation = new BMap.Geolocation();
    var myGeo = new BMap.Geocoder();
    myGeo.getPoint($("#attractionAddress").val(), function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            alert("您选择地址没有解析到结果!");
        }
    });
    globalMap = map;
}
$("#imgUpload").fileinput({
    language: "zh",
    showCaption: false, // 不显示本地文件名
    allowedFileTypes: ['image'], // 只允许上传图片
    allowedFileExtensions: ["jpg", "jpeg", "png", "gif"],
    // initialPreview: array,
    initialPreviewFileType: 'image',
    msgFilesTooMany: "选择上传的文件数量{n} 超过允许的最大数值{m}！",
    maxFileCount: 5, //表示允许同时上传的最大文件个数
    uploadUrl: "/file/uploadFTP" //上传图片的服务器地址
}).on('fileuploaded', function (event, data, previewId, index) {
    var response = data.response;
    var image = response.data[0];
    var commentImg = $("#commentImg").val();
    commentImg += image + ",";
    $("#commentImg").val(commentImg);
});

$(function () {
    $("#commentDiv").hide();
    var commentUrl = "/comment/selectByMemberAndAttraction";
    var commentData = {
        attractionId:$("#attractionId").val(),
        memberId:$("#memberId").val(),
    };
    $.post(commentUrl,commentData,function (obj) {
        if(obj.code === '200') {
            var comment = obj.data;
            $("input[name='type'][value='"+comment.type+"']").attr("checked",true);
            $("#commentContent").val(comment.content);
            $("#commentId").val(comment.id);
            // var array = [];
            // for(var i=0;i<comment.imgList.length;i++) {
            //     var str = '<img style="width: 100%;height: 100%;" src="'+comment.imgList[i]+'" />';
            //     console.log(str);
            //     array.push(str);
            // }
        }
    },"json");
    $("#commentAttraction").click(function () {
        $("#commentDiv").toggle();
    });
    function checkParam() {
        if(!$(':radio[name=type]:checked').length){
            return "请选择评价";
        }
        var content = $("#commentContent").val();
        if(content === '' || content === '输入您的评价') {
            return "请输入评价";
        }
        if($("#memberId").val() === '') {
            return "请先登录";
        }
        return "success";
    }
    $("#commentBtn").click(function () {
        var check = checkParam();
        if(check !== 'success') {
            alert(check);
            return;
        }
        var commentId = $("#commentId").val();
        var url = "/comment/addOrEdit";
        var data = {
            type:$("[name='type']:checked").val(),
            content:$("#commentContent").val(),
            attractionId:$("#attractionId").val(),
            memberId:$("#memberId").val(),
            commentImg:$("#commentImg").val(),
            id:$("#commentId").val(),
        };
        $.post(url,data,function (obj) {
            if(obj.code === '200') {
                alert("评论成功!");
                location.reload();
            } else {
                alert("评论失败,请稍后重试");
            }
        },"json")
    });

    $("#routeBtn").click(function () {
        switch ($("[name='mapRoute']:checked").val()) {
            case '0' : transitRoute();break;
            case '1' : driveRoute();break;
            case '2' : walkRoute();break;
        }
    });
});