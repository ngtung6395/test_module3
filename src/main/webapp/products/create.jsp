<%--
  Created by IntelliJ IDEA.
  User: Latitude 5590
  Date: 08/06/2021
  Time: 3:13 CH
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
<form action="" method="post">
    <table border="1px">
    <caption>
        <h2>Add new Product</h2>
    </caption>
    <tr>
        <th>Product Name:</th>
        <td>
            <input type="text" name="name">
        </td>
    </tr>
    <tr>
        <th>Price</th>
        <td>
            <input type="text" name="price">
        </td>
    </tr>
    <tr>
        <th>Quantity</th>
        <td>
            <input type="text" name="quantity">
        </td>
    </tr>
    <tr>
        <th>Color</th>
        <td>
            <input type="text" name="color">
        </td>
    </tr>
    <tr>
        <th>Description</th>
        <td>
            <input type="text" name="description">
        </td>
    </tr>
    <tr>
        <th>Category</th>
        <td>
            <select name="category_id" id="">
                <c:forEach items="${categories}" var="list">
                    <option value="${list.id}">${list.name}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
         <button type="submit">Save</button>
        </td>
    </tr>
</table>
</form>
</div>
</body>
</html>
