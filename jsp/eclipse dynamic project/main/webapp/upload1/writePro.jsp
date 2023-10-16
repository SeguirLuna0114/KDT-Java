<%@page import="upload.BoardDBBean"%>
<%@page import="upload.BoardDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<% 
	// 업로드할 파일을 저장할 디렉토리 path(경로) 구하기
	String path = request.getRealPath("upload");
	System.out.println("path: "+path);
	
	// 첨부파일의 크기(단위:Byte) -> 1MB로 설정
	int size = 1024 * 1024;
	
	// 첨부파일은 MultipartRequest클래스로 객체를 생성하면서 업로드가 수행됨
	MultipartRequest multi = 
				new MultipartRequest(request,
									 path,		// 업로드할 디렉토리 위치
									 size,		// 첨부파일의 크기 <- 1MB로 설정함
									 "utf-8",	// 인코딩 타입 설정
									 new DefaultFileRenamePolicy());	// 파일 중복문제 처리

	// multi.getParameter()메소드로 post방식으로 전송된 파라미터 값에 접근
	String writer = multi.getParameter("writer");
	String email = multi.getParameter("email");
	String subject = multi.getParameter("subject");
	String content = multi.getParameter("content");
	String passwd = multi.getParameter("passwd");
	
	// 오리지널 파일명 : 클라이언트가 업로드한 파일명
	String upload0 = multi.getOriginalFileName("upload");
	
	// 실제 서버에 저장된 파일명
	String upload = multi.getFilesystemName("upload");
	
	// DTO클래스 객체 생성
	BoardDataBean board = new BoardDataBean();
	board.setWriter(writer);
	board.setEmail(email);
	board.setSubject(subject);
	board.setContent(content);
	board.setPasswd(passwd);
	/* post방식으로 넘어온 변수값 중, 클라이언트의 IP주소는 없기에 request로 구함 */
	board.setIp(request.getRemoteAddr());
	board.setUpload(upload);
	
	
	// DB 연동을 위해 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 원문 글작성 메소드 실행
	int result = dao.insert(board);	// insert SQL문 실행
	if(result == 1) {
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