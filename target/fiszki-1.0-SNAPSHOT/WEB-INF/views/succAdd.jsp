<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Succes !</title>
    </head>
    <body>
        <h1>Właśnie dodałeś słowo : </h1><br>
        <h1>${polski} - ${angielski}</h1><br>
        <a href="/">Powrót na stronę główną</a> | <a href="/save">Dodaj nowe słowo</a>
    </body>
</html>