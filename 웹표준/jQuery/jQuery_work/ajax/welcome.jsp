<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버에 요청파일 : welcome.jsp</title>
</head>
<body>
	<!-- 웹브라우저에 출력되는 결과가 콜백함수로 리턴된다. -->
	환영합니다. <%=request.getParameter("username") %>님

</body>
</html>