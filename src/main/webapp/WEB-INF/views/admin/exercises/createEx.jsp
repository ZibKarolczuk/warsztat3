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
    <title>ADMINISTRATOR / Dodaj ćwiczenie</title>
</head>
<body>
<br>
<h2>Dodaj nowe ćwiczenie</h2>
<br>
<form action="./createEx" method="post">
    <div>Wprowadź tytuł ćwiczenia: <input type="text" name="title" value="Tytuł..."><br><br>
        <textarea name="description" rows="20" cols="100">Szczegółowy opis...</textarea><br><br>
        <input type="submit"></div>
</form>

</body>
</html>
