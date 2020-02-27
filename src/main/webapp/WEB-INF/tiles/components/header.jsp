<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<%@ page pageEncoding="utf-8"%>

<c:url var="defaultUrl" value="/" />
<c:url var="loginUrl" value="/login" />
<c:url var="signupUrl" value="/signup" />
<c:url var="logoutUrl" value="/logout" />
<c:url var="adminUrl" value="/admin" />


	<div style="position:fixed;
				text-align:center;
				display:inline-block;
          	  	z-index:999;
      	  		height:60px;
      	  		text-align:left;
       		   width:100%;	min-width:900px;
		background-color:#292929;
	">
		
		<span style="cursor:pointer;font-family: 'Nanum Pen Script', cursive;color:white; padding:25px;	font-size:40px;" onclick="location.href='${defaultUrl}'">상품 판매 사이트</span>

			
</div>


