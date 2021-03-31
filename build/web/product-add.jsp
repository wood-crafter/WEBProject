<%-- 
    Document   : product-add
    Created on : Mar 26, 2021, 3:23:50 AM
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
        <form method="POST" action="addProduct" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Product ID</td>
                    <td><input type="text" name="id" value="" required /></td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td><input type="text" name="name" value="" required/></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="number" name="quantity" value="" min="1" required/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="number" name="price" value="" min="0" required/></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <input type="file" name="file" />
                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="descriptions" value="" required/></td>
                </tr>
                <tr>
                    <td>Category Id</td>
                    <td><input type="text" name="cateId" value="" required/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Add Product" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
            <input type="hidden" name="action" value="insert" />
        </form>

        <a href="admin">Back to admin main page</a>
    </body>
</html>
