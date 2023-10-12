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
	/* deleteForm.jsp페이지에서 hidden으로 num값과 page값이 전달됨
	   => num값은 setNum()메소드로 값이 설정됨
		  단, page변수는 DTO클래스에 존재하지 않는 property이기에
		  	 getParameter로 값을 받음*/
	String nowPage = request.getParameter("page");

	// DB연동을 위한 DAO 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	/* 비밀번호 일치여부 판단
	   해당 id값에 해당하는 회원 정보를 DTO객체로 받아옴
	   -> 해당 DB내 저장된 데이터(DTO객체의 passwd)와 
	   	  입력받은 비밀번호(member의 passwd)가 같은지 판단 
	*/
	// DB에 저장된 비번을 구해오기
	BoardDataBean old = dao.getContent(board.getNum());
	// 비번 비교
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치시, delete SQL문 실행
		int result = dao.delete(board.getNum());
		if (result == 1) {
			// 삭제된 데이터가 있는 경우
%>
		<script>
			alert("글삭제 성공");
			// delete된 후, list.jsp(글 목록)페이지로 이동
			location.href="list.jsp?page=<%=nowPage %>";
		</script>

<%
		}
	} else {
		// 비번 불일치시, 회원 탈퇴 실패
%>
	<script>
		alert("비번이 일치하지 않습니다.");
		// 이전 페이지(게시판 글삭제 페이지)로 이동
		history.go(-1);
	</script>

<%
	}
%>