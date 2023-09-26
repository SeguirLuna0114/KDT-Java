<%@ page contentType = "text/html; charset=utf-8" %>
<html>
<head><title>파라미터 출력</title></head>
<body>

<!-- try-catch 블록을 사용하여 예외 처리를 수행하며,
     예외가 발생하면 사용자에게 오류 메시지를 제공 -->

name 파라미터 값: 
<% try { %>
		<%= request.getParameter("name").toUpperCase() %>
<% } catch(Exception ex) { %>
		<!-- 예외가 발생했을 때 사용자에게 표시할 메시지를 출력 -->
		name 파라미터가 올바르지 않습니다.
<% } %>

</body>
</html>
