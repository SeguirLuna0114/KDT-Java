<%@ page contentType = "text/html; charset=utf-8" %>
<!-- 에러 처리가 포함되어 있지 않음
	 에러가 발생할 경우, 기본적으로는 웹 애플리케이션 서버가 기본 오류 페이지를 보여줄 것 -->

<html>
<head><title>파라미터 출력</title></head>
<body>

name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>

</body>
</html>
