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
    <title>详情页面</title>
    <link href="/css/attraction.detail.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fileinput.min.css">

</head>

<body>
<input type="hidden" id="attractionId" value="${attraction.id}"/>
<input type="hidden" id="attractionAddress" value="${attraction.attractionAddress}"/>
<input type="hidden" id="memberId" value="${member.id}"/>
<input type="hidden" id="commentId"/>
<!-----header部分------->
<div class="header">
    <div class="top">
        <div class="top1">
            <c:if test="${member.account != null}">
                <a href="<%=basePath%>/member/info">${member.name}</a>
                <a href="<%=basePath%>/member/logOut">退出登录</a>
            </c:if>
            <c:if test="${member.account == null}">
                <a href="<%=basePath%>/member">登录 | 注册</a>
            </c:if>
        </div>
    </div>
    <!-----logo_search部分------->
    <div class="logobg">
        <div class="center">
            <div class="logo">
                <img src="<%=basePath%>/images/logo.png" width="249" height="55">
            </div>
        </div>
    </div>
</div>
<!-----header结束------->
<!-----详情部分------->
<div class="shopdetails">
    <!-------放大镜-------->
    <div id="leftbox">
        <div id="showbox">
            <img src="${attraction.attractionImg}" width="400" height="550"/>
        </div><!--展示图片盒子-->
        <div id="showsum"></div><!--展示图片里边-->
        <p class="showpage">
            <a href="javascript:void(0);" id="showlast"> < </a>
            <a href="javascript:void(0);" id="shownext"> > </a>
        </p>

    </div>
    <!----中间----->
    <div class="centerbox">
        <p class="imgname">${attraction.attractionName}</p>
        <p class="price">参考票价：<samp>￥${attraction.attractionPrice}</samp></p>
        <%--<p class="price">参考票价：<samp>￥${attraction.attractionPrice}</samp></p>--%>
        <div class="fenx">开放时间</div>
        <div class="fenx"><span>${attraction.attractionOpenTime}</span>   至   <span>${attraction.attractionEndTime}</span></div>
    </div>

</div>
<!-----详情部分结束------->
<!-----详情评价部分------->
<div class="evaluate">
    <div class="tabbedPanels">
        <ul class="tabs">
            <li><a href="#panel01">详情</a></li>
            <li><a href="#panel02" class="active">评价</a></li>
            <li><a href="#panel03" id="mapNav">地图导航</a></li>
        </ul>

        <div class="panelContainer">
            <div class="panel" id="panel01">
                ${attraction.attractionDetail}
            </div>

            <div class="panel" id="panel02">
                <c:if test="${member.account != null}">
                    <p class="judge"><span><a href="javascript:void(0);" id="commentAttraction">新增或修改评价</a></span></p>
                    <div id="commentDiv" style="margin-bottom: 30px;">
                        <div class="judge01">
                            <input type="hidden" id="commentImg" />
                            <input type="radio" name="type" value="1">喜欢
                            <input type="radio" name="type" value="2">一般
                            <input type="radio" name="type" value="3">讨厌
                            <br><br>
                            <textarea id="commentContent" style="float: left;" type="text" value="输入您的评价" rows="7"
                                      cols="80">输入您的评价</textarea>
                        </div>
                        <input type="file" name="uploadFile" id="imgUpload"  multiple="multiple" />
                        <button class="btn btn-info" style="float: left;margin-top: 1%;margin-left: 5px;" id="commentBtn">确认</button>
                    </div>
                </c:if>
                <c:forEach items="${commentList}" var="comment">
                    <div class="judge01">
                            <%--<div class="idimg"><img src="images/shopdetail/detail102.png"></div>--%>
                        <div class="write">
                            <p class="idname">匿名用户</p>
                            <p>${comment.content}</p>
                            <p class="which">评价:
                                <c:choose>
                                    <c:when test="${comment.type == 1}">
                                        喜欢
                                    </c:when>
                                    <c:when test="${comment.type == 2}">
                                        一般
                                    </c:when>
                                    <c:when test="${comment.type == 3}">
                                        讨厌
                                    </c:when>
                                </c:choose>
                            </p>
                                <c:if test="${comment.imgList != null}">
                                    <c:forEach items="${comment.imgList}" var="commentImage">
                                        <img src="${commentImage}" width="40px" height="40px">
                                    </c:forEach>
                                </c:if>
                        </div>
                    </div>
                </c:forEach>
                <div class="clear"></div>
            </div>

            <div class="panel" id="panel03">
                <p class="sell">
                    <span>输入出发位置</span>
                    <input type="text" id="setStartLocal">
                    <input type="radio" name="mapRoute" value="0"> 公交
                    <input type="radio" name="mapRoute" value="1"> 驾车
                    <input type="radio" name="mapRoute" value="2"> 步行
                    <button id="routeBtn">查询推荐方案</button>
                </p>
                <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
                <style type="text/css">
                    html {
                        height: 100%
                    }

                    body {
                        height: 100%;
                        margin: 0px;
                        padding: 0px
                    }

                    #container {
                        height: 500px;
                    }
                </style>
                <div id="container"></div>
                <div class="com">
                </div>
                <div class="clear"></div>
            </div>

        </div>
    </div>
</div>

<!-----详情评价部结束分------->

<!----bottom_页脚部分----->
<div class="backf">
    <div class="foot">
        <p>使用本网站即表示接受 用户协议</p>
        <p>版权所有——————————————————</p>
    </div>
</div>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6FE4buMdXYAgSAIWq9dODEQohGLViETF"></script>
<script src="${pageContext.request.contextPath}/js/attraction/fileinput.min.js"></script>
<script src="/js/attraction/attraction.detail.common.js"></script>
<script src="/js/attraction/attraction.detail.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var showproduct = {
            "boxid": "showbox",
            "sumid": "showsum",
            "boxw": 400,
            "boxh": 550,
            "sumw": 60,//列表每个宽度,该版本中请把宽高填写成一样
            "sumh": 60,//列表每个高度,该版本中请把宽高填写成一样
            "sumi": 7,//列表间隔
            "sums": 5,//列表显示个数
            "sumsel": "sel",
            "sumborder": 1,//列表边框，没有边框填写0，边框在css中修改
            "lastid": "showlast",
            "nextid": "shownext"
        };//参数定义
        $.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行

        $(function () {
            $('.tabs a').click(function () {
                var $this = $(this);
                $('.panel').hide();
                $('.tabs a.active').removeClass('active');
                $this.addClass('active').blur();
                var panel = $this.attr("href");
                $(panel).show();
                if ($(this).prop("id") === 'mapNav') {
                    activeBaiduMap();
                }
                return false;  //告诉浏览器  不要纸箱这个链接
            })//end click
            $(".tabs li:first a").click()   //web 浏览器，单击第一个标签吧

        })//end ready

        $(".centerbox li").click(function () {
            $("li").removeClass("now");
            $(this).addClass("now")
        });
    });
</script>
</body>
</html>