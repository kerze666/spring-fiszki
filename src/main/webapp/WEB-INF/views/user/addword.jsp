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
            <h1 id="homeHeading center-panel">Dodawanie Słówek</h1>
            <hr>
        </div>
    </div>
</header>
<section class="bg-primary">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <c:if test="${message!=null}">
                    <span>${message}</span>

                </c:if>

                <form:form action="addword" method="post">
                    <input hidden class="" type="text" name="idCat" value="${idCat}">
                    <span>Angielski</span>
                    <input class="" type="text" name="english">
                    <hr class="light">
                    <span>Polski</span>
                    <input class="" type="text" name="polish">
                    <hr class="light">
                    <input type="submit" value="Dodaj Słowo!" onkeydown="enter">
                </form:form>
                <form action="/user">
                    <button onkeydown="escape">Cofnij</button>>
                </form>
            </div>
        </div>
    </div>
</section>

</body>
</html>


