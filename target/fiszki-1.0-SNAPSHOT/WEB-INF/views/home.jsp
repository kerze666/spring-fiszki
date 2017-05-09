<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Portal do nauki języka angielskiego na podstawie 1001 najczęściej używanych słów !</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <script href="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script href="<c:url value="/resources/js/libs/jquery/jquery-3.1.1.js"/>"></script>
    <style type="text/css">
        html, body, .container-table {
            height: 100%;
            width: 100%;
            margin: 0px;
            padding: 0px;
        }

        @font-face {
            font-family: rebel;
            src: url("/resources/fonts/RebelRedux_v01a.ttf") format("truetype");

        }

        body {
            background-image: url("/resources/image/mountain.jpg");
            background-size: 100% auto;
            font-family: yorkbailehill;

        }

        .container-table {
            display: table;
        }

        .vertical-center-row {
            display: table-cell;
            vertical-align: middle;
        }

        .header-content-inner {
            /*background: white;*/
        }

        .bg-primary {
            /*background: #375D81;*/
            width: 100%;
            background: none;
            margin: -110px 0 0 0;
        }

        .demo-content {
            /*  background: #375D81;*/
        }

        .section-heading {
            font-family: rebel;
            font-size: 25px;
            /*  background: #375D81;*/
        }

        .bar {
            background-color: white;
            height: 65px;
            width: 2px;
            margin: auto;
        }


    </style>


</head>
<body>


<header>
    <div class="header-content-inner">

        <c:if test="${!username.equals('anonymousUser')}">
            <section class="k1" id="k1">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 text-center">
                        </div>
                        <div class="col-lg-8">
                            <div class="demo-content bg-alt text-right"><p><br><br></p><font
                                    color="white">Witaj ${username}, wejdź na </font>
                                <c:if test="${username.equals('admin')}">
                                    <form action="${pageContext.request.contextPath}/admin">
                                        <button type="submit" class="btn btn-xs">Moje konto!</button>
                                    </form>
                                </c:if>
                                <c:if test="${!username.equals('admin')}">
                                    <form action="${pageContext.request.contextPath}/user">
                                        <button type="submit" class="btn btn-xs">Moje konto!</button>
                                    </form>
                                </c:if>
                                <font color="white"> lub </font>
                                <form action="${pageContext.request.contextPath}/logout">
                                    <button type="submit" class="btn btn-xs">Wyloguj się!</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>

        <c:if test="${username.equals('anonymousUser')}">
            <section class="k1" id="k1">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 text-center">
                        </div>
                        <div class="col-lg-8">
                            <div class="demo-content bg-alt text-right"><p><br><br></p><font color="white">Posiadasz
                                konto? </font>
                                <form action="${pageContext.request.contextPath}/login">
                                    <button type="submit" class="btn btn-xs" onclick="">Zaloguj się!</button>
                                </form>
                                <font color="white"> lub </font>
                                <form action="${pageContext.request.contextPath}/signin">
                                    <button type="submit" class="btn btn-xs">Zarejestruj!</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>

    </div>

</header>

<div class="container-fluid container-table">
    <div class="row vertical-center-row">

        <section class="bg-primary" id="projekt">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 text-center">
                        <h2 class="section-heading"><font color="white">1000 najczęściej używanych słów w języku
                            angielskim i nie tylko</font></h2>
                        <hr class="light">
                        <p class="text-faded"><font color="white">Aplikacja została stworzona na potrzeby edukacyjne. Do
                            celów demonstracyjnych udostępniony został test z 1000 najczęściej używanych słow w języku
                            angielskim. Zachęcam do zarejestrowania się oraz do zalogowania w celu wykorzystania pełni
                            aplikacji. Zalogowanie się daje możliwość wprowadzanie własnych kategorii, dodawanie słówek
                            oraz testowanie ich.</font></p>
                        <a href="/testcard" class="btn btn-primary btn-default"><span
                                class="glyphicon glyphicon-pencil"></span>
                            Zacznij już teraz!</a>
                        <a href="/list" class="btn btn-primary btn-default"><span
                                class="glyphicon glyphicon-list-alt"></span> Lista 1000 słów!</a>
                        <p><br></p>
                    </div>
                </div>
            </div>
            <div class="bar"></div>
            <div><p></p></div>
        </section>

        <footer id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 text-center">
                        <p class="section-heading"><font color="white" size="4"><img src="/resources/image/kontakt.png"></font>
                        </p>
                    </div>
                    <div class="col-lg-4 col-lg-offset-2 text-center">
                        <i class="fa fa-phone fa-3x sr-contact"></i>
                        <hr>
                        <p><font color="white">Autor: Bartłomiej Świeczak</font></p>
                    </div>
                    <div class="col-lg-4 text-center">
                        <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                        <hr>
                        <p><a href="mailto:your-email@your-domain.com"><font
                                color="white">bartekswieczak@o2.pl</font></a></p>
                    </div>
                </div>
            </div>
        </footer>


    </div>
</div>
</body>
</html>