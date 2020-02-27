	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>[상품판매사이트] - ${product.name}</title>
	<link rel="stylesheet" href="/myapp/resources/css/all.css" />
	<link rel="stylesheet"  href="/myapp/resources/css/errorAnda.css" />
	<link rel="stylesheet"  href="/myapp/resources/css/product.css" />
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script|Noto+Sans+KR&display=swap" 
	rel="stylesheet">
	
	<c:url var="defaultUrl" value="/" />
	<c:url var="editUrl" value="/product/edit/${product.id}" />
	<c:url var="deleteUrl" value="/product/delete/${product.id}" />
	<c:url var="buyUrl" value="/buy/product/${product.id}" />
	<c:url var="chatUrl" value="/chat?target=${product.author}" />
	<style>
		.abc{
			text-align:center;
			width:170px;
			height:70px;
			padding:5px;
			border:0.1px solid black;
			margin:10px;
			text-decoration:none;
			cursor:pointer;
			
		}
	</style>
	
</head>
<body>
<div style="padding-top:170px">
<div id="productInfo">
<h1>
${product.name}
</h1><h3>판매자: ${product.nickname} </h3>	



<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')" >
	<sec:authentication var="pri" property="principal.username" />

	<c:if test="${pri eq product.author }">
		<a href="${editUrl}" class="aTag">수정 </a>  
 		<a href="${deleteUrl}" onclick="if(!confirm('정말로 삭제하시겠습니까?')){return false;}" class="aTag">삭제</a>
 	</c:if>
 	<c:if test="${pri ne product.author }">
 		<div style="text-align:right;">	
		<span onclick = "location.href='${buyUrl}'" class = "abc">
			구매
		</span>
		<br><br><br>
		<span onclick="location.href='${chatUrl}'" class="abc">
			채팅
		</span>
	</div>
	<sec:authorize access="hasRole('ROLE_ADMIN')" >
			<a href="${editUrl}" class="aTag">수정 </a>  
	 		<a href="${deleteUrl}" onclick="if(!confirm('정말로 삭제하시겠습니까?')){return false;}" class="aTag">삭제</a>
	 	</sec:authorize>
 	</c:if>
</sec:authorize>
<h4>
	<c:if test="${product.price eq null }">
			가격 : 무료
	</c:if>
	<c:if test="${product.price ne null }">
			가격 : <fmt:formatNumber type="number" maxFractionDigits="3"  value="${product.price}"/>원
	</c:if><br>

조회수 : ${product.see+1}<br>${product.time}<br>
	<c:if test="${product.file1 ne null }">
			<img src="${product.file1}" width="500px"/>
	</c:if>
		<c:if test="${product.file2 ne null }">
			<img src="${product.file2}" width="500px"/>
	</c:if>
		<c:if test="${product.file3 ne null }">
			<img src="${product.file3}" width="500px"/>
	</c:if>
	
</h4>
<div id="des">
${product.description}
</div><br><br>
<c:if test="${product.category1 ne null }">
#${product.category1 }
</c:if>
<c:if test="${product.category2 ne null }">
#${product.category2 }
</c:if>
<c:if test="${product.category3 ne null }">
#${product.category3 }
</c:if>
</div>
<br>
<br>
<br>
</div>
</body>
</html>
