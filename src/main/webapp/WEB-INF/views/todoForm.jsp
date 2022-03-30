<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <span class="navbar-brand mb-0 h1" onclick="location.href='/'">TODO-LIST</span>
    </div>
</nav>

<div class="container-sm">

    <form action="/todo/new" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">해야 할 일</label>
            <input name="title" class="form-control" id="title" placeholder="어떤 일인지 알려주세요!">
            <p ></p>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">이름</label>
            <input name="name"class="form-control" id="name" placeholder="누가 할 일인가요?">
        </div>
        <button type="submit" class="btn btn-primary">제출</button>
    </form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>