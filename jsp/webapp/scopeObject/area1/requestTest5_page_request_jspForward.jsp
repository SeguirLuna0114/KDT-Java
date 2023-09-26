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

<!-- <jsp:forward> 액션을 사용하여 
 	 현재 JSP 페이지를 다른 JSP 페이지로 전달
 	 =>  현재 페이지의 실행이 중지되고 다른 페이지로 제어가 이동됨 -->
<jsp:forward page="requestTest5Result_page_request.jsp"></jsp:forward>
</body>
</html>