<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fileinput.min.css">
    <%--<link type="text/css" rel="styleSheet" href="/css/member.main.css"/>--%>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html,
        body {
            height: 100%;
        }

        input:focus {
            outline: none;
        }

        .form input {
            width: 300px;
            height: 30px;
            font-size: 18px;
            background: none;
            border: none;
            border-bottom: 1px solid #fff;
            color: #fff;
            margin-bottom: 20px;
        }

        .form input::placeholder {
            color: rgba(255, 255, 255, 0.8);
            font-size: 18px;
            font-family: "neo";
        }

        .confirm {
            height: 0;
            overflow: hidden;
            transition: .25s;
        }

        .btn {
            width: 140px;
            height: 40px;
            border: 1px solid #fff;
            background: none;
            font-size: 20px;
            color: #fff;
            cursor: pointer;
            margin-top: 25px;
            font-family: "neo";
            transition: .25s;
        }

        .btn:hover {
            background: rgba(255, 255, 255, .25);
        }

        #login_wrap {
            width: 980px;
            min-height: 500px;
            border-radius: 10px;
            font-family: "neo";
            overflow: hidden;
            box-shadow: 0px 0px 120px rgba(0, 0, 0, 0.25);
            /*position: fixed;*/
            top: 50%;
            right: 50%;
            margin: 0 auto;
        }

        #login {
            width: 100%;
            height: 1280px;
            min-height: 500px;
            background: linear-gradient(45deg, #9a444e, #e06267);
            position: relative;
            float: right;
        }

        #login #status {
            width: 120px;
            height: 35px;
            margin: 40px auto;
            color: #fff;
            font-size: 30px;
            font-weight: 600;
            position: relative;
            overflow: hidden;
        }

        #login #status i {
            width: 130px;
            font-style: normal;
            position: absolute;
            transition: .5s
        }

        #login span {
            text-align: center;
            position: absolute;
            left: 50%;
            margin-left: -150px;
            top: 52%;
            margin-top: -140px;
        }

        #login span a {
            text-decoration: none;
            color: #fff;
            display: block;
            margin-top: 80px;
            font-size: 18px;
        }

        #bg {
            background: linear-gradient(45deg, #211136, #bf5853);
            height: 1380px;
        }

        /*提示*/
        /*#hint {*/
            /*width: 100%;*/
            /*line-height: 70px;*/
            /*background: linear-gradient(-90deg, #9b494d, #bf5853);*/
            /*text-align: center;*/
            /*font-size: 25px;*/
            /*color: #fff;*/
            /*box-shadow: 0 0 20px #733544;*/
            /*display: none;*/
            /*opacity: 0;*/
            /*transition: .5s;*/
            /*position: absolute;*/
            /*top: 0;*/
            /*z-index: 999;*/
        /*}*/

        /* 响应式 */
        /*@media screen and (max-width: 1000px ) {*/
            /*#login_wrap {*/
                /*width: 490px;*/
                /*margin-right: -245px;*/
            /*}*/

            /*#login {*/
                /*width: 100%;*/
            /*}*/
        /*}*/

        /*@media screen and (max-width: 560px ) {*/
            /*#login_wrap {*/
                /*width: 330px;*/
                /*margin-right: -165px;*/
            /*}*/

            /*#login span {*/
                /*margin-left: -125px;*/
            /*}*/

            /*.form input {*/
                /*width: 250px;*/
            /*}*/

            /*.btn {*/
                /*width: 113px;*/
            /*}*/
        /*}*/

        /*@media screen and (max-width: 345px ) {*/
            /*#login_wrap {*/
                /*width: 290px;*/
                /*margin-right: -145px;*/
            /*}*/
        /*}*/

        #errorTip {
            color: yellow;
        }
        .formFont{
            color: whitesmoke;
            float: left;
            margin-left: 5px;
        }
        #memberForm{
            margin-top: -30px;
        }
    </style>
</head>
<body>
<input type="hidden" value="<%=basePath%>" id="basePath">
<input type="hidden" id="isSignIn" />
<div style="display: none">
    <input type="text">
    <input type="password">
