<%-- 
    Document   : product-update
    Created on : Mar 26, 2021, 5:59:57 PM
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
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        <c:set var="productList" value="${requestScope.productList}" />

        <c:if test="${passedServlet == null}">
            <c:redirect url="home" />
        </c:if>

        <c:if test="${productList != null}">
            <table style="width:100%"> 
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
                    <form method="POST" action="updateProduct">
                        <td><input type="text" name="id" value="${product.getId()}" required></td>
                        <td><input type="text" name="name" value="${product.getProductName()}" required></td>
                        <td><input type="number" name="quantity" value="${product.getQuantity()}" min="0"  required></td>
                        <td><input type="number" name="price" value="${product.getPrice()}" min="0" required></td>
                        <td><input type="text" name="image" value="${product.getImage()}" required></td>
                        <td><input type="text" name="description" value="${product.getDescription()}" required></td>
                        <td><input type="radio" name="status" value="${product.isStatus()}" required></td>
                        <td><input type="text" name="cateId" value="${product.getCateID()}" required></td>
                        <td><button type="submit">Update</button></td>
                    </form>
                </tr>
            </c:forEach>
        </table> 
    </c:if>
</body>
</html>
