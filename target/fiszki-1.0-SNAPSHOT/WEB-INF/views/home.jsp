<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <title>Portal do nauki języka angielskiego na podstawie 1001 najczęściej używanych słów !</title>
</head>
<body>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading center-content-area">1000 najczęściej używanych słów w języku angielskim</h1>

            <c:if test="${!username.equals('anonymousUser')}">
                <h3>Witaj ${username}</h3>
                <c:if test="${!username.equals('admin')}">
                    <form action="/user">
                        <button>Moje konto</button>
                    </form>
                </c:if>
                <c:if test="${username.equals('admin')}">
                    <form action="/admin">
                        <button>Moje konto</button>
                    </form>
                </c:if>
                <form action="/logout">
                    <button>Wyloguj się</button>
                </form>

            </c:if>
            <c:if test="${username.equals('anonymousUser')}">
                <h3>Zarejestruj się bądź zaloguj !</h3>
                <form action="/login">
                    <button>Zaloguj się!</button>
                </form>
                <form action="/signin">
                    <button>Zarejestruj się!</button>
                </form>
            </c:if>

            <hr>
        </div>
    </div>
</header>
<section class="bg-primary" id="projekt">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">O projekcie</h2>
                <hr class="light">
                <p class="text-faded">Program został stworzony do nauki języka angielskiego z pomocą metody 1000
                    najczęściej używanych słów.
                    Twoim zadaniem będzie wpisywać odpowiednie angielskie odpowiedniki w polach które zostały do tego
                    stworzone.</p>
                <a href="/testcard" class="page-scroll btn btn-default btn-xl sr-button">Zacznij już teraz !</a>
                <a href="/list" class="page-scroll btn btn-default btn-xl sr-button">Lista 1000 słów !</a>
            </div>
        </div>
    </div>
</section>
<hr>
<footer id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <p class="section-heading">Kontakt</p>
                <hr class="primary">
                <p>W razie problemów proszę pisać na e-maila. Postaram się odpisywać </p>
            </div>
            <div class="col-lg-4 col-lg-offset-2 text-center">
                <i class="fa fa-phone fa-3x sr-contact"></i>
                <p>Autor: Bartłomiej Świeczak</p>
            </div>
            <div class="col-lg-4 text-center">
                <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                <p><a href="mailto:your-email@your-domain.com">bartekswieczak@o2.pl</a></p>
            </div>
        </div>
    </div>
</footer>


</body>
</html>
