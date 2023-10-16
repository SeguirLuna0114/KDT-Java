<%@page import="reboard.BoardDataBean"%>
<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="reboard.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	/* updateForm.jsp페이지에서 hidden으로 num값과 page값 
										& 부모객체 관련 변수값이 전달됨
		- num값과 부모객체 관련 변수는 setXxx()메소드로 값이 설정됨
		- 클라이언트의 IP주소값은 전달되지 않기에, request.getRemoteAddr()메소드로 설정
		- 단, page변수는 DTO클래스에 존재하지 않는 property이기에 getParameter로 값을 받음*/
	board.setIp(request.getRemoteAddr());
	String nowPage = request.getParameter("page");
	
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// DB에 저장된 비번 구해와서, 사용자가 입력한 비번과 일치여부 확인
	BoardDataBean old = dao.getContent(board.getNum());
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치 시, update SQL문 실행
		int result = dao.update(board);
		if(result == 1) {
%>
			<script>
				alert("글 수정 성공");
				/* Update된 후, list.jsp(글 목록)페이지로 이동 */
				location.href="list.jsp?page=<%=nowPage %>";
<%-- 				// update된 후, 상세페이지(content.jsp)로 이동
				location.href="content.jsp?num=<%=board.getNum()%>&page=<%=nowPage %>"; --%>
			</script>
<%			
		}
	} else {
		// 비번 불일치 시
%>
		<script>
			alert("비번이 일치하지 않습니다.");
			// 이전 페이지(게시판 글수정 페이지)로 이동
			history.go(-1);
		</script>
<% 
	}
%>
