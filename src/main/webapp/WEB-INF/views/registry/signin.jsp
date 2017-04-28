<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Rejestracja</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
    <link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgo=">
</head>
<body>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading center-panel">Rejestracja</h1>
            <hr>
        </div>
    </div>
</header>
<section class="bg-primary">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <form:form action="signin" method="post">
                    <c:if test="${messageSucc != null}">
                        <c:out value="${messageSucc}"/><br>
                    </c:if>
                    <c:if test="${messageErr != null}">
                        <c:out value="${messageErr}"/><br>
                    </c:if>
                    <span>Nazwa użytkownika</span>
                    <input class="" type="text" name="username">
                    <hr class="light">
                    <span>Hasło</span>
                    <input class="" type="password" name="password">
                    <hr class="light">

                    <input type="submit" value="Załóż konto" onkeydown="enter">
                </form:form>
                <form action="/">
                    <button>Cofnij</button>
                </form>
                <form action="/login">
                    <button>Zaloguj się</button>
                </form>
            </div>
        </div>
    </div>
</section>

</body>
</html>


