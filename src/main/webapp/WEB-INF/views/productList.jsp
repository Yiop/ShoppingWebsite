<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.*" %>
<%@ page import="com.synex.domain.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
<a href="/login?logout">LogOut</a>
<h4>Cart:</h4>
<div>
<c:set var = "total" value = "${0}"/>
<c:forEach items="${cart}" var="cart"> 
   <c:out value="${cart.name}"/>
   <c:out value="${cart.cost * cart.quantity}"/>
   <c:set var = "total" value = "${total + cart.cost * cart.quantity}"/>
   <c:out value="${cart.quantity}"/>
   <form action="/addQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="+"/>
   </form>
   <form action="/removeQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="-"/>
   </form>
   <form action="/removeProduct" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="Remove"/>
   </form>
   <br>
</c:forEach>
<h4>Total:</h4>
	<c:out value="${total}"/>
</div>
<br>
<br>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='0'/>
   <input type="submit" value="All"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='2'/>
   <input type="submit" value="0-20"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='4'/>
   <input type="submit" value="20-40"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='6'/>
   <input type="submit" value="40-60"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='-1'/>
   <input type="submit" value=">60"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='1'/>
   <input type="submit" value="Food"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='2'/>
   <input type="submit" value="Electronics"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='3'/>
   <input type="submit" value="Others"/>
</form>
<br>
<h4>product list:</h4>
<div>
<img src="./img/aquawater.jpg">
<c:forEach items="${product}" var="product"> 
   <c:out value="${product.name}"/>
   <c:out value="${product.cost}"/>
   <br>
   <c:out value="${product.description}"/>
   <form action="/updateCart" method="post" >
   <input type='number' name='quantity'/>
   <input type='hidden' name='productId' value="${product.id}"/>
   <input type="submit" value="Add to cart"/>
   </form>
   <br>
</c:forEach>
</div>
</body>
</html>