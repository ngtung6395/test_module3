<%--
  Created by IntelliJ IDEA.
  User: Latitude 5590
  Date: 08/06/2021
  Time: 3:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <table border="1px">
        <caption><h2>List Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Color</th>
            <th>Quantity</th>
            <th>Description</th>
            <th>Category</th>
        </tr>
        <c:forEach items ="${productList}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.price}</td>
                <td>${list.color}</td>
                <td>${list.quantity}</td>
                <td>${list.description}</td>
                <td>${list.category.name}</td>
                <td>
                    <a href="/Products?action=edit&id=${list.id}">Edit</a>
                    <a href="/Products?action=delete&id=${list.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <center>
        <h2>
            <button><a href="/Products?action=create">Add New Product</a></button>
        </h2>
    </center>
</div>
</body>
</html>
