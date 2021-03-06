<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Panel Użytkownika - Aplikacja do nauki języka angielskego</title>

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
    <link href="<c:url value="/resources/css/panel.css"/>" rel="stylesheet">

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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="${pageContext.request.contextPath}/homepage">Start</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <span>Witaj ${user.username} </span>
                </li>
                <li>
                    <a class="page-scroll" href="${pageContext.request.contextPath}/logout">Wyloguj się!</a>
                </li>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <br><br><br>
                <c:if test="${message!=null}">
                    <h1 class="alert-danger">${message}</h1>
                </c:if>
                <br>
                <h3>
                    Panel Użytkownika
                </h3>
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/user/addcategory" class="btn btn-outline btn-xl page-scroll"> Dodaj nową kategorię ! </a>
                    </div>
                    <div class="col-md-9">

                        <table class="table">
                            <tbody>
                            <c:forEach var="cat" items="${adminWords}">
                            <tr>
                                <td>
                                    ${cat.category}
                                </td>
                                <td></td>
                                <td></td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/user/wordslist" method="get">
                                        <input hidden type="text" value="${cat.id}" name="idCat">
                                        <input class="btn btn-default btn-sm" type="submit" value="Lista słowek">
                                    </form>
                                </td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/user/testcategory" method="get">
                                        <input hidden type="text" value="${cat.id}" name="idCat">
                                        <input class="btn btn-default btn-sm" type="submit" value="Testuj">
                                    </form>
                                </td>
                            </tr>
                            </c:forEach>
                            <c:forEach var="cat" items="${categories}">
                                <tr>
                                    <td>
                                            ${cat.category}
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/user/deleteCategory/${cat.id}" method="post">
                                            <input class="btn btn-default btn-sm" type="submit" value="Usuń kategorię">
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/user/addword" method="get">
                                            <input hidden type="text" value="${cat.id}" name="idCat">
                                            <input class="btn btn-default btn-sm" type="submit" value="Dodaj słowka">
                                        </form>

                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/user/wordslist" method="get">
                                            <input hidden type="text" value="${cat.id}" name="idCat">
                                            <input class="btn btn-default btn-sm" type="submit" value="Lista słowek">
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/user/testcategory" method="get">
                                            <input hidden type="text" value="${cat.id}" name="idCat">
                                            <input class="btn btn-default btn-sm" type="submit" value="Testuj">
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</header>




<footer>
    <div class="container">
        <p>&copy; 2016 Start Bootstrap. All Rights Reserved.</p>
        <ul class="list-inline">
            <li>
                <a href="#">Privacy</a>
            </li>
            <li>
                <a href="#">Terms</a>
            </li>
            <li>
                <a href="#">FAQ</a>
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
