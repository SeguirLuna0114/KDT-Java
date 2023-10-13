<%@page import="reboard.BoardDataBean"%>
<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="board" class="reboard.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<%
	/* updateForm.jsp페이지에서 hidden으로 num값과 page값
		- 단, page변수는 DTO클래스에 존재하지 않는 property이기에 getParameter로 값을 받음
	*/
	String nowPage = request.getParameter("page");

	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// DB에 저장된 비번을 구해와서, 사용자가 입력한 비번과 일치여부 확인
	BoardDataBean old = dao.getContent(board.getNum());
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치 시, delete SQL문 실행
		int result = dao.delete(board);
		if (result == 1) {
			// 글 삭제 성공한 경우
%>
			<script>
				alert("글 삭제 성공");
				/* delete된 후, list.jsp(글 목록)페이지로 이동 */
				location.href="list.jsp?page=<%=nowPage %>";
			</script>
<%			
		}
	} else {
		// 비번 불일치 시
%>
		<script>
			alert("비번이 일치하지 않습니다.");
			// 이전 페이지(게시판 글삭제 페이지)로 이동
			history.go(-1);
		</script>
<% 
	}
%>
