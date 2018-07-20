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
    <title>Users</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<div><h2>Lista użytkowników grupy: ${group}</h2></div>
<div>
    <table border="solid black 1px">
        <tr>
            <th>Nazwa</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td><a href="./solutions?id=${user.id}&username=${user.username}&email=${user.email}">Szczegóły</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
