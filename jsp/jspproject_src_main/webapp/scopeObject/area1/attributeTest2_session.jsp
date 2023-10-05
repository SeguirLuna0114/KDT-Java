<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Attribute Test</title>
</head>
<body>
	<h2>영역과 속성 테스트</h2>
	<%
		// request의 문자 인코딩을 UTF-8로 설정 => 한글값이 깨지지 않게
		request.setCharacterEncoding("utf-8");
		
		// request파라미터에서 데이터 읽어와서 변수에 저장
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		/* 공유 설정 - 세션 스코프에 해당 데이터 저장	*/
		session.setAttribute("email", email);
		session.setAttribute("address", address);
		session.setAttribute("tel", tel);

		// 이전 페이지에서 애플리케이션 스코프에 저장한 이름을 가져옴
		String name = (String) application.getAttribute("name");
	%>
	<h3>
		<%=name%>님의 정보가 모두 저장되었습니다.
	</h3>
	<!-- 페이지로 이동 링크 -->
	<a href="attributeTest3_app_session.jsp">확인하러 가기</a>
</body>
</html>
