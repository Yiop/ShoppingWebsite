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
<%-- <h4>shopping cart:</h4>
<form:form action="/saveProduct" method="post" modelAttribute="productForm">
Add product:
<form:input path="title"/>
<form:errors path="title" cssStyle="color:red"/>
<input type="submit" value="Add Product"/>
</form:form> --%>
Product List:
<c:forEach items="${product}" var="product">
<div class="item">
   <c:out value="${product.title}"/>
   <c:out value="${product.price}"/>
   <%-- <c:out value="${product.description}"/> --%>
   <form action="/deleteProduct" method="post" >
   <input type='hidden' name='productId' value="${product.id}"/>
   <input type="submit" value="Delete"/>
   </form>
</div>
</c:forEach>
<%-- <form action="/getProduct" method="post">
Please Enter ProductId:<input type='text' name='productId'/>
<input type='submit' value='Search'/>
</form>
<form action="/getAllProduct" method="post">
<input type='submit' value='Get Product List'/>
</form> --%>
</body>
</html>