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
    <title>ADMINISTRATOR / Dodaj użytownika</title>
</head>
<body>
<br>
<h2>Dodaj nowego użytkownika</h2>
<br>
<form action="./createUs" method="post">
    <div>Użytkownik: <input type="text" name="username" value="Jan Kowalski"><br>
        Adres email: <input type="text" name="email" value="kowalski@example.com"><br>
        Ustaw hasło: <input type="password" name="password"><br>
        Przypisz do grupy:
        <select name="user_group">
            <c:forEach var="group" items="${groups}">
                <option value="${group.id}">${group.name}</option>
            </c:forEach>
        </select>
        <input type="submit"></div>
</form>

</body>
</html>
