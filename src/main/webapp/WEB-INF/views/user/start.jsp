<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="pl">
<head>
    <meta charset="UTF-8">

    <title>Portal do nauki języka angielskiego// admin panel</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
    <script href="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script href="<c:url value="/resources/js/libs/jquery/jquery-3.1.1.js"/>"></script>


    <style type="text/css">
        html, body, .container-table {
            height: 100%;
            width: 100%;
            margin: 0px;
            padding: 0px;
        }

        body {
            background-image: url("/resources/image/mountain.jpg");
            background-size: 100% auto;
        }

        @font-face {
            font-family: rebel;
            src: url("/resources/fonts/RebelRedux_v01a.ttf") format("truetype");
        }

        .container-table {
            display: table;
        }

        .vertical-center-row {
            display: table-cell;
            vertical-align: middle;
        }

        .wrapp {
            border-style: solid;
            border-width: 2px;
            border-color: white;
            border-bottom: none;
            border-top: none;
        }

        .main {
            /*background: #375D81;*/
            width: 100%;
            background: none;
            margin: -450px 0 0 0;
        }

        .category {
            margin-left: 10px;
        }

        .cat-button {
            margin-right: 10px;
        }

        .dodaj {
            border-style: solid;
            border-width: 2px;
            border-color: white;
            border-bottom: none;
            border-top: none;
            border-right: none;
        }

    </style>


</head>
<body>

<div class="header-content-inner">
    <section class="k1" id="k1">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 text-right"></div>
                <div class="col-lg-8 text-right">
                    <div class="heading text-right"><p><br><br></p><font color="white">Witaj ${user.username} </font>
                        <form action="/logout">
                            <button type="submit" class="btn btn-xs">Wyloguj się!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<div class="container-fluid container-table">
    <div class="row vertical-center-row">
        <section class="main" id="projekt">
            <div class="container">
                <div class="row">
                    <hr class="light">
                    <p><font size="4" color="white">Panel Użytkownika</font></p>
                    <hr class="light">
                    <br><br>
                    <div class="dodaj col-lg-4 text-center"><a href="/user/addcategory"
                                                               class="btn btn-primary btn-default"><span
                            class="glyphicon glyphicon-plus"></span>Dodaj kategorię</a><br><br><br><br><br><br><br><br>
                    </div>
                    <div class="col-lg-8 text-right">
                        <div class="wrapp">
                            <c:forEach var="cat" items="${categories}">
                                <div class="category text-left"><font size="4" color="white">${cat.category}</font>
                                </div>
                                <div class="cat-button">

                                    <form action="/user/deleteCategory/${cat.id}" method="post">
                                        <input class="btn btn-default btn-sm" type="submit" value="Usuń kategorię">
                                    </form>
                                    <form action="/user/wordslist" method="get">
                                        <input hidden type="text" value="${cat.id}" name="idCat">
                                        <input class="btn btn-default btn-sm" type="submit" value="Lista słowek">
                                    </form>
                                    <form action="/user/addword" method="get">
                                        <input hidden type="text" value="${cat.id}" name="idCat">
                                        <input class="btn btn-default btn-sm" type="submit" value="Dodaj słowka">
                                    </form>

                                    <form action="/user/testcategory" method="get">
                                        <input hidden type="text" value="${cat.id}" name="idCat">
                                        <input class="btn btn-default btn-sm" type="submit" value="Testuj">
                                    </form>
                                </div>
                                <hr class="light">
                            </c:forEach>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </div>
</div>
</body>
</html>
