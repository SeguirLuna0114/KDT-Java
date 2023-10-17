<%@page import="upload.BoardDataBean"%>
<%@page import="upload.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 	delete SQL문으로 실행해야 하는 작업
		1. 내부 글 삭제
		2. 업로드 파일 내 저장된 첨부파일 삭제 -->
<% 
	// 한글 인코딩 설정(첨부파일이 넘어오지 않기에, request객체로 인코딩 설정 필요)
	request.setCharacterEncoding("utf-8");
%>

<!-- DTO 객체 생성 -->
<jsp:useBean id="board" class="upload.BoardDataBean"></jsp:useBean>
<!-- Form에서 넘어온 변수 설정 -->
<jsp:setProperty property="*" name="board"/>

<% 
	// hidden으로 넘어온 변수 값 중, DTO객체의 변수가 아닌 page변수는 getParameter로 받음
	String nowPage = request.getParameter("page");

	/* 업로드된 파일이 존재한다면, upload파일 내 저장된 첨부파일 삭제 */
	// 업로드된 첨부파일이 저장된 디렉토리 절대경로 구함
	String path = request.getRealPath("upload");
	System.out.println("path: " + path);

	
	// DB연동을 위해 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// 기존에 입력한 값을 가져옴
	BoardDataBean db = dao.getContent(board.getNum());	
	
	/* 입력한 비밀번호와 DB에 저장된 비밀번호 값 비교 */
	if(db.getPasswd().equals(board.getPasswd())) {
		// 비번 일치시, delete SQL문 실행(글 삭제 및 업로드된 첨부파일 삭제)
		int result = dao.delete(db, path);
		if(result == 1) {
			// 글 & 파일 삭제 성공한 경우
%>
			<script>
				alert("글 삭제 성공");
				location.href="list.jsp?page=<%=nowPage %>";
			</script>
<%	 	}
	} else {
		// 비번 불일치시
%>
		<script>
			alert("비번이 일치하지 않습니다.");
			// 이전 페이지(deleteForm.jsp)로 이동
			history.go(-1);
		</script>
<% 
	}
%>