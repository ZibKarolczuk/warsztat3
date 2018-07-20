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
    <title>Programming School</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<div><h2>Lista użytkowników:</h2></div>
<div>

    <table border="solid black 1px">
        <tr>
            <th>ID</th>
            <th>Nazwa użytkownika</th>
            <th>E-mail</th>
            <th>Grupa</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.group}</td>
                <td><a href="./updateUs?id=${user.id}&user=${user.username}&email=${user.email}&group=${user.group}">Edytuj</a> /
                    <a href="./deleteUs?id=${user.id}">Usuń</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"></td>
            <td><a href="./createUs">Dodaj użytkownika</a></td>
        </tr>
    </table>

</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
