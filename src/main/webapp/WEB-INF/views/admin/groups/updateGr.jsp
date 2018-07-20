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
    <title>ADMINISTRATOR / Edytuj grupę</title>
</head>
<body>
<br>
<h2>Edycja grupy: ${groupName}</h2>
<br>
<form action="./updateGr" method="post">
    <div>Edytuj nazwę: <input type="text" name="editedName" value="${groupName}">
        <input type="submit"></div>
</form>

</body>
</html>
