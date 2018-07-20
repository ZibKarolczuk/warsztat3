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
    <title>Solutions</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<%--<h2>${group}</h2>--%>
<div><h2>Szczegóły rozwiązania zadania:</h2></div>
<div>"${solution}"</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
