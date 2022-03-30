<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <button type="button" class="btn btn-primary" onclick="location.href='/todo/new'" >Write</button>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">TODO</h5>
            </div>

            <c:forEach var="todo" items="${todo}">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${todo.title}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${todo.createDate}</h6>
                    <p class="card-text">${todo.name}</p>
                    <button type="button" class="btn btn-outline-primary"> ></button>
                </div>
            </div>
            </c:forEach>

        </div>
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">DOING</h5>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <button type="button" class="btn btn-outline-primary"> ></button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">DONE</h5>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>

                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>