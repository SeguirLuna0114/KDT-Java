<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>

<% 
	// 선택한 취미를 모두 저장하기 위해 '-'으로 결합한 문자열로 구성
	String[] hobby = request.getParameterValues("hobby");
	// String h = "공부-게임-쇼핑-";
	String h = "";
	for(String h1 : hobby) {
		h += h1 + "-";
	}
	member.setHobby(h);
	
	
	// DB연동
	MemberDAO dao = MemberDAO.getInstance();
	
	/* 비밀번호 일치여부 판단
	   해당 id값에 해당하는 회원 정보를 DTO객체로 받아옴
	   -> 해당 DB내 저장된 데이터(DTO객체의 passwd)와 
	   	  입력받은 비밀번호(member의 passwd)가 같은지 판단 
	*/
	MemberDTO old = dao.getMember(member.getId());
	if(old.getPasswd().equals(member.getPasswd())) {
		// 비번 일치시, update SQL문 실행
		int result = dao.update(member);
		if (result == 1) {
			// 입력받은 데이터가 있는 경우
%>
		<script>
			alert("회원정보 수정 성공");
			location.href="main.jsp";
		</script>

<%	
		}
	} else {
		// 비번 불일치시
%>
		<script>
			alert("비번이 일치되지 않습니다.");
			// 이전 페이지(회원정보 수정 페이지)로 이동
			history.go(-1);
		</script>
<%
	}
%>

