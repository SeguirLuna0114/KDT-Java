<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* 공유 설정 - 페이지 & 요청 스코프에 해당 데이터 저장	*/
	pageContext.setAttribute("pageScope", "pageValue");
	request.setAttribute("requestScope", "requestValue");
%>

	<!-- 페이지/요청 스코프에서 속성의 값을 출력 -->
	pageValue = <%=pageContext.getAttribute("pageScope") %><br>
	requestValue = <%=request.getAttribute("requestScope") %>
</body>
</html>