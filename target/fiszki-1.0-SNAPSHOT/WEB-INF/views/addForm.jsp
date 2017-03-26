<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Save User Data</title>
</head>
<body>
<h3>Zapisz słowo do słownika</h3>
<form:form action="/save" method="post">
    Słowo Polskie:<input type="text" name="polski"> <br/>
    Słowo Angielskie :<input type="text" name="angielski"/><br/>
    <input type="submit" value="Dodaj"/>
</form:form>
<a href="/">Wróć do strony głownej</a>
</body>
</html>
