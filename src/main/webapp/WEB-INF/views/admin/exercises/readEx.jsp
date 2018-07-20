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
    <title>Przeglądaj zadania</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<div><h2>Lista ćwiczeń:</h2></div>
<div>

    <table border="solid black 1px">
        <tr>
            <th>ID</th>
            <th>Tytuł ćwiczenia</th>
            <th>Opis ćwiczenia</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="exercise" items="${exercises}">
            <tr>
                <td width="50">${exercise.id}</td>
                <td width="200">${exercise.title}</td>
                <td width="350">${exercise.description}</td>
                <td width="100"><a href="./updateEx?id=${exercise.id}&title=${exercise.title}">Edytuj</a> /
                    <a href="./deleteEx?id=${exercise.id}">Usuń</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3"></td>
            <td><a href="./createEx">Dodaj ćwiczenie</a></td>
        </tr>
    </table>

</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
