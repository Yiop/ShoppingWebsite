<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
</head>
<body>
<h4>Shipping Information</h4>
<form:form action="/placement" method="post" modelAttribute="orderForm">
Total
<form:input path="cost"/>
<form:errors path="cost" cssStyle="color:red"/>
<input type="submit" value="Place the order"/>
</form:form>
<%-- <form action="/getProduct" method="post">
Please Enter ProductId:<input type='text' name='productId'/>
<input type='submit' value='Search'/>
</form>
<form action="/getAllProduct" method="post">
<input type='submit' value='Get Product List'/>
</form> --%>
</body>
</html>