</div>
<div id="bg">
    <div id="hint"><!-- 提示框 -->
        <p>登录失败</p>
    </div>
    <div id="login_wrap">
        <div id="login">
            <div id="status">
                <i style="top: 0">个人信息</i>
                <%--<i style="right: 5px">登录</i>--%>
            </div>
            <div style="margin-left: 350px;">
                    <form action="post" id="memberForm">
                        <input type="hidden" id="id" name="id" value="${member.id}">
                        <input type="hidden" id="memberHeadImg" name="id" value="${member.headImg}">
                        <p class="form formFont">登录账号:${member.account}</p>
                        <br><br>
                        <p class="form formFont">用户昵称:</p>
                        <p class="form"><input type="text" id="user" placeholder="请输入用户昵称" value="${member.name}"></p>
                        <p class="form formFont">&nbsp;&nbsp;新密码:</p>
                        <p class="form"><input type="password" id="passwd" placeholder="请输入新密码"></p>
                        <p class="form formFont">个人爱好:</p>
                        <p class="form"><input type="text" id="hobby" placeholder="请输入个人爱好" value="${member.hobby}"></p>
                        <p class="form formFont">&nbsp;&nbsp;性&nbsp;&nbsp;别:</p>
                        <%--<p class="form">--%>
                        <%--</p>--%>
                            <input class="checkBoxInput" type="radio" name="gender" value="1" >男
                            <input class="checkBoxInput" type="radio" name="gender" value="2" >女
                        <p></p>
                        <p class="form formFont">自我介绍:</p>
                        <p class="form"><input type="text" id="summary" placeholder="请输入自我介绍" value="${member.summary}"></p>
                        <p class="form formFont">出生日期:</p>
                        <p class="form"><input type="date" id="birthday" placeholder="请输入出生日期" value="${member.birthday}"></p>
                        <p class="form formFont">&nbsp;&nbsp;头&nbsp;&nbsp;像:</p>
                        <div style="width: 500px;">
                        <input type="file" name="uploadFile" id="imgUpload" />
                        </div>
                        <p class="form"></p>

                        <p class="form formFont">喜欢城市:</p><p>
                        <div class="form">
                            <c:forEach items="${cityList}" var="city">
                            <div style="float: left;margin-left: 5px;">
                                <input type="checkbox" class="checkBoxInput" style=" width: auto;" value="${city.id}">
                                    <text>${city.attractionName}</text>
                            </div>
                            </c:forEach>
                        </div>
                        <br><br><br>
                        <p id="errorTip"></p>
                        <br>
                        <div style="margin-left: 400px;">
                        <input type="button" value="修改信息" class="btn logBtn" onclick="update_confirm()"
                               style="margin-left: -400px;">
                        <input type="button" value="删除账号" class="btn logBtn" onclick='delete_confirm()'
                               style="margin-left: -250px;float: left;">
                        </div>
                    </form>
                </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/attraction/fileinput.min.js"></script>
<script>
    var basePath = $("#basePath").val();
    var confirm = document.getElementsByClassName("confirm")[0]

    // 参数检查
    function checkParam() {
        $("#errorTip").html("");
        var isSignIn = $("#isSignIn").val();
        if (!/^[A-Za-z0-9]+$/.test(user.value))
            return "账号只能为英文和数字"
        else if (user.value.length < 5)
            return "账号长度必须大于5位"
        else if (passwd.value.length < 5)
            return "密码长度必须大于5位"
        else if (isSignIn === "1" && passwd.value !== $("#confirm-passwd").val())
            return "两次密码不相等";

        return "success";
    }

    function delete_confirm() {
        var r=confirm("确认删除用户?");
        if (r==true){
            var url = basePath + "/member/deleteMember?memberId="+$("#id").val();
            $.post(url, function (obj) {
                if(obj.code === "200") {
                    $("#errorTip").html("删除成功");
                    window.setTimeout( function(){
                        location.href=basePath;
                    }, 1500 );
                }
            }, "json");
        }
    }

    function update_confirm() {
        // var errorMsg = checkParam();
        var errorMsg = 'success';
        if(errorMsg === "success") {
            $("#errorTip").html("正在修改");
            var url = basePath + "/member/updateMember";
            var checkVal = '';
            $('.checkBoxInput:checkbox').each(function() {
                if ($(this).prop('checked') ==true) {
                    checkVal += $(this).val() + ",";
                }
            });
            $.post(url,{
                id : $("#id").val(),
                name : $("#user").val(),
                password : $("#passwd").val(),
                hobby : $("#hobby").val(),
                summary : $("#summary").val(),
                birthday : $("#birthday").val(),
                headImg : $("#memberHeadImg").val(),
                gender : $("[name='gender']:checked").val(),
                favAttraction : checkVal,
            },function (obj) {
                if(obj.code === "200") {
                    $("#errorTip").html("修改成功");
                    window.setTimeout( function(){
                        location.href=basePath;
                    }, 1500 );
                } else {
                    $("#errorTip").html(obj.msg);
                }
            },"json")
        } else {
            $("#errorTip").html(errorMsg);
        }
    }

    $(function () {
        $("#ClCache").remove();

        $("#imgUpload").fileinput({
            language: "zh",
            // showPreview:false,
            showCaption: false, // 不显示本地文件名
            allowedFileTypes: ['image'], // 只允许上传图片
            allowedFileExtensions: ["jpg", "jpeg", "png", "gif"],
            initialPreview: ['<img style="width: 100%;height: 100%;" src="'+$("#memberHeadImg").val()+'" />'],
            showRemove : false, //显示移除按钮
            showUpload : false,
            initialPreviewFileType: 'image',
            browseClass: "btn btn-primary",
            msgFilesTooMany: "选择上传的文件数量{n} 超过允许的最大数值{m}！",
            // maxFileCount: 5, //表示允许同时上传的最大文件个数
            layoutTemplates:{
                actionDownload : '',
                actionZoom : '',
            },
            uploadUrl: "/file/uploadFTP" //上传图片的服务器地址
        }).on('fileuploaded', function (event, data, previewId, index) {
            var response = data.response;
            var image = response.data[0];
            $("#memberHeadImg").val(image);
        });
    })
</script>
</html>
