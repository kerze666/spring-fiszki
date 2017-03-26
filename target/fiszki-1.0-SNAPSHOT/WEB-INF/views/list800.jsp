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
    <title>600-800 Words</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Angielski</th>
        <th>Polski</th>
    </tr>
     <c:forEach items="${list}" var="lista">
        <tr>
            <td>${lista.id}</td>
            <td>${lista.angielski}</td>
            <td>${lista.polski}</td>

        </tr>
     </c:forEach>
    <a href="/400_600">400-600</a>|<a href="/800_1000">800-1000</a>
</table>
</body>
</html>