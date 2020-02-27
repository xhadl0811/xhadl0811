<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/myapp/resources/css/error.css" />
<meta charset="UTF-8">
<title>페이지를 찾을 수 없음</title>
<c:url var="indexUrl" value="/" />
</head>
<body>
	<h1>
		404 error
	</h1>
	<h3>
		페이지를 찾을 수 없습니다.
	</h3>
	<a class="button" href="${indexUrl}">홈페이지</a>
</body>
</html>