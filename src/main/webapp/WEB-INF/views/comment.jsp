<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><c:out value="${post.name}"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <script src="scripts/scripts.js"></script>
    <link href="styles/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="container">
    <a href="<c:url value='/login'/>">Авторизация</a>
    Login as : ${user.name}
    <a href="<c:url value='/logout'/>">Exit</a>
</div>
<div class="container">
    <div class="form-group">
        <label class="form-check-label" id="name"><c:out value="${post.name}"/></label>
    </div>
    <div class="form-group">
        <label class="form-check-label" id="desc"><c:out value="${post.desc}"/></label>
    </div>
</div>
<div class="container">
        <form action="<c:url value='/comment?id=${post.id}'/>" method='POST'>
            <div class="form-group">
                <input type="text" class="form-control" name="comment" placeholder="...">
            </div>
            <div class="form-group">
                <input name="submit" type="submit" value="Сохранить" />
            </div>
        </form>
</div>

</body>
</html>