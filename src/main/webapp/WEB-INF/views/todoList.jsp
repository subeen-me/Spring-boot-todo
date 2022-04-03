<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1" onclick="location.href='/'"/>TODO-LIST</span>
        <button type="button" class="btn btn-primary" onclick="location.href='/todo/new'">Write</button>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">TODO🧐</h5>
            </div>
            <c:forEach var="todo" items="${todo}">
                <c:if test="${todo.status.val eq 'todo'}">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${todo.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${todo.createDate}</h6>
                            <p class="card-text">${todo.name}</p>
                            <button type="submit" class="btn btn-outline-primary" onclick="stateUpdate('${todo.id}')"> >
                            </button>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="col">
            <div class="card-body">
                <h5 class="card-title">DOING😆</h5>
            </div>
            <c:forEach var="todo" items="${todo}">
                <c:if test="${todo.status.val eq 'doing'}">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${todo.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${todo.createDate}</h6>
                            <p class="card-text">${todo.name}</p>
                            <button type="submit" class="btn btn-outline-primary" onclick="stateUpdate('${todo.id}')"> >
                            </button>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">DONE😎</h5>
            </div>
            <c:forEach var="todo" items="${todo}">
                <c:if test="${todo.status.val eq 'done'}">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${todo.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${todo.createDate}</h6>
                            <p class="card-text">${todo.name}</p>
                            <button type="button" class="btn-close" style="float:right;" aria-label="Close"
                                    onclick="todoDelete('${todo.id}')"></button>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="/js/todoList.js"></script>
</body>
</html>