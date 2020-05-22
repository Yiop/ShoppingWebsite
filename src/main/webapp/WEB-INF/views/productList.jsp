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
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<title>Product</title>
</head>
<nav id="navbar">
<div class="container2">
<h1 class="logo"><a href="#">Alpaca's Store</a></h1>
<ul>
<li><a href="#home">Home</a></li>
<li><a href="#" id="mycart">My Cart</a></li>
<li><a href="#testimonials">Product</a></li>
<li><a href="/login?logout">Log Out</a></li>
</ul>
</div>
</nav>



<body id="home">

<div id="showcase">
<div class="container">
<div class="showcase-content">
<h1><span class="text-primary">Shopping</span> Cart</h1>
<c:set var = "total" value = "${0}"/>
<div class="container">
<c:forEach items="${cart}" var="cart"> 
   <c:out value="${cart.name}" />
   <c:out value="${cart.cost * cart.quantity}"/>
   <c:set var = "total" value = "${total + cart.cost * cart.quantity}"/>
   <c:out value="${cart.quantity}"/>
   
   <form action="/removeProduct" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="Remove" style="float: right"/>
   </form>
   
   <form action="/removeQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="-" style="float: right"/>
   </form>
   
   <form action="/addQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="+" style="float: right"/>
   </form>
   
</c:forEach>

<h4>Total:</h4>
	<c:out value="${total}"/>
</div>
</div>
</div>
</div>


<div class="container">
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='0'/>
   <input type="submit" value="All" style="float: right"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='2'/>
   <input type="submit" value="0-20" style="float: right"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='4'/>
   <input type="submit" value="20-40" style="float: right"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='6'/>
   <input type="submit" value="40-60" style="float: right"/>
</form>
<form action="/filterProduct" method="post" >
   <input type='hidden' name='filter' value='-1'/>
   <input type="submit" value=">60" style="float: right"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='1'/>
   <input type="submit" value="Food" style="float: right"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='2'/>
   <input type="submit" value="Electronics" style="float: right"/>
</form>
<form action="/category" method="post" >
   <input type='hidden' name='filter' value='3'/>
   <input type="submit" value="Others" style="float: right"/>
</form>
</div>

<section id="testimonials" class="py-3">
<div class="container">
<h2 class="l-heading">Product List</h2>
<div class="items">
<c:forEach items="${product}" var="product">
<div class="item">
<img src="${product.img}">
<div class="testimonial bg-primary">
   <c:out value="${product.name}"/>
   <c:out value="${product.cost}"/>
   <c:out value="${product.description}"/>
   <form action="/updateCart" method="post" >
   <input type='number' name='quantity'/>
   <input type='hidden' name='productId' value="${product.id}"/>
   <input type="submit" value="Add to cart"/>
   </form>
</div>
</div>
</c:forEach>
</div>
</div>
</section>

</body>
</html>