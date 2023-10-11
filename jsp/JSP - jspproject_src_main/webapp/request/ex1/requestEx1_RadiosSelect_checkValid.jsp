<%@ page contentType="text/html;charset=utf-8"%>

<%	// 폼파일에서 한글값이 post방식으로 전송될때 utf-8로 인코딩을 시켜주는 역할
	request.setCharacterEncoding("utf-8");

	/* 한글 인코딩
		1. 폼 파일에서 한글값이 get방식으로 전송 될때는 tomcat이 자동으로
		   utf-8로 인코딩 시켜줌
		2. 폼 파일에서 한글값이 post방식으로 전송 될때는 tomcat이 자동으로
		   인코딩을 시켜주지 않기 때문에, request.setCharacterEncoding("utf-8")로 직접 인코딩을 시켜야 함
	*/
%>

<html>
<h1>Request 객체1</h1>

<%
	// name값의 대소문자 구분
	String name = request.getParameter("name");
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
%>

<body>
성명: <%=name%><p>
학번: <%=studentNum%><p>
성별 : <%=gender%><p>
전공 : <%=major%>
</body>
</html>

