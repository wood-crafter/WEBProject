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
    </head>
    <body>
    <c:set var="billDetails" value="${requestScope.billDetails}" />
    <c:set var="passedServlet" value="${requestScope.passedServlet}" />
    <c:set var="status" value="${requestScope.status}" />
    <c:set var="id" value="${requestScope.id}" />

    <c:if test="${passedServlet == null}">
        <c:redirect url="billManager" />
    </c:if>

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

        <c:if test="${status == false}"><td><a href="billDetail?isDone=1&id=${id}">Change status to Done!</a></td></c:if>
    </c:if>
</body>
</html>
