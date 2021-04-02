<%-- 
    Document   : signup
    Created on : Apr 2, 2021, 2:09:32 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            body {
                background: linear-gradient(to right, #f953c6, #b91d73);
                display: flex;
                flex-direction: column;
                height: 100vh;
                justify-content: center;
                align-items: center;
            }

            form {
                color: white;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: stretch;
                padding: 40px;
                border-radius: 4%;
                background: #C6FFDD;
                background: -webkit-linear-gradient(to right, #f7797d, #FBD786, #C6FFDD);
                background: linear-gradient(to right, #f7797d, #FBD786, #C6FFDD);
            }

            .form-group {
                margin-bottom: 1rem;
                display: flex;
                gap: 15px;
                align-items: center;
                justify-content: center;
            }

            label {
                flex-basis:80px;
            }
        </style>
    </head>
    <body>
        <c:set var="isWrongPassword" value="${requestScope.isWrongPassword}" />
        <c:set var="isUsernameExisted" value="${requestScope.isUsernameExisted}" />
        

        <nav class="nav nav-tabs">
            <!--<p>A web page design by HuckFitler!</p>-->
            <li class="nav-item">
                <a class="nav-link" href="home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="signin">Login</a>
            </li>
        </nav>

        <form method="POST" action="signup">
            <div class="form-group">
                <label for="full name">
                    Full name
                </label>
                <input id="full name" type="text" name="fullname" required>
            </div>
            <div class="form-group">
                <label for="address">
                    Address
                </label>
                <input id="address" type="text" name="address" required>
            </div>

            <div class="form-group">
                <label for="phone">
                    Phone
                </label>
                <input id="phone" type="text" name="phone" required>
            </div>

            <div class="form-group">
                <label for="username">
                    Username
                </label>
                <input id="username" type="text" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">
                    Password
                </label>
                <input id="password" type="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">
                    Confirm password
                </label>
                <input id="confirmPassword" type="password" name="confirmPassword" required>
            </div>
            <button type="submit" class="btn btn-primary">Sign up</button>
        </form>

        <c:if test="${isWrongPassword != null}">
            <h1 class="alert alert-danger">Wrong name or password!</h1> 
        </c:if>
            <c:if test="${isUsernameExisted != null}">
            <h1 class="alert alert-danger">Sign up failed - Username existed!</h1> 
        </c:if>
    </body>
</html>
