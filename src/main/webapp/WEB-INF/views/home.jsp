<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aplikacja do nauki języka angielskego</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/lib/simple-line-icons/css/simple-line-icons.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/lib/device-mockups/device-mockups.min.css"/>">

    <!-- Theme CSS -->
    <link href="<c:url value="/resources/css/new-age.css"/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">

<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="#page-top">Start</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <c:if test="${username.equals('anonymousUser')}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="${pageContext.request.contextPath}/login">Zaloguj się</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="${pageContext.request.contextPath}/registry">Zarejestruj się</a>
                    </li>
                </ul>
            </c:if>
            <c:if test="${!username.equals('anonymousUser')}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <span>Witaj ${username}, wejdź na </span>
                    </li>
                    <c:if test="${username.equals('admin')}">
                        <li>
                            <a class="page-scroll" href="${pageContext.request.contextPath}/admin">Moje konto</a>
                        </li>
                        <li>
                            <span> lub </span>
                        </li>
                        <li>
                            <a class="page-scroll" href="${pageContext.request.contextPath}/logout">Wyloguj się</a>
                        </li>
                    </c:if>
                    <c:if test="${!username.equals('admin')}">
                        <li>
                            <a class="page-scroll" href="${pageContext.request.contextPath}/user">Moje konto</a>
                        </li>
                        <li>
                            <span> lub </span>
                        </li>
                        <li>
                            <a class="page-scroll" href="${pageContext.request.contextPath}/logout">Wyloguj się</a>
                        </li>
                    </c:if>

                </ul>
            </c:if>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<header>
    <div class="container">
        <div class="row">
            <div class="col-sm-7">
                <div class="header-content">
                    <div class="header-content-inner">
                        <h1 id="unikalne">Aplikacja została stworzona na potrzeby edukacyjne. Do celów
                            demonstracyjnych udostępniony został test z 1000 najczęściej używanych słow w języku
                            angielskim. Zachęcam do zarejestrowania się oraz do zalogowania w celu wykorzystania pełni
                            aplikacji. Zalogowanie się daje możliwość wprowadzanie własnych kategorii, dodawanie słówek
                            oraz testowanie ich.</h1>
                        <br>
                        <a href="${pageContext.request.contextPath}/testcard"
                           class="btn btn-outline btn-xl page-scroll">Zacznij teraz</a>
                        <a href="${pageContext.request.contextPath}/list" class="btn btn-outline btn-xl page-scroll">Lista
                            1000 słowek</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="device-container">
                    <div class="device-mockup iphone6_plus portrait white">
                        <div class="device">
                            <div class="screen">
                                <!-- Demo image for screen mockup, you can put an image here, some HTML, an animation, video, or anything else! -->
                                <img src="<c:url value="/resources/img/demo-screen-1.jpg"/>" class="img-responsive"
                                     alt="">
                            </div>
                            <div class="button">
                                <!-- You can hook the "home button" to some JavaScript events or just remove it -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<footer>
    <div class="container">
        <p>Kontakt</p>
        <ul class="list-inline">
            <li>
                <a href="https://github.com/kerze666/">Github</a>
            </li>
            <li>
                <a href="#">e-mail: bartekswieczak@o2.pl</a>
            </li>
            <li>
                <a href="#">Autor: Bartłomiej Świeczak</a>
            </li>
        </ul>
    </div>
</footer>

<!-- jQuery -->
<script src="<c:url value="/resources/lib/jquery/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<!-- Theme JavaScript -->
<script src="<c:url value="/resources/js/new-age.min.js"/>"></script>

</body>

</html>
