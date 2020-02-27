<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	h3{color:blue;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<c:url var="servlet" value="/PublicData.do" />
<script>
$.ajax({        
    url: 'https://localhost:8443/myapp/PublicData.do',
    type: 'get',
    contentType: 'application/x-www-form-urlencoded; charset=utf-8',
    dataType: 'json',
    
    success: function(data){
  	  console.log(data);
  	  var myItem = data.response.body.items.item;
         
        for(var i=0; myItem.length; i++){
            var output = '';
            console.log(myItem.length);
            output += '<h3>'+ i + '번째 서울 축제 데이터' +'</h3>';
            output += '<h4>'+myItem[i].addr1+'</h4>';
            output += '<h4>'+myItem[i].title+'</h4>';
            output += '<h4>'+myItem[i].tel+'</h4>';
            document.body.innerHTML += output;
        }
    },
	error: function(XMLHttpRequest, textStatus, errorThrown) { 
  	alert("Status: " + textStatus); alert("Error: " + errorThrown); 
	} 
});

</script>
</head>
<body>

</body>
</html>