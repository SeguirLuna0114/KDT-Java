<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>selProduct.jsp</title>
</head>
<%
	// 요청 파라미터의 인코딩을 UTF-8로 설정
	request.setCharacterEncoding("utf-8");
	
	// 세션 스코프에 데이터 저장
	session.setAttribute("username",request.getParameter("username"));
%>
<body>
	<center>
		<H2>상품선택</H2>
		<HR>
		<!-- 세션 영역에서 데이터를 얻음
			 방법1) ${name} : name이라는 이름의 속성을 가져와서 사용자 이름을 표시
			 방법2) <%= session.getAttribute("name") %>
		-->
		<!-- 세션 스코프에서 "username" 속성을 가져와서 현재 사용자의 이름을 표시 -->
		<%=session.getAttribute("username") %>님이 로그인 한 상태 입니다.
		<br>
		${username}
		<HR>
		
		<!-- <SELECT> 요소를 사용하여 여러 상품 중 하나를 선택하고 추가 -->
		<form name="form1" method="POST" action="add_ArrayList.jsp">
			<SELECT name="product">
				<option>사과</option>
				<option>귤</option>
				<option>파인애플</option>
				<option>자몽</option>
				<option>레몬</option>
			</SELECT>
			<input type="submit" value="추가"/>
		</form>
		
		<!-- 선택한 상품을 계산하는 링크 -->
		<a href="checkOut.jsp">계산</a>
	</center>
</body>
</html>