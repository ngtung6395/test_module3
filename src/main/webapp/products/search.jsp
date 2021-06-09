<%--
  Created by IntelliJ IDEA.
  User: Latitude 5590
  Date: 09/06/2021
  Time: 1:16 SA
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
    <form method="post">
        <table border="1" >
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Color</th>
                 <th>Quantity</th>
                <th>Description</th>
                <th>Category</th>
             </tr>
        <c:forEach items="${productList}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.price}</td>
                <td>${list.color}</td>
                <td>${list.quantity}</td>
                <td>${list.description}</td>
                <td>${list.category.name}</td>
            </tr>
        </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
