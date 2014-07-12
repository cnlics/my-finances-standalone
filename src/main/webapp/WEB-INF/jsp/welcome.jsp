<%--
  Created by IntelliJ IDEA.
  User: luowei
  Date: 2014/7/12
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <h2>首页</h2>
    <hr/>
    <a class="btn btn-success" href="${ctx}/finance/list">账单列表</a>
</div>
</body>
</html>
