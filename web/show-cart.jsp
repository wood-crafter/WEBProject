<%-- 
    Document   : show-cart
    Created on : Mar 24, 2021, 2:54:40 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.user}" />
        <c:set var="productsInCart" value="${sessionScope.productsInCart}" />

        <c:if test="${user == null}">
            <p>You must login to see your cart!</p>
            <a href="signin">Login</a>
            <a href="signup">Signup</a>
        </c:if>


        <c:if test="${productsInCart == null}">
            There is no product in your cart!
            <a href="home">Back to home page</a>
        </c:if>

        <c:if test="${productsInCart != null}">
            <form method="POST" action="updateCart">
                <table style="width:100%">
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
                            <td><input type="number" name=${productInCart.getId()} value="${productInCart.getQuantity()}" min="1" required></td>
                            <td>${productInCart.getPrice()}</td>
                            <td>${productInCart.getTotal()}</td>
                            <td><a href="removeFromCart?id=${productInCart.getId()}">Remove</a></td>
                            <td><a href="checkout?id=${productInCart.getId()}">Check out</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="submit">Update</button>
            </form>
            <a href="removeFromCart?id=removeAll">Remove all</a>
            <a href="checkout?id=checkoutAll">Check out all</a>
        </c:if>
    </body>
</html>
