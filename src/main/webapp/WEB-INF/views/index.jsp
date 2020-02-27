<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script|Noto+Sans+KR&display=swap" 
rel="stylesheet">
<meta charset="EUC-KR">
<title>[상품판매사이트]</title>
	<link rel="stylesheet" href="/myapp/resources/css/all.css" />	
	<link rel="stylesheet"  href="/myapp/resources/css/index.css" />
	<link rel="stylesheet"  href="/myapp/resources/css/indexButton.css" />
	<link rel="stylesheet"  href="/myapp/resources/css/paging.css" />
<style>
		.box{
			margin:7px;
			cursor:pointer;
			font-family: 'Noto Sans KR', sans-serif;
			text-align:left;
			display:inline-block;
			height:210px;
			width:650px;
			border:3px solid black;
			border-radius:10px;
			text-decoration:none;
			padding:19px;
			transition:0.5s;
		}
</style>	


<c:url var="defaultUrl" value="/" />
<c:url var="addProduct_needLogin" value="/login?redirect=addProduct" />
<c:url var="addProduct" value="/addProduct" />
<c:url var="admin" value="/admin" />
<c:url var="productUrl" value="/product" />			
<c:url var="loginUrl" value="/login" />
<c:url var="logoutUrl" value="/logout" />
<c:url var="signupUrl" value="/signup" />
<c:url var="mypageUrl" value="/mypage" />
<c:url var="chatListUrl" value="/chatList" />
</head>
<body>
<div style="padding-top:80px">
	<div>
	<sec:authorize access="isAnonymous()">
		<a class="indexButton" href="${loginUrl}">로그인</a><br>
		<a class="indexButton" href="${signupUrl}">회원가입</a><br>
		
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a class="indexButton" style="background-color:#FCC6C6" href="${admin}">관리자</a>
	</sec:authorize>
	</div>	
	<sec:authorize access="isAuthenticated()">
		<a class="indexButton" href="${mypageUrl}">내정보</a><br>
		<a class="indexButton" href="${chatListUrl}">채팅</a><br>
		<form action="${logoutUrl}" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			<button class="indexButton" type="submit">로그아웃</button><br>
		</form>	
	</sec:authorize>
		
	<div id="addProductBOX">
		<div >
			<a class="addProduct"  href="${addProduct}">상품 추가하기</a>
		</div>
	</div>
	<br>
	<div style="text-align:center; padding-top:15px;	">
		<c:forEach var = "product" items="${products}" varStatus="status">
			<div onclick="location.href='${productUrl}/${product.id}'" class="box">
				<div>
					<span class="a" >${product.name}</span>
				</div>

				<br><span style="font-size:25px;">					
					<c:if test="${product.price eq null}">
					  		무료
					 </c:if>		

					 <c:if test="${product.price ne null}">
							<fmt:formatNumber type="number" maxFractionDigits="3"  value="${product.price}"/>원
					</c:if>	<br>
					<c:if test="${product.isSelling eq false}">
					 	<label style="color:red;">판매완료</label>
					</c:if> 
					<c:if test="${product.isSelling eq true }">
						판매중
					</c:if>
			 </span>
			<br> 조회수 : ${product.see}<br>
			${product.time }
			</div><br>
			
		</c:forEach>
	</div>
	<div style="text-align:center;margin-top:15px;">	
		<c:if test="${endPage > 10 }">
			 	<a class="page" href="?page=${startPage-1}">&lt;&lt;</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage }">
			<c:if test="${nowPage == i }" >
				<a class="nowPage" href="?page=${i}" id="paging">${i}</a>	
			</c:if>
			<c:if test="${nowPage !=i }">
				<a class="page" href="?page=${i}"id="paging">${i}</a>	
			</c:if>
		</c:forEach> 
		
		<c:if test="${allPage != endPage}">
			<a class="page"  href="?page=${endPage +1}" >&gt;&gt;</a>
		</c:if><br>	
	</div>	<br>
	<div style="text-align:center;margin-top:10px;margin-bottom:60px;">
		<a id="go1Page" href="http://localhost:8085/myapp/?page=1">첫 페이지로</a>
	</div>		
</div>
</body>
</html>