<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�г��� ����</title>
<c:url var="submit" value="/mypage/changeNickname/check" />
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />
</head>
<body>
<div style="padding-top:170px;text-align:center;">
<h1>�г��� ����</h1>
<h4>���� �г��� : ${originalNickname }</h4>
	<form action="${submit}" method="post">
		<input type="text" name="newNickname" placeholder="���ο� �г���"  class="box"/><br>
		<input type="password" name="checkPW" placeholder="��й�ȣ" class="box" /><br>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
		<input type="submit" value="�Ϸ�" class="submit"/>
	</form>
	<c:if test="${errorMSG ne null}">
		<br><span style="color:red">${errorMSG }</span>
	</c:if>
	
</div>
</body>
</html>