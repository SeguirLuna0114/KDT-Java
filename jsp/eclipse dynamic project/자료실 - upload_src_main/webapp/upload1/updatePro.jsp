<%@page import="upload.BoardDataBean"%>
<%@page import="upload.BoardDBBean"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// 업로드할 파일을 저장할 디렉토리 path(경로) 구하기
	String path = request.getRealPath("upload");
	System.out.println("path: " + path);
	
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
	// hidden으로 넘어온 변수 값을 받음
	int num = Integer.parseInt(multi.getParameter("num"));
	String nowPage = multi.getParameter("page");
	
	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String email = multi.getParameter("email");
	String content = multi.getParameter("content");
	String passwd = multi.getParameter("passwd");
	
	// 오리지널 파일명 : 클라이언트가 업로드한 파일명
	String upload0 = multi.getOriginalFileName("upload");
	
	// 실제 서버에 저장된 파일명
	String upload = multi.getFilesystemName("upload");
	
	
	// DTO클래스 객체 생성하여 저장
	BoardDataBean board = new BoardDataBean();
	board.setNum(num);
	board.setWriter(writer);
	board.setEmail(email);
	board.setSubject(subject);
	board.setContent(content);
	board.setPasswd(passwd);
	/* post방식으로 넘어온 변수값 중, 클라이언트의 IP주소는 없기에 request로 구함 */
	board.setIp(request.getRemoteAddr());		// 클라이언트의 IP주소
//	board.setUpload(upload);					// 첨부파일을 수정하지 않으면 null값이 저장됨
	
	
	// DB연동을 위해 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// 기존에 입력한 값을 가져옴
	BoardDataBean db = dao.getContent(num);	
	
	/* 첨부파일을 수정하지 않은경우에는 null값이 저장되기에,
	   기존값을 유지하기 위해 db에서 파일을 구해와 setUpload()로 설정 */
	if(upload != null) {
		// 첨부파일을 수정한 경우
		board.setUpload(upload);
	} else {
		// 첨부파일을 수정하지 않은 경우, 기존에 첨부했던 파일로 설정
		board.setUpload(db.getUpload());
	}
	
	/* 입력한 비밀번호와 DB에 저장된 비밀번호 값 비교 */
	if(db.getPasswd().equals(passwd)) {
		// 비번 일치시, update SQL문 실행
		int result = dao.update(board);
		if(result == 1) {
			// 글 수정 성공한 경우
%>
			<script>
				alert("글 수정 성공");
				location.href="list.jsp?page=<%=nowPage %>";
			</script>
<%	 	}
	} else {
		// 비번 불일치시
%>
		<script>
			alert("비번이 일치하지 않습니다.");
			// 이전 페이지(updateForm.jsp)로 이동
			history.go(-1);
		</script>
<% 
	}
%>