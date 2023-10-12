<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 한글 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="reboard.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	/* IP주소는 값이 전달되지 않음 => 따로 설정 필요 */
	// 클라이언트의 ip주소를 구함
	String ip = request.getRemoteAddr();
	// setIP메소드로 ip주소를 객체에 저장
	board.setIp(ip);
	
	// DB연동을 위해 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 원문 글작성 메소드 실행
	int result = dao.insert(board);
	if (result == 1) {
		// 글 작성 성공한 경우
%>
		<script>
			alert("글 작성 성공");
			location.href="list.jsp";
		</script>
<% 
	} else {
%>
		<script>
			alert("글 작성 실패");
			// 이전 페이지(writeForm.jsp)로 이동
			history.go(-1);
		</script>
<% 
	}
%>
