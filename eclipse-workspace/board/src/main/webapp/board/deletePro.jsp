<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>    

<!-- DTO클래스 객체 생성 -->
<jsp:useBean id="board" class="board.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	// DB연동을 위한 DAO 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	/* 비밀번호 일치여부 판단
	   해당 id값에 해당하는 회원 정보를 DTO객체로 받아옴
	   -> 해당 DB내 저장된 데이터(DTO객체의 passwd)와 
	   	  입력받은 비밀번호(member의 passwd)가 같은지 판단 
	*/
	// 한 사람의 상세정보(비번) 구하기
	BoardDataBean old = dao.get(board.getNum());
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치시, delete SQL문 실행
		int result = dao.delete(board.getNum());
		if (result == 1) {
			// 삭제된 데이터가 있는 경우, 세션 삭제
			session.invalidate();
%>
		<script>
			alert("회원탈퇴 성공");
			// 세션 영역이 시작되었기 때문에, id값은 공유됨
			location.href = "main.jsp";
		</script>

<%
		}
	} else {
		// 비번 불일치시, 회원 탈퇴 실패
%>
	<script>
		alert("비번이 일치하지 않습니다.");
		// 로그인 폼(이전 페이지)으로 이동함
		history.go(-1);
	</script>

<%
	}
%>