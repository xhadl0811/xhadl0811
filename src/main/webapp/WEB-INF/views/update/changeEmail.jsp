<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�̸��� ����</title>
<link rel="stylesheet" type="text/css" href="/myapp/resources/css/update.css" />

<c:url var="submit" value="/mypage/changeEmail/check" />
</head>
<body>

<div style="padding-top:170px;text-align:center;">
<h1>�̸��� ����</h1>
<form action="${submit}" method="post">
	<input type="text" name="originalEmail"placeholder = "���� �̸���" class="box" /><br>
	<input type="text" name="newEmail" placeholder = "�� �̸���" class="box"/><br>
	<input type="password" name="password" placeholder = "��й�ȣ" class="box"/><br>
	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  <br>
	<input type="submit" value="�Ϸ�" class="submit"/>
</form>
<br>
<c:if test="${errorMSG ne null}">
<span style="color:red">${errorMSG }</span>
</c:if>

</div>
<script>
	function error(){
		alert("���̵� Ȥ�� ��й�ȣ�� ���� �ʽ��ϴ�.")
	}

</script>
</body>
</html>