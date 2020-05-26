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

<body id="home">

<nav id="navbar">
<div class="container2">
<div class="navbara-content">
<h1 class="logo">
      <span class="text-primary">
        <img src='img/alpaca.png'>
      </span>Alpaca's Store
</h1>
<ul>
<li><a href="#home">Home</a></li>
<li><a href="#" id="mycart">My Cart</a></li>
<li><a href="#testimonials">Products</a></li>
<li><a href="/login">Log Out</a></li>
</ul>
</div>
</div>
</nav>

<div id="showcase">
<div class="container">
<div class="showcase-content">
<h1 class="l-heading">Welcome</h1>
<p class="lead">So many good stuff.</p>
<a href="#testimonials" class="btn">Explore</a>
</div>
</div>
</div>
<!-- </div> -->


<%-- <div class="container">
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
</div> --%>

<!-- <section id="testimonials" class="py-3"> -->
<!-- <div class="container2"> -->
<!-- <h2 class="l-heading">Product List</h2> -->
<div id="testimonials" class="items">
<c:forEach items="${product}" var="product">
<div class="item">
<%-- <img src="${product.img}"> --%>
<!-- <div class="testimonials bg-primary"> -->
   <%-- <c:out value="${product.title}"/>
   <c:out value="${product.cost}"/>
   <c:out value="${product.description}"/> --%>
   <%-- <form action="/addToCart" method="post" >
   <!-- <input type='number' name='quantity'/> -->
   <input type='hidden' name='productId' value="${product.id}"/>
   <input type="submit" value="Add to cart"/>
   </form> --%>
   <ul>
   <li><img src='${product.img}'/></li>
   <li><h5>${product.title}</h5></li>
   <li><h6>$${product.price}</h6></li>
   <li><a href="/addToCart?productId=${product.id}" class="btn2"><img src='img/supermarket.png'></a></li>
   </ul>
<!-- </div> -->
</div>
</c:forEach>
</div>


<!-- </div> -->
<!-- </section> -->

<c:set var = "total" value = "${0}"/>
<div class="container3">
<h2><span class="text-primary">Shopping</span> Cart</h2>
<ul>
<c:forEach items="${cart}" var="cart"> 
<li>
   <h6>${cart.title}</h6>
   <%-- <c:out value="${cart.price * cart.quantity}"/> --%>
   <%-- <c:set var = "total" value = "${total + cart.cost * cart.quantity}"/>
   <c:out value="${cart.quantity}"/> --%>
   
   <form action="/removeProduct" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="Remove"  style="float: right"/>
   </form>
   
   <form action="/removeQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="-"  style="float: right"/>
   </form>
   
   <form action="/addQuantity" method="post" >
   <input type='hidden' name='productId' value="${cart.id}"/>
   <input type="submit" value="+"  style="float: right"/>
   </form>
   </li>
</c:forEach> 
</ul>
<form action="/checkOut" method="post" >
<input type="submit" value="Check Out"/>
</form>

</div>
<!-- <a href="/checkOut.jsp" class="btn"></a> -->
<%-- <h4>Total:</h4>
	<c:out value="${total}"/> --%>
<script src="js/main.js"></script>
</body>
</html>