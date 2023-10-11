<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.BoardDBBean"%>

    
<% 
	// 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<!-- 넘어온 값을 저장하기 위한 DTO객체 생성(기억공간 생성) -->
<jsp:useBean id="board" class="board.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	// 글을 작성한 사용자의 IP주소 구해와서 객체에 전달
	String ip = request.getRemoteAddr();
	board.setIp(ip);

	// DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// insert SQL문 실행(주소값을 가진 board객체 전달)
	int result = dao.insert(board);
	
	if(result == 1) {
		// 게시판 글 작성 성공한 경우
%>
	<script>
		alert("글 작성 성공");
		/* page값 설정 없이 list.jsp로 이동하더라도,
		   list.jsp에서 null일 경우에 대해 설정했기에 오류X */
 		location.href = "list.jsp";
	</script>

<%
	} else {
		// 게시판 글 작성 실패한 경우
%>		
	<script>
		alert("글 작성 실패");
		history.go(-1);
	</script>
	
<%		
	}
%>