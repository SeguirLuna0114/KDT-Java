<%@page import="board.BoardDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.BoardDBBean"%>
    
<% 
	//한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="board.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 

	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();

	/* 	비밀번호 일치여부 판단
		해당 id값에 해당하는 회원 정보를 DTO객체로 받아옴
		-> 해당 DB내 저장된 데이터(DTO객체의 passwd)와 
			입력받은 비밀번호(board의 passwd)가 같은지 판단 
	*/
	BoardDataBean old = dao
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치시, update SQL문 실행
%>
		<script>
			alert("게시판 수정 성공");
			location.href="main.jsp";
		</script>

<%	
		
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

