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

            form {
                max-width: 850px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <c:set var="isIdExisted" value="${requestScope.isIdExisted}" />


        <c:if test="${isIdExisted != null}">
            <p>Add failed! - Id existed!</p>
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

        <form method="POST" action="addProduct" enctype="multipart/form-data">
            <div class="form-group">
                <label for="id">Product ID</label>
                <input type="text" name="id" id="id" value="" required class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Product Name</label>
                <input type="text" name="name" id="name" value="" required class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Quantity</label>
                <input type="number" name="quantity" id="quantity" value="" min="1" required class="form-control" />
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" name="price" id="price" value="" min="0" required class="form-control" />
            </div>
            <div class="form-group">
                <label for="file">Image</label>
                <input type="file" name="file" id="file" value="" required class="form-control-file border" />
            </div>
            <div class="form-group">
                <label for="price">Description</label>
                <input type="text" name="descriptions" id="descriptions" value="" required class="form-control" />
            </div>
            <div class="form-group">
                <label for="price">Category Id</label>
                <input type="text" name="cateId" id="cateId" value="" min="0" required class="form-control" />
            </div>
            <tr>
                <td>
                    <input type="submit" class="btn btn-success" value="Add Product" /></td>
                <td><input type="reset" class="btn btn-warning" value="Clear" /></td>
            </tr>
            <input type="hidden" name="action" value="insert" />
        </form>
    </body>
</html>
