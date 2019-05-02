<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>反馈新问题</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">

    <style>
        .chooseTitle{
            margin-right: 10px;
        }
    </style>
</head>
<body class="app sidebar-mini rtl">
<div th:include="managerCommon :: ManagerCommon"></div>
<jsp:include page="../menuCommon.jsp"></jsp:include>
<main class="app-content">
    <div th:include="managerCommon :: contentTitle"></div>
    <input type="hidden" value="${userInfo}" id="userInfo">
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div>
                        <form class="form-horizontal" id="articleForm">
                            <input type="hidden" name="id" id="id" value="${attraction.id}" />
                            <div class="form-group">
                                <label for="attractionName" class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="attractionName" id="attractionName"
                                           placeholder="请输入名称" value="${attraction.attractionName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="attractionStar" class="col-sm-2 control-label">星级</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="attractionStar" id="attractionStar"
                                           placeholder="请输入星级" value="${attraction.attractionStar}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="attractionAddress" class="col-sm-2 control-label">景点地址</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="attractionAddress" id="attractionAddress"
                                           placeholder="请输入景点地址" value="${attraction.attractionAddress}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="attractionSummary" class="col-sm-2 control-label">简介</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="attractionSummary" id="attractionSummary"
                                           placeholder="请输入简介" value="${attraction.attractionSummary}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="attractionPrice" class="col-sm-2 control-label">景点票价</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="attractionPrice" id="attractionPrice"
                                           placeholder="请输入景点票价" value="${attraction.attractionPrice}">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="attractionDetail" id="attractionDetail" value="${attraction.attractionDetail}">
                                <label for="detail" class="col-sm-2 control-label">景点详情</label>
                                <div class="col-sm-offset-2 col-sm-10" id="detail">
                                    <div id="editorArea">
                                        ${attraction.attractionDetail}
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" id="publishBtn" class="btn btn-success">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%-- js 文件--%>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script src="${pageContext.request.contextPath}/js/attraction/attraction.admin.detail.js"></script>
</body>
</html>