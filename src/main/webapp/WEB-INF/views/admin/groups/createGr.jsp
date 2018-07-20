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
    <title>ADMINISTRATOR / Dodaj grupę</title>
</head>
<body>
<br>
<h2>Dodaj nową grupę</h2>
<br>
<form action="./createGr" method="post">
    <div>Dodaj nową grupę: <input type="text" name="group" value="nazwa grupy">
        <input type="submit"></div>
</form>

</body>
</html>
