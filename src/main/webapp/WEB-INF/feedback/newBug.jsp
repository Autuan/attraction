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
                            <div class="form-group">
                                <label for="articleTitle" class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="feedbackTitle" id="articleTitle" placeholder="请输入标题">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="feedbackContent" id="feedbackContent">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div id="editorArea">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <select id="selectMan" name="feedbackPictures">
                                        <option value="未选择">--选择提交对象--</option>
                                    </select>
                                    <button type="button" id="publishBtn" class="btn btn-success">提交</button>
                                    <%--<button type="button" class="btn btn-info" disabled="disabled">撤消</button>--%>
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
<%--<script src="${pageContext.request.contextPath}/js/feedback/sse.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/feedback/forNewBug.js"></script>
</body>
</html>