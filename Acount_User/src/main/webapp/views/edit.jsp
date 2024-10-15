<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 2/10/24
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>EDIT</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="<%=request.getContextPath()%>/user-servlet" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <div class="form-group">
        <label for="name">FULL NAME</label>
        <input type="text" class="form-control" name="name" id="name" value="${user.fullName}">
    </div>
    <div class="form-group">
        <label for="email">EMAIL</label>
        <input type="email" class="form-control" name="email" id="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="address">PASSWORD</label>
        <input type="text" class="form-control" name="address" id="address" value="${user.password}">
    </div>
    <div class="form-group">
        <label for="phone">PHONE</label>
        <input type="text" class="form-control" name="phone" id="phone" value="${user.phone}">
    </div>
    <div class="form-group">
        <label for="role">ROLE</label>
        <input type="text" class="form-control" name="role" id="role" value="${user.role}">
    </div>
    <div class="form-group">
        <label for="status">STATUS</label>
        <input type="text" class="form-control" name="status" id="status" value="${user.status}">
    </div>

    <input type="submit" name="action" value="edit">
</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
