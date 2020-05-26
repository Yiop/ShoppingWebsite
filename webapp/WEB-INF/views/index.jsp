<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
<h4>shopping cart:</h4>
<form:form action="/saveProduct" method="post" modelAttribute="product">
ID:
<form:input path="id"/>
<form:errors path="id" cssStyle="color:red"/>
NAME:
<form:input path="name"/>
<form:errors path="name" cssStyle="color:red"/>
COST:
<form:input path="cost"/>
<form:errors path="cost" cssStyle="color:red"/>
<input type="submit" value="Add Product"/>
</form:form>
</br>
<form action="/getProduct" method="post">
Please Enter ProductId:<input type='text' name='productId'/>
<input type='submit' value='Search'/>
</form>
</br>
<form action="/getAllProduct" method="post">
<input type='submit' value='Get Product List'/>
</form>
</body>
</html>