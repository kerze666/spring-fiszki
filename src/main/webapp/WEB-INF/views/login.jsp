<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 17.04.2017
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring 4 Security Example</title>
</head>
<body>
<h3>Spring 4 Security Example</h3>
<font color="red">
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
</font>
<form action="<%=request.getContextPath()%>/login" method="POST">
    Enter UserName:	<input type="text" name="username"/><br/><br/>
    Enter Password: <input type="password" name="password"/> <br/><br/>
    <input type="submit" value="Login"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>

