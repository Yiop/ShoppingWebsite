<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Sign Up</h4>
<form:form action="/saveUser" method="post" modelAttribute="userForm">
First Name:
<form:input path="firstName"/>
<form:errors path="firstName" cssStyle="color:red"/>
Last Name:
<form:input path="lastName"/>
<form:errors path="lastName" cssStyle="color:red"/>
Email:
<form:input path="email"/>
<form:errors path="email" cssStyle="color:red"/>
Password:
<form:input path="password"/>
<form:errors path="password" cssStyle="color:red"/>
<input type="submit" value="Register"/>
</form:form>
</body>
</html>