<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.02.2022
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="form" style="border-radius: 10%; margin: 100px 200px; border: black 3px; background-color: aquamarine; padding: 10px 100px">
    <form action="/index" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" name="name" placeholder="Enter name">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div class="form-group">
            <label >Username</label>
            <input type="text" class="form-control" name="username" placeholder="Enter username">
            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div class="form-group">
            <label >Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password">
        </div>

        <div class="form-group">
            <label >Password</label>
            <input type="password" class="form-control" placeholder="RePassword">
        </div>

        <div class="file-field big-2">
            <div class="btn ">
                <input type="file" name="userImage">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
