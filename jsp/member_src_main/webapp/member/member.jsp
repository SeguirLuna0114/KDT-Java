<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
		  pageEncoding="UTF-8"%>

<%
	// 한글값 깨지지 않게 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="member" />

<%
	/* 2개 이상 선택된 "hobby"는 여러개의 값이 전달되는데,
	   따로 처리하지 않으면 하나의 값만 입력받음 => 배열과 for문을 통해 여러 값을 하나의 문자열로 결합하여 처리 */
	String[] hobby = request.getParameterValues("hobby");
	
	// String h = "공부-게임-등산-";
	String h = "";
	for(String h1 : hobby){
		h += h1 + "-";
	}
	
	member.setHobby(h);
	
	// DAO 객체 생성
	MemberDAO dao = MemberDAO.getInstance();
	// insert SQL문 실행
	int result = dao.insert(member);
	
	if(result == 1) {
		// 회원가입 성공한 경우
%>
	<script>
		alert("회원가입 성공");
// 		location.href = "loginform.html";
	</script>

<%
	} else {
		// 회원가입 실패한 경우
%>		
	<script>
		alert("회원가입 실패");
		history.go(-1);
	</script>
	
<%		
	}
%>
