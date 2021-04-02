<%-- 
    Document   : bill-detail
    Created on : Mar 31, 2021, 2:03:34 AM
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
                background: #ada996;
                background: -webkit-linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);
                background: linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);
            }
        </style>
    </head>
    <body>
    <c:set var="billDetails" value="${requestScope.billDetails}" />
    <c:set var="passedServlet" value="${requestScope.passedServlet}" />
    <c:set var="status" value="${requestScope.status}" />
    <c:set var="id" value="${requestScope.id}" />

    <c:if test="${passedServlet == null}">
        <c:redirect url="billManager" />
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

    <c:if test="${billDetails != null}">
        <table style="width:100%" border="1"> 
            <tr>
                <th>Bill Id</th>
                <th>Product Id</th>
                <th>Quantity</th>
                <th>Price</th>

            </tr>
            <c:forEach var="billDetail" items="${billDetails}">
                <tr>
                    <td>${billDetail.getBillId()}</td>
                    <td>${billDetail.getProductID()}</td>
                    <td>${billDetail.getQuantity()}</td>
                    <td>${billDetail.getPrice()}</td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${status == false}">
            <td><a href="billDetail?isDone=1&id=${id}" class="text-danger">Change status to Done!</a>
        </td></c:if>
    </c:if>
</body>
</html>
