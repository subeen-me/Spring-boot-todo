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
        <button type="button" class="btn btn-primary" onclick="location.href='/todo/new'">추가</button>
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
                            <button type="button" class="btn btn-outline-primary" onclick="todoEdit('${todo.id}')"
                                    data-bs-toggle="modal" data-bs-target="#editModal">수정
                            </button>
                            <button type="submit" class="btn btn-outline-primary"> >
                            </button>
                            <!--수정 모달-->
                            <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">내용 수정</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <!--수정 form-->
                                            <form>
                                                <input type="hidden" id="id" value="${todo.id}"/>
                                                <div class="mb-3">
                                                    <label for="title" class="col-form-label">해야 할 일</label>
                                                    <textarea class="form-control" id="title">${todo.title}</textarea>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="name" class="col-form-label">이름</label>
                                                    <input type="text" class="form-control" id="name"
                                                           value="${todo.name}">
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                닫기
                                            </button>
                                            <button type="button" class="btn btn-primary" onclick="stateUpdate('${todo.id}')">저장</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--수정 모달 end-->
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