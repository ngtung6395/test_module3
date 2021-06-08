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
            <h2>Edit Product</h2>
        </caption>
    <tr>
        <th>Product Name</th>
        <td><input type="text" name="name">${product.name}</td>
    </tr>
        <tr>
        <th>Product Price</th>
        <td><input type="text" name="price">${product.price}</td>
    </tr>
        <tr>
        <th>Product Quantity</th>
        <td><input type="text" name="quantity">${product.quantity}</td>
    </tr>
        <tr>
        <th>Product Color</th>
        <td><input type="text" name="color">${product.color}</td>
    </tr>
        <tr>
        <th>Product Description</th>
        <td><input type="text" name="description">${product.description}</td>
    </tr>
        <tr>
            <th>Product Category</th>
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
                <button type="submit">Update</button>
            </td>
        </tr>

    </table>
</form>
</div>
</body>
</html>
