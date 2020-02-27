<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호 변경</title>
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />

<c:url var="submit" value="/mypage/changePW/check" />
</head>
<body>
<div style="padding-top:170px;text-align:center;">
<h1>비밀번호 변경</h1>
<form action="${submit}" method="post">
	<input type="password" name="originalPW" placeholder="기존 비밀번호"  class="box"/><br>
	<input type="password" name="newPW1" placeholder="새로운 비밀번호"  class="box"/><br>
	<input type="password" name="newPW2" placeholder="새로운 비밀번호 재입력"  class="box"/><br>
	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
	<input type="submit" value="완료"  class="submit"/>
	<c:if test="${errorMSG ne null}">
		<br><span style="color:red">${errorMSG }</span>
	</c:if>
	
</form>
</div>
</body>
</html>