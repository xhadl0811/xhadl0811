<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[상품판매사이트] - 수정하기</title>
<link rel="stylesheet" href="/myapp/resources/css/all.css" />

	<link rel="stylesheet"  href="/myapp/resources/css/add.css" />
	<link rel="stylesheet"  href="/myapp/resources/css/errorAnda.css" />
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script|Noto+Sans+KR&display=swap" 
		rel="stylesheet">
	

	<c:url var="submitUrl" value="/product/completeEdit" />
	<c:url var="defaultUrl" value="/" />
</head>
<body>
<div style="padding-top:170px;text-align:center;">
<h1>수정하기</h1>
	<f:form modelAttribute="product" action="${submitUrl}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >
		<f:input class="addName" path="name" type="text" placeholder="상품명" value="${product.name}"/><f:errors class="error" path="name" /><br>
		<f:input class="addPrice" path="price" type="number"
		 placeholder="상품 가격 (비워두면 무료)" value="${product.price}" /><br>
		<f:textarea class="addDes" path="description" value="${product.description}" placeholder="상품 설명" /><br>
		<label>상품 사진:</label> <br>
		
							<!------------------파일1------------------->	
				<input name="file11" type="file"
					accept="image/jpeg,image/gif,image/png"/><br> 
							<!-----------------파일2----------------->					
				<input name="file22" type="file"
					accept="image/jpeg,image/gif,image/png"/><br>	
							<!-----------------파일3----------------->
				<input name="file33" type="file"
					accept="image/jpeg,image/gif,image/png"/><br>

		<f:input type="hidden" path="file1" value="${product.file1}" />
		<f:input type="hidden" path="file2" value="${product.file2}"/>
		<f:input type="hidden" path="file3" value="${product.file3}	"/>
			
		<br>
		<f:input type="text" path="category1" placeholder="카테고리 1" value="${product.category1}" class="addCategory" /><br>
		<f:input type="text" path="category2" placeholder="카테고리 2" value="${product.category2}" class="addCategory"/><br>
		<f:input type="text" path="category3" placeholder="카테고리 3" value="${product.category3}" class="addCategory"/><br>
		<f:input type="hidden" path="id" value="${product.id}" /><br>
		<f:button type="submit" onclick="if(!confirm('수정하시겠습니까?')){return false;}" class="submit">완료</f:button> 
		<a class="aTag" href="http://localhost:8085/myapp/product/${product.id}">취소</a>
	</f:form>
</div>		
	
	</body>
</html>