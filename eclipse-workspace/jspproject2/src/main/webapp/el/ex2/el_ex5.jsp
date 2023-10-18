<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8");%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>표현언어 예제</title>
</head>
<body>

	<h3>파라미터값 전달</h3>
	
	<form method="post" action="el_ex5.jsp">
		이름 : <input type="text" name="name">
	          <input type="submit" value="확인">
	</form>
	<br><br>
	<!-- HTTP POST 요청으로 전달된 "name" 파라미터 값을 표시 -->
	이름 : <%=request.getParameter("name") %> <br>
	
	<!-- EL(Expression Language)을 사용하여 
		 현재 요청에서 "name" 파라미터의 값을 가져와 표시 -->
	이름 : ${param.name } <br>
	<!-- EL에서는 대괄호를 사용하여 매개 변수 이름을 동적으로 지정할 수 있음
		 EL에서 매개 변수 이름을 대괄호 []로 둘러싸고 있는 형태로
		 "name" 파라미터의 값을 표시 -->
	이름 : ${param['name']} <br>

</body>
</html>