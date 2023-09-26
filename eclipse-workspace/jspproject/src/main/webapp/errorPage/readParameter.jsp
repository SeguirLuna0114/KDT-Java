<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page errorPage = "/error/viewErrorMessage.jsp" %>
<!-- errorPage 디렉티브를 사용하여 에러가 발생했을 때 
	 /error/viewErrorMessage.jsp로 리다이렉트하도록 설정 -->

<html>
<head><title>파라미터 출력</title></head>
<body>

name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>

</body>
</html>
