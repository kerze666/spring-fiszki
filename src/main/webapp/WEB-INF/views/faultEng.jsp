
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
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
<section class="bg-danger">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h1 class="text-danger">ŹLE!</h1>
                <hr class="light">
                <h3>Twoja odpowiedź : ${answer}</h3>
                <hr class="light">
                <h3>Poprawnie:</h3>
                <h3>${word.polski} - ${word.angielski}</h3>
                <hr class="light">
                <a href="/testcard" class="page-scroll btn btn-default btn-xl sr-button">Następna fiszka !</a>
                <a href="/homepage" class="page-scroll btn btn-default btn-xl sr-button">Powrót do strony początkowej</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>


