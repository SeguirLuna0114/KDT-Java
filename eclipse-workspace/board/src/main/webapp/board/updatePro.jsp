<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
    
<% 
	//한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<%-- 서버측에 DTO객체를 위한 공간 생성 --%>
<jsp:useBean id="board" class="board.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<% 
	/* updateForm.jsp페이지에서 hidden으로 num값과 page값이 전달됨
	   => num값은 setNum()메소드로 값이 설정됨
	   	  단, page변수는 DTO클래스에 존재하지 않는 property이기에
	   	  	 getParameter로 값을 받음*/
	String nowPage = request.getParameter("page");

	/* 	비밀번호 일치여부 판단
		해당 id값에 해당하는 회원 정보를 DTO객체로 받아옴
		-> 해당 DB내 저장된 데이터(DTO객체의 passwd)와 
			입력받은 비밀번호(board의 passwd)가 같은지 판단 
	*/
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();

	// DB에 저장된 비번을 구해오기 - getContent()메소드를 통해 상세내역을 가져온 후, getPasswd)()메소드 사용
	BoardDataBean old = dao.getContent(board.getNum());
	// 비번 비교
	if(old.getPasswd().equals(board.getPasswd())) {
		// 비번 일치시, update SQL문 실행
		int result = dao.update(board);
		
		if(result == 1) {
%>
			<script>
				alert("글 수정 성공");
			<%-- Update된 후, list.jsp(글 목록)페이지로 이동
				 location.href="list.jsp?page=<%=nowPage %>"; --%>
				// update된 후, 상세페이지(content.jsp)로 이동
				location.href="content.jsp?num=<%=board.getNum()%>&page=<%=nowPage %>";
			</script>

<%	
		}
	} else {
		// 비번 불일치시
%>
		<script>
			alert("비번이 일치하지 않습니다.");
			// 이전 페이지(게시판 글수정 페이지)로 이동
			history.go(-1);
		</script>
<%
	}
%>

