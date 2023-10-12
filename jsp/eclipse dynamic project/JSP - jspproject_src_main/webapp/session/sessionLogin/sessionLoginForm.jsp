<%@ page contentType = "text/html; charset=utf-8" %>

<html>
	<head><title>로그인폼</title></head>
	<body>

	<!-- request.getContextPath() 
		 : 현재 웹 애플리케이션의 컨텍스트 경로(Context Path)를 반환 -->
	<form action="sessionLogin_setAttribute.jsp" 
		  method="post">
		아이디 <input type="text" name="id" size="10">
		암호 	<input type="password" name="password" size="10">
			<input type="submit" value="로그인">
	</form>

	</body>
</html>