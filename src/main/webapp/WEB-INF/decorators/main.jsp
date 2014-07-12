<%--
  Created by IntelliJ IDEA.
  User: luowei
  Date: 14-3-31
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><decorator:title default="唯为社区"/></title>

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap3/css/bootstrap.min.css' />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap3/css/bootstrap-theme.min.css' />"/>

    <%--<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css' />"/>--%>

    <script type="text/javascript" src="<c:url value='/resources/js/jquery/jquery-2.1.0.min.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/resources/bootstrap3/js/bootstrap.min.js'/>"></script>

    <script src="<c:url value='/resources/js/validate/jquery.form.js'/>"></script>
    <script src="<c:url value='/resources/js/validate/jquery.validate.min.js'/>"></script>

    <script type="text/javascript">
        var ctx = '${pageContext.request.contextPath}';
    </script>

    <script src="<c:url value='/resources/js/main.js'/>"></script>

    <decorator:head/>
</head>
<body>
<div class="container">
    <decorator:body/>
</div>
<%--<div class="header">--%>
<%--<div class="header_inner">--%>
<%--<div style="float: right"><a href="${ctx}/auth/logout">登出</a></div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="sidebar">--%>
<%--<div class="sidebar_inner">--%>
<%--<div id="sidebar" class="ztree"></div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="content">--%>
<%--<div class="content_inner">--%>

<%--<decorator:body/>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="footer">--%>
<%--<div class="footer_inner">--%>
<%--<p class="copyright">&copy; 维唯社区版权所有</p>--%>
<%--</div>--%>
<%--</div>--%>
</body>
</html>