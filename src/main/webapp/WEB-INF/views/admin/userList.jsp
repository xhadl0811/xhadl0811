<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원 관리</title>
<c:url var="deleteUserUrl" value="/admin/userList/delete"/>
<c:url var="enabled" value="/admin/userList/enabled"/>
	<link rel="stylesheet"  href="/myapp/resources/css/paging.css" />
	
</head>
<body>

<div style="text-align:center;padding-top:100px;margin-left:40px;display:inline-block">
<h1>회원 관리</h1>
	<table>  	
	<tr>
		<th>ID</th>
		<th>이메일</th>
		<th>닉네임</th>
		<th>비밀번호</th>
		<th>활성/비활성</th>
	
		
	</tr>		
<c:forEach var="i" items="${user}">

		<tr>
		    <td style="width:20px;border:0.2px solid black;padding:6px;">${i.id} </td>
		    <td style="width:300px;border:0.2px solid black;padding:6px;">${i.email}</td>
		    <td style="width:150px;border:0.2px solid black;padding:6px;">${i.nickname}</td>
		    <td style="width:150px;border:0.2px solid black;padding:6px;">${i.password} </td>
		    <td style="border:0.2px solid black;padding:6px;width:80px;">
		    	<c:if test="${i.enabled == true}" >
		   	 		<span style="color:green">활성</span>
		    	</c:if>
		    	<c:if test="${i.enabled == false }">
		    		<span style="color:red">비활성</span>
		    	</c:if>
		    </td>    
		    <td style="width:80px;text-align:center;">
			  	 <c:if test="${i.enabled == true }">
			   		 <a href="${enabled}?enabled=false&id=${i.id}" style="background-color:#FE6363;color:white;border-radius:3px;
					padding:6px;text-decoration:none;" onclick="return confirm('${i.email}을 비활성화 합니다.');">비활성화</a>
				</c:if>
				<c:if test="${i.enabled == false }">
					 <a href="${enabled}?enabled=true&id=${i.id}"style="background-color:#47D305;color:white;border-radius:3px;
					padding:6px;text-decoration:none;" onclick="return confirm('${i.email}을 활성화 합니다.');">활성화</a>
				</c:if>	
		    </td>
		    
		    
			<td >
				<a href="${deleteUserUrl}?id=${i.id}&email=${i.email}	" 
					style="background-color:#FE6363;color:white;border-radius:3px;
					padding:6px;text-decoration:none;" onclick="return confirm('${i.email}을 삭제합니다.');">X</a>
			</td>

		</tr>
	</c:forEach>		
	</table>
		<div style="margin-top:15px;">	
			<c:if test="${endPage > 10 }">
				 	<a class="page" href="?page=${startPage-1}">&lt;&lt;</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage }">
				<c:if test="${nowPage == i }" >
					<a class="nowPage" href="?page=${i}" id="paging">${i}</a>	
				</c:if>
				<c:if test="${nowPage !=i }">
					<a class="page" href="?page=${i}" id="paging">${i}</a>	
				</c:if>
			</c:forEach> 
			
			<c:if test="${allPage != endPage}">
				<a class="page" href="?page=${endPage +1}" >&gt;&gt;</a>
			</c:if><br>	
		</div>	<br>
		<div style="margin-top:10px;margin-bottom:60px;">
			<a id="go1Page" href="http://localhost:8085/myapp/admin/userList?page=1">첫 페이지로</a>
		</div>
</div>
</body>
</html>