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

<div><h2>Lista grup:</h2></div>
<div>

    <table border="solid black 1px">
        <tr>
            <th>ID</th>
            <th>Nazwa grupy</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td><a href="./updateGr?id=${group.id}&group=${group.name}">Edytuj</a> /
                    <a href="./deleteGr?id=${group.id}">Usuń</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"></td>
            <td><a href="./createGr">Dodaj grupę</a></td>
        </tr>
    </table>

</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
