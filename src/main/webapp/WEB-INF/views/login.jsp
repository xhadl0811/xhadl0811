<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/myapp/resources/css/all.css" />
<link rel="stylesheet" href="/myapp/resources/css/user.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script|Noto+Sans+KR&display=swap" 
rel="stylesheet">
<meta charset="UTF-8">
<title>[상품판매사이트] 로그인</title>
<c:url var="loginSuccess" value="myapp/user/login" />
<c:url var="defaultUrl" value="/" />
</head>
<body>
<div style="padding-top:170px">
	<div class="outOfBox">
	<div class="loginBox">
		<h1>
			로그인
		</h1>
		<form action="/${loginSuccess}" method="post">
			<input name="email" class="input" type="text" value="${email}" placeholder="이메일" autocomplete="off"/><br>
			<input name="password" class="input" type="password" value="${password}" placeholder="비밀번호"autocomplete="off"/>

			<br>
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  
			<button type="submit" class="login">로그인</button>
		</form>
					 <br>
			 <c:if test="${not empty ERRORMSG}">
	      	  <div class="error">
	     	  	 ${ERRORMSG}
	          </div>
	 	    </c:if>
	 	    
	 	    <div id="noAccount">
	 	    	<a href="http://localhost:8085/myapp/signup">계정이 없으신가요?</a>
	 	    </div>
	</div>

	</div>
</div>
</body>
</html>