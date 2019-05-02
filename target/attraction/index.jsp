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
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问 畅游</title>
    <link href="/css/index.css.css" rel="stylesheet" type="text/css"/>
    <link href="/css/index.reset.min.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="nav clear">
    <ul class="clear">
        <c:if test="${memberName != null}">
            <li><a href="javascript:void(0);">${memberName}</a></li>
            <li><a href="javascript:void(0);">退出登录</a></li>
        </c:if>
        <c:if test="${memberName == null}">
            <li><a href="<%=basePath%>/member">登录&nbsp;&nbsp;|&nbsp;&nbsp;注册</a></li>
        </c:if>
    </ul>
</div>
<div class="search1">
    <div class="imglog">
        <img src="img/logoBaidu.png"/>
    </div>
    <div>
        <input type="text" class="txtingput"/>
        <input type="button" class="txtbutton" value="百度一下"/>
    </div>
</div>
<div class="imglist1">
    <div class="recommendDiv">为您推荐:</div>
    <ul class="clear">
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/1.jpg"/><span>PPT模板</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/2.jpg"/><span>宠物</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/3.jpg"/><span>高清动漫</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/4.jpg"/><span>微距摄影</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/5.jpg"/><span>多肉植物</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/6.jpg"/><span>头像</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/7.jpg"/><span>风景</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/8.jpg"/><span>小清新</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/9.jpg"/><span>星空</span></a></li>
        <li><a href="javascript:void(0);"><img src="<%=basePath%>/images/temp/10.jpg"/><span>美女明星</span></a></li>
    </ul>
</div>
</div>
</body>
</html>
