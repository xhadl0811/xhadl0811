<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>채팅</title>
	<meta charset="UTF-8"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	 
	 </head>
	
<body>
<div style="padding-top:140px;text-align:center;">
	<form id="chatForm">
	<input id="message" style="width:500px;height:30px; "/>
		<button>전송</button>
	</form>
	<div style="height:500px;overflow:scroll" id="chat">
		<c:forEach items="${chat}" var="i">
		<h4 title="${i.time }">${i.message}</h4>
		</c:forEach>
</div>
</div>
	<script>
	var sock = new SockJS("https://localhost:8443/myapp/echo");
		$(document).ready(function(){
			
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			});
		});	
		
		sock.onmessage = function(e){
			$("#chat").append("<h4>"+e.data+"</h4>");
		}
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		}

		
	</script>
</body>
</html>