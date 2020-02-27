<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ����</title>
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
		<a href="${changeId}" class="button">���̵� ����</a><br><br>
		
		<a href="${changePW}" class="button">��й�ȣ ����</a><br><br>
		
		<a href="${changeNickName}" class="button">�г��� ����</a><br><br>
				
		<a href="${withdraw}"  onclick="if(!confirm('������ Ż���Ͻðڽ��ϱ�?')){return false;}" class="button">ȸ��Ż��</a>
	</div>
</div>

</body>
</html>