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
    <title>ADMINISTRATOR / Edytuj użytownika</title>
</head>
<body>
<br>
<h2>Edycja konta użytkownika: ${userName}</h2>
<h3>E-mail: ${email}<br>Należy do grupy: ${group}</h3>
<br>
<form action="./updateUs" method="post">
    <div>Edytuj nazwę użytkownika: <input type="text" name="editedName" value="${userName}"><br>
        Edytuj e-mail użytkownika: <input type="text" name="editedEmail" value="${email}"><br>
        <%--Resetuj hasło użytkownika: <input type="password" name="editedPassword"><br>--%>
        Przypisz do innej grupy:
        <select name="user_group">
        <c:forEach var="group" items="${groups}">
            <option value="${group.id}">${group.name}</option>
        </c:forEach>
        </select>
        <input type="submit"></div>
</form>

</body>
</html>
