<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!doctype html>
<html lang="en">
<head>
    <title>Авторизация</title>
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
    <div class="card">
        <c:if test="${not empty errorMessage}">
            <div style="color:#ff0000; padding-left: 10px; font-weight: bold; margin: 30px 0;">
                <c:out value="${errorMessage}:"/>
            </div>
        </c:if>
    </div>
    <div class="container">
        <form name="login" action="<c:url value='/login'/>" method="POST">
            <div class="form-group row">
                <label for="name" class="col-sm-6 col-form-label">Login</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-6 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password" placeholder="Password">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <a href="<c:url value='/reg'/>">Зарегистрироваться</a>

        </form>
    </div>
</div>
</body>
</html>