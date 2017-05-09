
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgo=">
</head>
<body>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading center-panel">1000 najczęściej używanych słów w języku angielskim</h1>
            <hr>
        </div>
    </div>
</header>
<section class="bg-success">
    <div class="container">
        <div class="row">
            <div class="co l-lg-8 col-lg-offset-2 text-center">
                <h1 class="text-success">DOBRZE!</h1>
                <hr class="light">
                <h3>Twoja odpowiedź : ${answer}</h3>
                <hr class="light">
                <h3>${word.polski} - ${word.angielski}</h3>
                <hr class="light">
                <form action="/user/testcategory">
                    <input hidden class="" type="text" name="idCat" value="${word.catId}">
                    <input class="page-scroll btn btn-default btn-xl sr-button" type="submit" value="Następna fiszka!" onkeydown="enter">
                </form>
                <a href="/user" class="page-scroll btn btn-default btn-xl sr-button" onkeydown="escape">Wybierz nową kategorię!</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>


