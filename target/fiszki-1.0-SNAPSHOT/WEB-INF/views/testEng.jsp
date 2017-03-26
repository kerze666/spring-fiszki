<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 25.02.2017
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
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
            <h2 id="text-center">Fiszki Angielsko-Polskie</h2>
        </div>
    </div>
</header>
<section class="bg-primary">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <form:form action="/checkanswer" method="post">
                    <h2 class="section-heading">${word.polski}</h2>
                    <hr class="light">
                    <input type="hidden" name="id" value="${word.id}">
                    <input class="" type="text" name="answer">
                    <input type="submit" value="Zatwierdź odpowiedź" onkeydown="enter">
                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>


