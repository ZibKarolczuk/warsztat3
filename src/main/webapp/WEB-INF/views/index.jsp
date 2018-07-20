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

<div><h2>Ostatnie rozwiązania:</h2></div>

<div>
    <table border="solid black 1px">

        <tr>
            <th>Tytuł zadania</th>
            <th>Autor rozwiązania</th>
            <th>Data dodania</th>
            <th>Akcje</th>
        </tr>

        <c:forEach var="solution" items="${lastSolutions}">
            <tr>
                <td>${solution.title}</td>
                <td>${solution.username}</td>
                <td>${solution.updated}</td>
                <td><a href="./solution?id=${solution.id}">Szczegóły</a></td>
            </tr>
        </c:forEach>

    </table>
</div>

<%@include file="/WEB-INF/views/fragments/footer.jspf" %>

</body>
</html>
