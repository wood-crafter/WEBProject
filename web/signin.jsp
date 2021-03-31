<%-- 
    Document   : Signin
    Created on : Mar 22, 2021, 4:21:51 PM
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        <c:set var="firstRequest" value="${requestScope.firstRequest}" />
        <c:set var="user" value="${requestScope.user}" />
        <c:set var="admin" value="${requestScope.admin}" />


        <form method="POST" action="signin">
            <input type="text" name="username" required>
            <input type="password" name="password" required>
            <button type="submit">Login</button>
        </form>

        <c:if test="${firstRequest != null}">

            <c:if test="${user == admin}">
                <h1>Wrong name or password!</h1>
            </c:if>
            <c:if test="${user != null}">
                <c:redirect url="home.jsp" />
            </c:if>
            <c:if test="${admin != null}">
                <c:redirect url="home.jsp" />
            </c:if>
        </c:if>
    </body>
</html>
