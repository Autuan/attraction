<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">

    <title>查询已提交内容</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <style>
        .table-btn{
            margin-top: 5px;
        }
        .redClass{
            color:red;
        }
        .greenClass{
            color: green;
        }
        .tile{
            height: 1250px;
            overflow:visible;
            /*height:100%*/
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
                    <table id="blogTable"></table>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" value="${userInfo}" id="userInfo">
    <input type="hidden" value="${userId}" id="userId">

    <div id="toolbar" class="btn-group">
        <span id="choosePushManTip"> &nbsp;&nbsp;选择提交人:</span>
        <select id="selectDept">
            <option>---请选择部门---</option>
        </select>
        <select id="selectPushMan">
            <option>---请先选择部门---</option>
        </select>
        &nbsp;&nbsp;
        <span>选择任务状态:</span>
        <select id="selectStatus">
        </select>
        &nbsp;&nbsp;
        <button class="btn btn-default btn-xs" id="refreshBtn">
            <span class="glyphicon glyphicon-refresh"></span>
        </button>
        &nbsp;&nbsp;
        <button class="btn btn-default btn-xs" id="saveBtn">
            <span class="glyphicon glyphicon-floppy-save"></span>
        </button>
        &nbsp;&nbsp;
    </div>

    <!-- 信息删除确认 -->
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteDeptId" />
                    <p>您确认要这么做吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="url"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button"  onclick="deleteDept()" class="btn btn-success" data-dismiss="modal">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>

    <div th:fragment="myModal">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="chapterListUpload"></h4>
                    </div>
                    <div class="modal-body" >
                       <div id="modalBody" class="magnify"></div>
                        <hr>
                        <form class="form-horizontal" role="form" id="replyForm">
                            <input type="hidden" id="feedbackId">
                            <div class="form-group">
                                <label for="editorArea" id="tipLabel">请在此输入回复内容:</label>
                                <%--<div class="col-sm-10">--%>
                                    <div id="editorArea">

                                    </div>
                                <%--</div>--%>
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button"  id="publishBtn" class="btn btn-success" data-dismiss="modal">回复</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>


        <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id=""></h4>
                    </div>
                    <div class="modal-body" >
                        <div id="updateModalBody" class="magnify"></div>
                        <hr>
                        <form  role="form" id="updateModalForm">
                            <input type="hidden" id="updateModalFeedbackId" name="feedbackId">
                            <input type="hidden" id="updateModalFeedbackContent" name="feedbackContent">

                            <div class="form-group">
                                <label for="updateFeedbackTitle">请输入修改后标题:</label>
                                <input type="text" name="feedbackTitle" id="updateFeedbackTitle"/>
                            </div>
                            <div class="form-group">
                                <label for="updateModalDept">重新选择提交人:</label>
                                <select  id="updateModalDept">
                                    <option>---请选择部门---</option>
                                </select>
                                <select name="feedbackPushMan" id="updateModalPushMan" name="feedbackPushMan">
                                    <option>---请先选择部门---</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="updateModalFeedbackPictures">重新选择提交对象:</label>
                                    <select name="feedbackPictures" id="updateModalFeedbackPictures" class="technologyList">
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="updateModalFeedbackActiveMan">重新选择执行人:</label>
                                <select name="activeManName" id="updateModalFeedbackActiveMan" class="technologyList">
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="updateModalEditorArea">修改提交内容:</label>
                                <div id="updateModalEditorArea"></div>
                            </div>

                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button"  id="updateBtn" class="btn btn-success" data-dismiss="modal">确认修改</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
</main>

<%-- js 文件 --%>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/feedback/sse.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/feedback/forBugList.js"></script>
<script>
    $("#refreshBtn").click(function () {
        $("#blogTable").bootstrapTable('refresh');
    });
</script>
</body>
</html>