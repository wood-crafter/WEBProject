<%-- 
    Document   : home.jsp
    Created on : Mar 22, 2021, 5:19:51 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        <c:set var="user" value="${sessionScope.user}" />
        <c:set var="categories" value="${requestScope.categories}" />
        <c:set var="productsOfCategory" value="${requestScope.productsOfCategory}" />

        <c:if test="${passedServlet == null}">
            <c:redirect url="home" />
        </c:if>
        <%--<c:set var="user" value="${sessionScope.user}" />--%>
        <nav class="navbar navbar-default">
            <!--<p>A web page design by HuckFitler!</p>-->
            <h1>Welcome ${user.getUsername()}</h1>

            <c:if test="${user == null}">
                <a href="signin">Login</a>
            </c:if>

            <c:if test="${user != null}">
                <a href="signout">Logout</a>
            </c:if>

            <a href="signup">Signup</a>
            
            <c:if test="${user != null}">
                <a href="showCart">Show Cart</a>
            </c:if>
        </nav>



        <c:if test="${categories != null}">
            <table style="width:100%"> 
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <th rowspan=${productsOfCategory.getNumberOfProduct(category)}>${category.categoryName}</th>
                        <td>${productsOfCategory.getProductList(category).get(0).productName}</td>
                        <c:if test="${user != null}">
                            <td><a href="addToCart?id=${productsOfCategory.getProductList(category).get(0).id}">Add to cart</a></td>
                        </c:if>
                    </tr>
                    <c:forEach var="product" items="${productsOfCategory.getProductList(category)}">

                        <c:if test="${!product.id.equals(productsOfCategory.getProductList(category).get(0).id)}">
                            <tr>
                                <td>${product.getProductName()}</td>
                                <c:if test="${user != null}">
                                    <td><a href="addToCart?id=${product.id}">Add to cart</a></td>
                                </c:if>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </table> 
        </c:if>
    </body>
</html>
