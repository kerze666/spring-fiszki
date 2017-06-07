<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">

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
            <a class="navbar-brand page-scroll" href="${pageContext.request.contextPath}/homepage">Start</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<header>
    <div id="container_demo">
        <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
        <br><br><br>
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>
        <div id="wrapper">
            <div id="login" class="animate form">
                <form action="<%=request.getContextPath()%>/registry" method="POST">
                    <h1>Rejestracja</h1>
                    <c:if test="${messageSucc!=null}">
                        <h3 class="alert-success"> ${messageSucc} </h3>
                    </c:if>
                    <c:if test="${messageSucc==null && message!=null}">
                        <h3 class="alert-danger"> ${message} </h3>
                    </c:if>
                    <p>
                        <label for="username" class="uname"> Nazwa użytkownika </label>
                        <input class="input" id="username" name="username" required="required" type="text"
                               placeholder="nazwa użytkownika"/>
                    </p>
                    <p>
                        <label for="password" class="youpasswd"> Podaj hasło</label>
                        <input class="input" id="password" name="password" required="required" type="password"
                               placeholder="hasło"/>
                    </p>
                    <p>
                        <label for="password" class="youpasswd"> Powtórz hasło </label>
                        <input class="input" id="repassword" name="repassword" required="required" type="password"
                               placeholder="hasło"/>
                    </p>
                    <p class="login button">
                        <input class="btn btn-outline btn-xl page-scroll" type="submit" value="Zarejestruj się!">
                    </p>
                    Masz konto?
                    <br>
                    <a href="${pageContext.request.contextPath}/login"
                       class="btn btn-outline btn-xl page-scroll">Zaloguj się!</a>

                </form>
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
