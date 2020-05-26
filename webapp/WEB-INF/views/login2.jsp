<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
<div align="center">
<form:form action="/adminLogin" method="post" modelAttribute="userForm">
First Name:
<form:input path="firstName"/>
<form:errors path="firstName" cssStyle="color:red"/>
Last Name:
<form:input path="lastName"/>
<form:errors path="lastName" cssStyle="color:red"/>
Password:
<form:input path="password"/>
<form:errors path="password" cssStyle="color:red"/>
<input type="submit" value="Login"/>
</form:form>
</div>
</body>
</html>