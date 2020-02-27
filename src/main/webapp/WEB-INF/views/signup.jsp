<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/myapp/resources/css/all.css" />
	<link rel="stylesheet" href="/myapp/resources/css/user.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script|Noto+Sans+KR&display=swap" 
rel="stylesheet">
<meta charset="UTF-8">
<title>[상품판매사이트] 회원가입</title>
<c:url value="/signup" var="signupUrl" />
<c:url var="defaultUrl" value="/" />
</head>
<body>
<div style="padding-top:170px;">
	<div class="outOfBox">
	<div class="loginBox">
		<h1>
			회원가입
		</h1>
<f:form modelAttribute="user" action="${signupUrl}?${_csrf.parameterName}=${_csrf.token}" method="post" >
	<f:input type="email"  path="email" class="input" placeholder="이메일" /><br><f:errors path="email" style="color:red" /><br>
	<f:input type="password" path="password" class="input" placeholder="비밀번호" /><br><f:errors path="password" style="color:red" /><br>
	<f:input type="text" path="nickname"  class="input" placeholder="닉네임" /><br><f:errors path="nickname" style="color:red" /><br>
	<f:button type="submit" onclick="if(!confirm('가입하시겠습니까?')){return false;}" class="login">가입</f:button><br>
</f:form>
</div>
</div>
</div>			
</body>
</html>	