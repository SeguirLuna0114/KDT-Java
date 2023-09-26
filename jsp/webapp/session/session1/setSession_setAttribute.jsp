<%@ page contentType="text/html; charset=utf-8" %>

<html>
	<head><title>세션 사용 예제</title>
	</head>
	<body>

<%
	String id = "guardian23";
	String passwd = "1234";

	// 세션 설정
	session.setAttribute("id", id);		// id = "guardian23"
	session.setAttribute("passwd", passwd);		// passwd = "1234"
%>

	세션에 id 와 passwd 속성을 설정하였습니다.<br><br>

	<!-- location.href와 window.location은 현재 브라우저 창의 위치(URL)를 변경하는 데 사용 -->
	<input type="button" value="세션의 설정된 속성확인" 
			onclick="location.href='viewSession_Enumeration_getAttrName.jsp'">
	   <!-- onclick="javascript:window.location='viewSession_Enumeration_getAttrName.jsp'"> -->
	</body>
</html>