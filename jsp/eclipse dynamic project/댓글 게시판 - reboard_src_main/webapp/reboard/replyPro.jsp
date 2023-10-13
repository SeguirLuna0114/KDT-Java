<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="reboard.BoardDBBean"%>

<% 
	// 한글 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>    

<jsp:useBean id="board" class="reboard.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	/* replyForm으로부터 넘어온 값 10가지 중, 
		- page값은 DTO클래스 내에 존재X => 따로 설정
		- ip값은 넘어오지 않기에, request.getRemoteAddr()메소드로 구해옴
	*/
	// 클라이언트의 ip주소를 객체에 저장
	board.setIp(request.getRemoteAddr());
	// 페이지 값 설정
	String nowPage = request.getParameter("page");
	
	// DB연동을 위해 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 댓글작성 메소드 실행
	int result = dao.reply(board);
	if (result == 1) {
		// 댓글작성 성공한 경우
%>
		<script>
			alert("댓글 작성 성공");
			location.href="list.jsp?page=<%=nowPage%>";
		</script>
<%
	} else {
%>
		<script>
			alert("댓글 작성 실패");
			// 이전 페이지(replyForm.jsp)로 이동
			history.go(-1);
		</script>
<% 
	}
%>