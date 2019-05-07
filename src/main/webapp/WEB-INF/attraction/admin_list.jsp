<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">

    <title>查询部门列表</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
    <style>
        .table-btn {
            margin-top: 5px;
        }
        .tile {
            height: 800px;
        }
    </style>
</head>
<body class="app sidebar-mini rtl">
<% request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../menuCommon.jsp"></jsp:include>


<main class="app-content">
    <div th:include="managerCommon :: contentTitle"></div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table id="bootstrapTable"></table>
                </div>
            </div>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default btn-xs">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button class="btn btn-default btn-xs" id="btn_edit">
            <span class="glyphicon glyphicon-floppy-pencil"></span>修改
        </button>
    </div>

    <!-- 信息删除确认 -->
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="id"/>
                    <p>您确认要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="url"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" onclick="deleteFun()" class="btn btn-success" data-dismiss="modal">确定
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</main>
<!-- Essential javascripts for application to work-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-editable.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-editable.js"></script>
<script src="${pageContext.request.contextPath}/js/attraction/addraction.admin.js"></script>
</body>
</html>