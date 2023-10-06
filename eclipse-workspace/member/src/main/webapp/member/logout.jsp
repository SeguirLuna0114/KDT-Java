<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 공유된 세션 삭제 -> 서버측 메모리에 있는 세션을 삭제하여 서버측과 클라이언트의 연결 끊음
	session.invalidate();
%>    

<script>
	alert("로그아웃");
	// 로그인 폼으로 이동
	location.href="loginform.html";
</script>