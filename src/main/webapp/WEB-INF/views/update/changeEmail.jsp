<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>이메일 변경</title>
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />

<c:url var="submit" value="/mypage/changeEmail/check" />
</head>
<body>

<div style="padding-top:170px;text-align:center;">
<h1>이메일 변경</h1>
<form action="${submit}" method="post">
	<input type="text" name="originalEmail"placeholder = "기존 이메일" class="box" /><br>
	<input type="text" name="newEmail" placeholder = "새 이메일" class="box"/><br>
	<input type="password" name="password" placeholder = "비밀번호" class="box"/><br>
	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
	<input type="submit" value="완료" class="submit"/>
</form>
<br>
<c:if test="${errorMSG ne null}">
<span style="color:red">${errorMSG }</span>
</c:if>

</div>
<script>
	function error(){
		alert("아이디 혹은 비밀번호가 맞지 않습니다.")
	}

</script>
</body>
</html>