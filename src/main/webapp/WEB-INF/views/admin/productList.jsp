<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상품 관리</title>
<c:url var="deleteProduct" value="/admin/productList/delete" />
<c:url var="product" value="/product/" />
	<link rel="stylesheet"  href="/myapp/resources/css/paging.css" />
</head>
<body>	

<div style="text-align:center;padding-top:100px;margin-left:40px;display:inline-block;">
<h1>상품 관리</h1>
<table>
	<tr>
		<th>ID</th>
		<th>상품명</th>
		<th>가격</th>
		<th>판매자</th>
		<th>판매여부</th>
	</tr>
	<c:forEach var="i" items="${products}">
			<tr >
				 <td style="width:20px;border:0.2px solid black;padding:6px;">${i.id}</td>
				<td style="border:0.2px solid black;width:200px"><a style="text-decoration:none;color:black;"href="${product}${i.id}">${i.name }</a></td>	
				<td style="border:0.2px solid black;width:120px;padding:7px;text-align:right;">
					<c:if test="${i.price == null }">무료</c:if>
					<c:if test="${i.price !=null }">		
						<fmt:formatNumber type="number" maxFractionDigits="3"  value="${i.price}"/>원
					</c:if>
				</td>
				<td style="width:150px;border:0.2px solid black;padding:6px;">${i.nickname}</td>
				<td style="border:0.2px solid black;padding:6px; ">
					<c:if test="${i.isSelling == true }">
						<span style="color:green">판매중</span>
					</c:if>
					<c:if test="${i.isSelling == false }">
						<span style="color:red">판매완료</span>
					</c:if>
				</td>
				<td>
					<a href="${deleteProduct}?id=${i.id}" style="background-color:#FE6363;color:white;border-radius:3px;
					padding:6px;text-decoration:none;" onclick="return confirm('${i.name}을(를) 삭제합니다.');">X</a>
				</td>
			</tr>	
	</c:forEach>
	
</table>
		<div style="margin-top:15px;">	
			<c:if test="${endPage > 10 }">
				 	<a class="page" href="?page=${startPage-1}">&lt;&lt;</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage }">
				<c:if test="${nowPage == i }" >
					<a class="nowPage" href="?page=${i}" id="paging">${i}</a>	
				</c:if>
				<c:if test="${nowPage !=i }">
					<a class="page" href="?page=${i}" id="paging">${i}</a>	
				</c:if>
			</c:forEach> 
			
			<c:if test="${allPage != endPage}">
				<a class="page" href="?page=${endPage +1}" >&gt;&gt;</a>
			</c:if><br>	
		</div>	<br>
		<div style="margin-top:10px;margin-bottom:60px;">
			<a id="go1Page" href="http://localhost:8085/myapp/admin/productList?page=1">첫 페이지로</a>
		</div>
	</div>
</body>
</html>