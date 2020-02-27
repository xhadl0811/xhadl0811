<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>닉네임 변경</title>
<c:url var="submit" value="/mypage/changeNickname/check" />
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />
</head>
<body>
<div style="padding-top:170px;text-align:center;">
<h1>닉네임 변경</h1>
<h4>기존 닉네임 : ${originalNickname }</h4>
	<form action="${submit}" method="post">
		<input type="text" name="newNickname" placeholder="새로운 닉네임"  class="box"/><br>
		<input type="password" name="checkPW" placeholder="비밀번호" class="box" /><br>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
		<input type="submit" value="완료" class="submit"/>
	</form>
	<c:if test="${errorMSG ne null}">
		<br><span style="color:red">${errorMSG }</span>
	</c:if>
	
</div>
</body>
</html>