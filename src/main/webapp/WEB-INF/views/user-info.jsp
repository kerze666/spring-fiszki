<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 17.04.2017
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring 4 Security Example</title>
</head>
<body>
<h3>Logged In User Detail</h3>
<table>
    <tr><td>Name</td><td><c:out value="${user.username}"/></td></tr>
    <tr><td>Role</td><td><c:out value="${user.status}"/></td></tr>
</table>
<form action="<%=request.getContextPath()%>/logout" method="POST">
    <input type="submit" value="Logout"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
