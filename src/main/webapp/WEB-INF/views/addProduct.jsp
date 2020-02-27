<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    
<!DOCTYPE html>
<html>
<head>
<title>[상품판매사이트] - 상품 추가</title>
<link rel="stylesheet" href="/myapp/resources/css/all.css" />
<link rel="stylesheet"  href="/myapp/resources/css/add.css" />	
<link rel="stylesheet"  href="/myapp/resources/css/errorAnda.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">	

<c:url var="defaultUrl" value="/" />
<c:url var="addProduct" value="/addProduct" />
</head>
<body>

<div style="padding-top:140px;text-align:center;">	<h1>상품 추가하기</h1>
	<f:form modelAttribute="product" action="${addProduct}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >
		<f:input class="addName" path="name" type="text" placeholder="상품명"/><f:errors class="error" path="name" /><br>
		
		<f:input class="addPrice" path	="price" type="number"
		 placeholder="상품 가격 (비워두면 무료)"/><br>
		<f:textarea class="addDes" path	="description" placeholder="상품 설명"></f:textarea><br>
		<label>상품 사진</label> 
		<br>
		
		<input name="file11" type="file"
			accept="image/jpeg,image/gif,image/png"/> <br>	
		<input name="file22" type="file"
			accept="image/jpeg,image/gif,image/png"/> <br>				
		<input name="file33" type="file"
			accept="image/jpeg,image/gif,image/png"/> <br>				

			
		<f:input type="text" path="category1" placeholder="카테고리 1" class="addCategory" />
		<f:input type="text" path="category2" placeholder="카테고리 2" class="addCategory"/>
		<f:input type="text" path="category3" placeholder="카테고리 3" class="addCategory"/>
		<br>				
		
		<f:button type="submit" onclick="if(!confirm('제출하시겠습니까?')){return false;}" class="submit">완료</f:button>
		
		<a class="aTag" href="http://localhost:8085/myapp">취소</a	>
	</f:form>
</div>

</body>
</html>