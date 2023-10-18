<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
	<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 공유 범위를 벗어나기 때문에 null값이 출력됨 -->
	request 속성 값 : <%=request.getAttribute("request") %>
</body>
</html>