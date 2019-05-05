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
<input type="hidden" value="<%=basePath%>" id="basePath">
<div class="nav clear">
    <ul class="clear">
        <c:if test="${member.account != null}">
            <li><a href="/member/info">${member.name}</a></li>
            <li><a href="/member/logOut">退出登录</a></li>
        </c:if>
        <c:if test="${member.account == null}">
            <li><a href="<%=basePath%>/member">登录&nbsp;&nbsp;|&nbsp;&nbsp;注册</a></li>
        </c:if>
    </ul>
</div>
<div class="search1">
    <div class="imglog">
        <img src="img/logoBaidu.png"/>
    </div>
    <div>
        <input type="text" class="txtingput" id="searchWord"/>
        <button type="button" class="txtbutton" id="searchBtn">景点搜索</button>
    </div>
</div>
<div class="imglist1">
    <div class="recommendDiv" id="searchTip">搜索结果:</div>
    <ul class="clear" id="searchResult">
    </ul>

    <div class="recommendDiv">为您推荐:</div>
    <ul class="clear">
        <c:forEach items="${recommends}" var="recommend">
        <li>
            <a href="/attraction/detail?id=${recommend.id}">
                <img src="<%=basePath%>/images/temp/1.jpg"/>
                <span>${recommend.attractionName}</span>
            </a>
        </li>
        </c:forEach>
    </ul>
</div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    var basePath = $("#basePath").val();
    $("#searchTip").hide();
    $("#searchResult").hide();
    $("#searchBtn").click(function () {
        $(".imglog").hide(1000);
        var key = $("#searchWord").val();
        $.post(basePath + '/attraction/search',{keyword:key},function (obj) {
            if(obj.code === '200') {
                var list =obj.data;
                var str = '';
                for(var i=0;i<list.length;i++){
                    str += '<li><a href="/attraction/detail?id='+list[i].id+'"><img src="<%=basePath%>/images/temp/2.jpg"/>'
                        +'<span>'+list[i].attractionName+'</span></a></li>'
                }
                if(list.length == 0) {
                    str = '未搜索到相关景点';
                }
                $("#searchTip").html('搜索:'+key);
                $("#searchResult").empty();
                $("#searchResult").append($(str));
                $("#searchTip").show(1000);
                $("#searchResult").show(1000);
            }
        });
    });
</script>
</body>
</html>
