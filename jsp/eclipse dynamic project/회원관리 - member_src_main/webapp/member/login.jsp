<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO"%>

<% 
	request.setCharacterEncoding("utf-8");
%>

<!-- DTO클래스의 객체 생성 -->
<jsp:useBean id="member" class="member.MemberDTO"></jsp:useBean>

<!-- DTO클래스의 property(멤버변수) 값 설정 -->
<jsp:setProperty property="*" name="member"/>

<% 
	// DAO클래스의 객체 불러옴
	MemberDAO dao = MemberDAO.getInstance();

	// 회원인증을 처리하기 위한 메소드 호출
	int result = dao.memberCheck(member);
	if(result == 1) {
		// 회원 인증을 성공한 경우
		
		// 세션 공유 설정 -> 로그인 후, 세션 영역의 시작 & 로그아웃시 세션 영역 끝
		session.setAttribute("id", member.getId());
%>
	<script>
		alert("로그인 성공");
		// 세션 영역이 시작되었기 때문에, id값은 공유됨
		location.href = "main.jsp";
	</script>

<%
	} else {
		// 회원 인증을 실패한 경우
%>
	<script>
		alert("로그인 실패");
		// 로그인 폼(이전 페이지)으로 이동함
		history.go(-1);
	</script>

<%
	}
%>