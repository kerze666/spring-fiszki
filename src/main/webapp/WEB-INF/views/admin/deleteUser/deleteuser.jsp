<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 11.02.2017
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuwanie użytkowników</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Nazwa użytkownika</th>
        <th>Status</th>
        <th></th>
    </tr>

    <c:forEach items="${userlist}" var="lista">
        <tr>
            <td>${lista.id}</td>
            <td>${lista.username}</td>
            <td>${lista.status}</td>
        <form action="/admin/delete/${lista.id}" method="get">
            <td><input type="submit" value="Usuń"></td>
        </form>
        </tr>
    </c:forEach>

</table>
</body>
</html>