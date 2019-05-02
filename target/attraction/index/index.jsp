<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <!-- Font-icon css-->
    <!--<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">-->
    <title>互联网产业集群反馈系统</title>
  </head>
  <body>
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h3>互联网产业集群反馈系统</h3>
      </div>
      <div class="login-box" id="loginBox">
        <form class="login-form" id="login-form">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>登陆</h3>
          <div class="form-group">
            <label class="control-label">账户名</label>
            <input class="form-control" id="logname" type="text" name="logname" placeholder="请输入账户名" autofocus>
          </div>
          <div class="form-group">
            <label class="control-label">密码</label>
            <input class="form-control" id="password" type="password" name="password" placeholder="请输入密码">
          </div>
          <div class="form-group btn-container">
            <button type="button" class="btn btn-primary btn-block" id="loginButton"><i class="fa fa-sign-in fa-lg fa-fw"></i>登陆</button>
          </div>
        </form>
      </div>
    </section>
    <!-- Essential javascripts for application to work-->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script type="text/javascript">
      // Login Page Flipbox control
      $('.login-content [data-toggle="flip"]').click(function() {
      	$('.login-box').toggleClass('flipped');
      	return false;
      });

      $(function () {
          $('#loginBox').keydown(function(e){
              if(e.keyCode == 13){
                  //模拟点击登陆按钮，触发上面的 Click 事件
                  $("#loginButton").click();
              }
          });

          $("#loginButton").click(function () {
              var url = "/admin/user/login";
              var data = $("#login-form").serialize();
              var callback = function (obj) {
                  if (obj.result=="success") {
                      $.cookie('autuanBlog', obj.describe, { expires: 0.1});
                      location = "/admin";
                  }
                  else {
                      console.log("error")
                      alert(obj.describe);
                  }
              };
              $.post(url,data,callback,"json");
          })
      })
    </script>
  </body>
</html>