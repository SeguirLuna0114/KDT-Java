<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 사용자에게 select옵션을 제공하고 이 옵션을 다음 페이지로 전달 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL 예제</title>
</head>
<body>

	<center>
		<h2>EL 예제</h2>
		<hr>
		<form method="post" action="productSel.jsp">

			<%-- <jsp:useBean>을 사용하여 
				 DTO(Data Transfer Object)객체 "product"를 생성하고
				 세션 스코프에 저장(scope="session")
				 
				 1. DTO객체(product)를 생성해서 세션에 저장하라는 의미
	          	 2. Product product = new Product();
	             	session.setAttribute( "product", product );
	      	--%>
			<jsp:useBean id="product" class="model.Product" scope="session" />
			
			
			<!-- 드롭다운 목록을 생성
				 value속성이 없는 select태그 옵션 값은 해당 값 그대로 데이터가 전달됨 -->
			<select name="sel">
			<%
				/* 드롭다운 목록의 '내용' 생성
					"product" 객체에서 옵션으로 사용할 List 목록을 가져와서
				 	이 목록을 <option> 태그로 동적으로 생성 			*/
				for (String item : product.getProductList()) {
					out.println("<option>" + item + "</option>");
				}
			%>
			</select>
			<!-- "선택" 버튼은 사용자가 select옵션을 선택한 후 제출할 때 사용 -->			
			<input type="submit" value="선택">
		</form>
	</center>

</body>
</html>