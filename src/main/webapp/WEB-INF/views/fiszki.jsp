
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
    <a href="/homepage">HOME</a>
    <div>
        <c:forEach items="${map}" var="mapa">
            <span id="polski_${mapa.value.id}" hidden>${mapa.value.polski}</span>
            <span id="angielski_${mapa.value.id}" hidden>${mapa.value.angielski}</span>
            <span class="id" hidden>${mapa.value.id}</span>
        </c:forEach>
        <input id="input" type="text">
        <button id="confirm" type="submit">Zatwierdź odpowiedź</button>
        <button id="next" type="submit" hidden>Następna fiszki</button>
        <script defer>
            var index = 0, isCorrect = false, correctAnswer = 0, id;

            id = $(".id")[index].innerText;

            showDOM(id,"polski_",index);
            showDOM(id,"input_",index);

            $("#confirm").click(function() {
                id = $(".id")[index].innerText;
                if($("#angielski_"+id).text() == $("#input").val().toLowerCase()){
                    <!-- zielone tło z przeroczystością 50% i napisem OK-->
                    $("body").css({
                        "background" : "#aeff9e"
                });
                    isCorrect = true;
                    correctAnswer++;
                }else{
                    <!-- czerwone tło z przeroczystością 50% i poprawnym słowkiem-->
                    showDOM(id,"angielski_",index);
                    $("body").css({
                        "background" : "#ff3e3e"
                    });
                    isCorrect = false

                }
                $("#next").show();
            });

            $("#next").click(function() {
                $("#next").hide();
                $("body").css({
                    "background" : "white"
                });
                if(isCorrect){
                    <!-- było poprawne-->
                    deleteDOM(id,"polski_",index);
                    index++;
                    showDOM(id,"polski_",index);
                }else{
                    <!-- nie było poprawne -->
                    deleteDOM(id,"polski_",index);
                    deleteDOM(id,"angielski_",index);
                    index++;
                    showDOM(id,"polski_",index);
                }
                console.log(index);
            });

            function replay() {
                if(index == $(".id").length){
                    var answer = confirm("Twój wynik : "+correctAnswer+"/"+index+
                        "\n\nCzy chcesz zacząć jeszcze raz?");

                    if(answer){
                        window.history.back();
                    }else{
                        window.history.go(-2);
                    }
                }
            }
            function showDOM(id, tag, index) {
                try{
                    $("#"+tag+$(".id")[index].innerText).show();
                }catch (err){
                    replay();
                }
            }
            function deleteDOM(id, tag, index) {
                $("#"+tag+$(".id")[index].innerText).remove();
            }
        </script>
    </div>
</body>
</html>
