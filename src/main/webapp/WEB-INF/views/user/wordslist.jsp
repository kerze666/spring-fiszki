<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 04.05.2017
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>lista słowek</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Angielski</th>
        <th>Polski</th>
    </tr>
    <c:forEach items="${listOfWords}" var="lista">
        <tr>
            <td>${lista.id}</td>
            <td>${lista.angielski}</td>
            <td>${lista.polski}</td>
        </tr>
    </c:forEach>
    <a href="/user">cofnij</a>
</table>
</body>
</html>
