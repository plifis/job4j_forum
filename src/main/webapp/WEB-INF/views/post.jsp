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
    Login as : ${user.username}
    <a href="<c:url value='/logout'/>">Exit</a>
</div>
<div class="container">
    <div class="media-block">
        <a class="media-left" id="name"><c:out value="${post.name}"/></a>
    </div>
    <div class="page-header">
        <h1><c:out value="${post.description}"/></h1>
    </div>
    <c:forEach var="comment" items="${comments}">
        <div class="media-body">
            <div class="mar-btm">
            <a href="#" class="btn-link text-semibold media-heading box-inline">Автор: <c:out value="${comment.author}"/></a>
                <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> Дата: <c:out value="${comment.created.time}"/></p>
            </div>
            <p><c:out value="${comment.comment}"/></p>

        </div>
    </c:forEach>
    <form action="<c:url value='/comment?id=${post.id}'/>" method='POST'>
        <div class="form-group">
            <label class="form-control">Комментировать</label>
            <input type="text" class="form-control" name="comment" value="">
            <input type="text" class="form-control" name="author" hidden>
        </div>
        <div class="form-group">
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </div>
    </form>
</div>

</body>
</html>