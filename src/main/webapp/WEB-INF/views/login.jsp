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
    <title>Logowanie</title>
</head>
<body>
<h3>Logowanie</h3>
<font color="red">
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
</font>
<form action="<%=request.getContextPath()%>/login" method="POST">
    Nazwa uzytknownika:	<input type="text" name="username"/><br/><br/>
    Hasło: <input type="password" name="password"/> <br/><br/>
    <input type="submit" value="Login"/>
</form>
<form action="/">
    <button>Cofnij</button>
</form>
</body>
</html>

