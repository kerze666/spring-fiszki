
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fiszki</title>
</head>
<body>
    <div>Wybierz ile słówek chcesz wylosować :</div>
    <form:form action="/fiszki" method="post">
        Ilość fiszek<input type="text" name="count" >
        <input type="submit" value="Dalej..">
    </form:form>
    <a href="/homepage">HOME</a>
</body>
</html>
