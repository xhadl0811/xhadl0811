<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.a:hover{
		font-size:40px;
	}
</style>


<meta charset="UTF-8">
<title>관리자 페이지</title>
<c:url value="/admin/userList" var="userListUrl" />
<c:url var="defaultUrl" value="/" />
<c:url value="/admin/productList" var="productListUrl" />
</head>
<body>
<div style="padding-top:100px; text-align:center;">
<h1>	<a class="a" style="text-decoration:none;color:black;"  href="${userListUrl}">회원 관리</a></h1><br>
<h1>	<a class="a" style="text-decoration:none;color:black;" href="${productListUrl}">상품 관리</a></h1>
</div>
</body>
</html>	