<%-- 
    Document   : home.jsp
    Created on : Mar 22, 2021, 5:19:51 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            body {
                background-image: url(wallpaper.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                min-height: 100vh;
            }
            .product-list {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
                row-gap: 1rem;
            }

            .card-img-top {
                height: 300px;
                background-repeat: no-repeat;
                background-position: center;
                background-size: contain;
            }
        </style>
    </head>
    <body>
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        <c:set var="user" value="${sessionScope.user}" />
        <c:set var="categories" value="${requestScope.categories}" />
        <c:set var="products" value="${requestScope.products}" />

        <c:if test="${passedServlet == null}">
            <c:redirect url="home" />
        </c:if>
        <c:set var="user" value="${sessionScope.user}" />
        <nav class="nav nav-tabs">
            <!--<p>A web page design by HuckFitler!</p>-->
            <h3 style="color:Tomato;">Welcome ${user.getUsername()}</h3>

            <c:if test="${user == null}">
                <li class="nav-item">
                    <a class="nav-link" href="signin">Login</a>
                </li>
            </c:if>

            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="signout">Logout</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="signup">Signup</a>
            </li>

            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="showCart">Show Cart</a>
                </li>
            </c:if>
        </nav>

        <c:forEach items="${categories}" var="category">
            <a
                href="home?categoryId=${requestScope.categoryId == category.id ? "" : category.id}"
                class="badge badge-pill badge-${requestScope.categoryId == category.id ? "success" : "secondary"}"
                >
                ${category.categoryName}
            </a>
        </c:forEach>

        <div class="product-list">
            <c:forEach items="${products}" var="product">
                <div class="card" style="width: 360px">
                    <div
                        class="card-img-top"
                        style="background-image: url(image/${product.id}.png)"
                        ></div>
                    <div class="card-body">
                        <h4 class="card-title">
                            ${product.productName}
                        </h4>
                        <p class="card-text">
                            <fmt:formatNumber type="currency" value="${product.price}" />
                        </p>
                        <c:if test="${user != null}">
                            <a
                                href="addToCart?id=${product.id}"
                                class="btn btn-success"
                                >
                                Add to Cart
                            </a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>

        </div>
    </body>
</html>
