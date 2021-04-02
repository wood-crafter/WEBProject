<%-- 
    Document   : bill-manager
    Created on : Mar 31, 2021, 1:43:24 AM
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
        <c:set var="bills" value="${requestScope.bills}" />
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        
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

        <c:if test="${bills != null}">
            <table style="width:100%" border="1"> 
                <tr>
                    <th>Bill Id</th>
                    <th>Customer Name</th>
                    <th>Date</th>
                    <th>Total</th>
                    <th>Status</th>
                    <th>View</th>

                </tr>
                <c:forEach var="bill" items="${bills}">
                    <tr>
                        <td>${bill.getId()}</td>
                        <td>${bill.getRecName()}</td>
                        <td>${bill.getCreateDate()}</td>
                        
                        <td><fmt:formatNumber type="currency" value="${bill.getTotalAmount()}" /></td>
                        <c:if test="${bill.isStatus() == false}"><td>Wait</td></c:if>
                        <c:if test="${bill.isStatus() == true}"><td>Done</td></c:if>
                        <td><a href="billDetail?id=${bill.getId()}&status=${bill.isStatus()}">Detail</a></td>
                    </tr>
                </c:forEach>
            </table> 
        </c:if>
    </body>
</html>
