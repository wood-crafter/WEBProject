<%-- 
    Document   : show-cart
    Created on : Mar 24, 2021, 2:54:40 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                background: #ada996;
                background: -webkit-linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);
                background: linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);
            }
        </style>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.user}" />
        <c:set var="productsInCart" value="${sessionScope.productsInCart}" />

        <nav class="nav nav-tabs">
            <!--<p>A web page design by HuckFitler!</p>-->
            <li class="nav-item">
                <a class="nav-link" href="home">Home</a>
            </li>

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

        <c:if test="${user == null}">
            <h1 style="color:Tomato;">You must login to see your cart!</h1>
            <a href="signin">Login</a>
            <a href="signup">Signup</a>
        </c:if>


        <c:if test="${productsInCart == null}">
            <h1 style="color:Tomato;">There is no product in your cart!</h1>
        </c:if>

        <c:if test="${productsInCart != null}">
            <form method="POST" action="updateCart">
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Remove</th>
                        <th>Check out</th>
                    </tr>

                    <c:forEach var="productInCart" items="${productsInCart}">
                        <tr>
                            <td>${productInCart.getId()}</td>
                            <td>${productInCart.getProductName()}</td>
                            <td>
                                <input
                                    type="number"
                                    name="${productInCart.getId()}"
                                    value="${productInCart.getQuantity()}"
                                    min="1"
                                    max="100"
                                    required
                                    style="width: 50px;"
                                    >
                            </td>
                            
                            <td><fmt:formatNumber type="currency" value="${productInCart.getPrice()}" /></td>
                            <td><fmt:formatNumber type="currency" value="${productInCart.getTotal()}" /></td>
                            <td><a href="removeFromCart?id=${productInCart.getId()}">Remove</a></td>
                            <td><a href="checkout?id=${productInCart.getId()}">Check out</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <button class="btn btn-info" type="submit">Update</button>
                        </td>
                        <td>
                            <a href="removeFromCart?id=removeAll">Remove all</a>
                        </td>
                        <td>
                            <a href="checkout?id=checkoutAll">Check out all</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </body>
</html>
