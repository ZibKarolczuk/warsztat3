<%--
  Created by IntelliJ IDEA.
  User: zbigniew
  Date: 13.07.18
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>PANEL ADMINISTRATORA</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<div><h2>Panel Admina:</h2></div>

<div>
    <ul>
        <li><a href="./readEx">Zarządzaj zadaniami</a></li>
        <li><a href="./readGr">Zarządzaj grupami użytkowników</a></li>
        <li><a href="./readUs">Zarządzaj użytkownikami</a></li>
    </ul>
</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
