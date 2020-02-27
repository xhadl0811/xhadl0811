<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>내 정보</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
	.button{
		text-decoration:none;
		background-color:#00CEE6;
		color:white;
		width:400px;
		height:90px;
		padding:10px;
		border-radius:7px;
		margin:10px;
		font-family: 'Nanum Pen Script', cursive;
		font-size:2em;
	}
	.button:hover{
		background-color:#05A4B6;	
	}
</style>
<c:url var="changeId" value="/mypage/changeEmail" />
<c:url var="changePW" value="/mypage/changePW" />
<c:url var="changeNickName" value="/mypage/changeNickname" />
<c:url var="withdraw" value="/mypage/withdraw" />

</head>
<body >
<div style="padding-top:170px;">
	<div style="text-align:center">
		<h1>${nickname}</h1><br><br>
		<a href="${changeId}" class="button">아이디 변경</a><br><br>
		
		<a href="${changePW}" class="button">비밀번호 변경</a><br><br>
		
		<a href="${changeNickName}" class="button">닉네임 변경</a><br><br>
				
		<a href="${withdraw}"  onclick="if(!confirm('정말로 탈퇴하시겠습니까?')){return false;}" class="button">회원탈퇴</a>
	</div>
</div>

</body>
</html>