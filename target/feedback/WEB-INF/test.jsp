<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/12
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${test}</title>
</head>
<body>
    Hello World!
    <button id="deptExcel">生成部门数据</button>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script>
    $(function () {
        $("#deptExcel").click(function () {
            var url="/dept/testG";
            window.open(url);
        });
    })
</script>
</body>
</html>
