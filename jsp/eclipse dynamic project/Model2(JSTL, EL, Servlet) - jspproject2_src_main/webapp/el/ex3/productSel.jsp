<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL 예제</title>
</head>
<body>
	<center>
		<h2>EL 예제-상품선택</h2>
		<hr>
		<!-- 표현언어(EL)로 출력
			 ${param.sel} : name='sel'변수로 전달된 값을 EL로 출력 -->
		1. 선택한 상품은 : ${param.sel} <br>

		<%-- 표현식 태그로 출력
			 <%=request.getParameter("sel") %> --%>
		1. 선택한 상품은 : <%=request.getParameter("sel") %> <br>
		
		
		
		<!-- 표현언어(EL)로 출력
			 "product" 객체의 "num1" 및 "num2" 속성을 더한 값을 표시 -->
		2. num1 + num2 = ${product.num1 + product.num2} <br>
		
		<%-- 표현식 태그로 출력
			 <%=pro.getNum1() + pro.getNum2() %> --%>
		<% 
			Product pro = (Product)session.getAttribute("product");
		%>
		2. num1 + num2 = <%=pro.getNum1() + pro.getNum2() %> <br>
		
		
		
		<!-- 표현언어(EL)로 출력
			 "product" 객체의 "num1" 및 "num2" 속성을 세션 스코프에서 가져와 더한 값을 표시 -->
		<!-- 표현언어(EL)로 출력 -->
		3. num1 + num2 = ${sessionScope.product.num1 + sessionScope.product.num2} <br>
		3. num1 + num2 = ${sessionScope.product.num1 + sessionScope.product.num2} <br>
	</center>
</body>
</html>