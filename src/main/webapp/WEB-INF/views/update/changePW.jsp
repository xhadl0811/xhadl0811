<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ ����</title>
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />

<c:url var="submit" value="/mypage/changePW/check" />
</head>
<body>
<div style="padding-top:170px;text-align:center;">
<h1>��й�ȣ ����</h1>
<form action="${submit}" method="post">
	<input type="password" name="originalPW" placeholder="���� ��й�ȣ"  class="box"/><br>
	<input type="password" name="newPW1" placeholder="���ο� ��й�ȣ"  class="box"/><br>
	<input type="password" name="newPW2" placeholder="���ο� ��й�ȣ ���Է�"  class="box"/><br>
	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
	<input type="submit" value="�Ϸ�"  class="submit"/>
	<c:if test="${errorMSG ne null}">
		<br><span style="color:red">${errorMSG }</span>
	</c:if>
	
</form>
</div>
</body>
</html>