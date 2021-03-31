<%-- 
    Document   : bill-manager
    Created on : Mar 31, 2021, 1:43:24 AM
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
        <c:set var="bills" value="${requestScope.bills}" />
        <c:set var="passedServlet" value="${requestScope.passedServlet}" />
        
        <c:if test="${passedServlet == null}">
            <c:redirect url="billManager" />
        </c:if>

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
                        <td>${bill.getTotalAmount()}</td>
                        <c:if test="${bill.isStatus() == false}"><td>Wait</td></c:if>
                        <c:if test="${bill.isStatus() == true}"><td>Done</td></c:if>
                        <td><a href="billDetail?id=${bill.getId()}&status=${bill.isStatus()}">Detail</a></td>
                    </tr>
                </c:forEach>
            </table> 
        </c:if>
    </body>
</html>
