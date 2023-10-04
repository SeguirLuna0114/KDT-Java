<%@ page contentType="text/html; charset=utf-8" %>

<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="sb" class="javaBean.SimpleBean" />
<jsp:setProperty name="sb" property="msg" />

<html>
	<body>

	<h1>간단한 자바빈 프로그래밍</h1>
	<br>

	메시지: <jsp:getProperty name="sb" property="msg" />

	</body>
</html>