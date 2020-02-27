<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page session = "true" %> 


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="/myapp/resources/css/tiles.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">	
<meta charset="utf-8">
<title>상품구매 - [${product.name}]</title>
<c:url var="defaultUrl" value="/" />
<link rel="stylesheet" href="/myapp/resources/css/all.css" />

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
</head>
<body>

	
	
	<div style="position:fixed;
				text-align:center;
				display:inline-block;
          	  	z-index:999;
      	  		height:150px;
       		   width:100%;	min-width:900px;text-align:center;
			min-height:140px;background-color:#292929;">
	
		<span style="cursor:pointer;font-family: 'Nanum Pen Script', cursive;color:white;	font-size:110px;" onclick="location.href='${defaultUrl}'">상품 판매 사이트</span>

			
</div>
<div style="padding-top:170px;margin-left:40px;">
 	<h1>구매하기</h1>	
 	<img src="${product.file1}" width="1000px" style="border:0.3px solid black"/><br>
 <h3>${product.name} <br></h3>
	 

 	<c:if test="${product.price eq null }">
		무료상품입니다. 판매자와 문의하세요
 	</c:if>
 	
 	<c:if test="${product.price ne null}">	
 	<h3>
		<fmt:formatNumber type="number" maxFractionDigits="3"  value="${product.price}"/>원
	</h3>
		<button class="pay">
		결제하기
		</button>
	</c:if>
</div>

<script>
	$('.pay').click(function pay(){
		var IMP = window.IMP;
		IMP.init('키');
		IMP.request_pay({
		pg: 'kakaopay',
		pay_method: 'card',
		merchant_uid: 'merchant_' + new Date().getTime(),
		name: '상품판매사이트 - ${product.name}',
		amount: '999999',
		buyer_email: '${product.author}',
		buyer_name: '${product.nickname}',
		buyer_tel: '010-1234-5678',
		buyer_addr: 'home',
		buyer_postcode: '123-456',
		m_redirect_url: 'https://www.naver.com/'
		
		}, function (rsp) {
		if (rsp.success) {
			const paymentData = getPaymentData.data.response; // 조회한 결제 정보
			const {amount, status} = paymentData;
			if(amount === 999999){			
				<% session.setAttribute("isSuccess",true); %>		
				window.location.replace("http://localhost:8085/myapp/successPay?id=${id}") ;	
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
			}
			else{
				alert("비정상적인 접근입니다.")
				location.href="https://localhost:8443/myapp/";
			}
		} else {
		var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
		alert(msg);

		});
	});
	
</script>
</body>

</html>
