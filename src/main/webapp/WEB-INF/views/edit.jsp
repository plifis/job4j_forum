<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Accident</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <link href="../../../styles/style.css">
</head>
<body>
<div class="container">
    <li><a href="<c:url value='/login'/>">Авторизация</a></li>
    <li><a href="<c:url value='/create'/>">Добавить тему</a></li>

    Login as : ${user.name}
    <a href="<c:url value='/logout'/>">Exit</a>
</div>
<div class="container">
<form action="<c:url value='/save?id=${post.id}'/>" method='POST'>
    <table class="table">
        <div class="form-group">
            <label>Название</label>
            <input type="text" class="form-control" name="name" value="<c:out value="${post.name}"/>">
        </div>
        <div class="form-group">
            <label>Описание</label>
            <input type="text" class="form-control" name="description" value="<c:out value="${post.description}"/>">
        </div>
        <div class="form-group">
            <label>Дата</label>
            <input type="text" class="form-control" name="created" value="<c:out value="${post.created}"/>" disabled>
        </div>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>