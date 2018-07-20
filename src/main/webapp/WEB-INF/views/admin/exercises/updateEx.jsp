<%--
  Created by IntelliJ IDEA.
  User: zbigniew
  Date: 19.07.18
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ADMINISTRATOR / Edytuj ćwiczenie</title>
</head>
<body>
<br>
<h2>Edycja zadania: ${exerciseTitle}</h2>
<%--<h3>E-mail: ${email}<br>Należy do grupy: ${group}</h3>--%>
<br>

<%--<c:set var="content" value="${exerciseDescription}" />--%>
<%--<%  System.out.println(request.getParameter("exerciseDescription"));%>--%>

<%
    String val="This is your value";
    val = (String) request.getAttribute("exerciseDescription");
%>

<form action="./updateEx" method="post">
    <div>Zmień tytuł ćwiczenia: <input type="text" name="editedTitle" value="${exerciseTitle}"><br>
        <textarea name="editedDescription" rows="20" cols="100" >${exerciseDescription}</textarea><br><br>
        <input type="submit"></div>
</form>

</body>
</html>
