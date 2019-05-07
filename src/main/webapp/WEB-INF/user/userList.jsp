<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<head>
    <meta charset="UTF-8">

    <title>查询用户列表</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .table-btn{
            margin-top: 5px;
        }
        .tile{
            height: 800px;
        }
    </style>
</head>
<body class="app sidebar-mini rtl">
<% request.setCharacterEncoding("UTF-8");%>
<jsp:include page="../menuCommon.jsp"></jsp:include>
<main class="app-content">
    <div th:include="managerCommon :: contentTitle"></div>
    <input type="hidden" value="${userInfo}" id="userInfo">
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table id="blogTable"></table>
                </div>
            </div>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default btn-xs">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
    </div>


    <div th:fragment="myModal">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="chapterListUpload"></h4>
                    </div>
                    <div class="modal-body" id="modalBody">

                        <form class="form-horizontal" role="form" id="userForm">
                            <div class="form-group">
                                <label for="user_logname" class="col-sm-2 control-label">账户名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="userLogname" id="user_logname" placeholder="请输入账户名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_password" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="userPassword" id="user_password" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_username" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="user_username" name="userUsername" placeholder="请输入用户名">
                                </div>
                            </div>
                        </form>

                        <div class="modal-footer">
                            <input type="hidden" id="myModalFooter"/>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button"  onclick="insertUser()" class="btn btn-success" data-dismiss="modal">确定</button>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>

    <!-- 信息删除确认 -->
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteFunId" />
                    <p>您确认要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="url"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button"  onclick="deleteFun()" class="btn btn-success" data-dismiss="modal">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</main>

<%-- js 文件--%>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-editable.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-editable.js"></script>
<script src="${pageContext.request.contextPath}/js/attraction/forUserList.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/feedback/sse.js"></script>--%>
</body>
</html>