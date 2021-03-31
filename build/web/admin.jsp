<%-- 
    Document   : admin
    Created on : Mar 26, 2021, 3:09:35 AM
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
        <c:set var="admin" value="${sessionScope.admin}" />
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />

        <c:if test="${passedServlet == null}">
            <c:redirect url="admin" />
        </c:if>

        <nav class="navbar navbar-default">
            <!--<p>A web page design by HuckFitler!</p>-->
            <h1>Welcome ${user.getUsername()}</h1>

            <c:if test="${admin == null}">
                <a href="signin">Login</a>
                <a href="home">Back to home page</a>
            </c:if>

            <c:if test="${admin != null}">
                <a href="signout">Logout</a>
                <a href="addProduct">Add product</a>
                <a href="updateProduct">Update product</a>
                <a href="billManager">Bill Manager</a>
            </c:if>
        </nav>
    </body>
</html>
