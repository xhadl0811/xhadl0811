<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/myapp/resources/css/error.css" />
<meta charset="UTF-8">
<title>잘못된 접근</title>
<c:url var="indexUrl" value="/" />
</head>
<body>
	<h1>
		403 error
	</h1>
	<h3>
		잘못된 접근입니다.
	</h3>
	<a class="button" href="${indexUrl}">홈페이지로</a>
</body>
</html>