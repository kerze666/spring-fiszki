<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 18.04.2017
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN HOME</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/logout" method="POST">
    <input type="submit" value="Logout"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
