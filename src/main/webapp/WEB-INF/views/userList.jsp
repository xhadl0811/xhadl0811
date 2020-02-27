<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>채팅목록</title>
<c:url var="chatUrl" value="/chat?target=" />
</head>
<body >
<div style="text-align:center;padding-top:80px;">

<c:forEach items="${nicknameList}" var="i" varStatus = "status">
<	<div style="width:400px;border:0.2px solid #F98C08 ;display:inline-block;margin:30px;padding:30px;">
	<div style="margin:10px;background-color:white;border-radius:15px;">
		<a style="text-decoration:none;color:black;font-size:30px;"href="${chatUrl}${emailList[status.index]}">${i} </a> 
	</div>
	</div>
</c:forEach>
</div>
</body>
</html>