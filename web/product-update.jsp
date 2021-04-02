<%-- 
    Document   : product-update
    Created on : Mar 26, 2021, 5:59:57 PM
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
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        <c:set var="productList" value="${requestScope.productList}" />
        <c:set var="isIdExisted" value="${requestScope.isIdExisted}" />


        <c:if test="${isIdExisted != null}">
            <p>Update failed! - Id existed!</p>
        </c:if>

        <nav class="nav nav-tabs">
            <!--<p>A web page design by HuckFitler!</p>-->
            <li class="nav-item">
                <a class="nav-link" href="home">Home</a>
            </li>

            <c:if test="${admin == null}">
                <li class="nav-item">
                    <a class="nav-link" href="signin">Login</a>
                </li>
            </c:if>

            <c:if test="${admin != null}">
                <li class="nav-item">
                    <a class="nav-link" href="signout">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addProduct">Add product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="updateProduct">Update product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="billManager">Bill Manager</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="admin">Back to admin main page</a>
                </li>
            </c:if>
        </nav>
        <c:if test="${productList != null}">
            <table class="table-striped"> 
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>image</th>
                    <th>description</th>
                    <th>status</th>
                    <th>Category ID</th>
                    <th>Update</th>

                </tr>
                <c:forEach var="product" items="${productList}">
                    <tr>
                    <form method="POST" action="updateProduct?previousId=${product.getId()}" enctype="multipart/form-data">
                        <td>${product.getId()}</td>
                        <td><input type="text" name="name" value="${product.getProductName()}" required></td>
                        <td><input type="number" name="quantity" value="${product.getQuantity()}" min="0"  required></td>
                            <%--<fmt:formatNumber type="number"--%> 
                                              <!--value="${product.getPrice()}"-->
                                              <!--var="price${product.getId()}"/>-->
                        <td><input type="number" name="price" value="${product.getPrice()}" min="0" required></td>
                        <td><input type="file" name="image" value="${product.getImage()}" required></td>
                        <td><input type="text" name="description" value="${product.getDescription()}" required></td>
                        <td><input type="checkbox" name="status" readonly checked='true'}></td>
                        <td><input type="text" name="cateId" value="${product.getCateID()}" required></td>
                        <td><button type="submit" class="btn btn-success">Update</button></td>
                    </form>
                </tr>
            </c:forEach>
        </table> 
    </c:if>
</body>
</html>
