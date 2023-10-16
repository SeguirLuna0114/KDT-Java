<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%
/* 	MultipartRequest클래스 객체의 getParameter메소드를 사용해서 값을 받아야 함
	String na = request.getParameter("name");		// 값 전달이 되지X
	out.println("name: "+na); */

	// 업로드 할 폴더 이름 = "upload"
	String uploadPath = request.getRealPath("upload");
	System.out.println("path=" + uploadPath);
	
	// size : 첨부파일의 크기(단위:Byte) 
	int size = 10 * 1024 * 1024;	// 최대 10MB로 설정
	String name = "";
	String subject = "";
	String filename1 = "";
	String filename2 = "";
	String origfilename1 = "";
	String origfilename2 = "";
	
	try {
		// 첨부파일은 MultipartRequest객체를 생성하면서 업로드가 수행됨
		/* MultipartRequest 객체를 생성할 때 
		   이미 HttpServletRequest 객체와 다른 매개변수들을 전달했는데,
		   그 중 request는 원본 HTTP 요청 객체이므로
		   여기에서 getParameter 메소드를 호출하여 폼 필드의 값을 얻음*/
		MultipartRequest multi =
					new MultipartRequest(request,		// http 요청 객체
										 uploadPath,	// 업로드할 디렉토리 위치
										 size,			// 첨부파일 크기
										 "utf-8",		// 인코딩 타입 설정
										 new DefaultFileRenamePolicy());	// 첨부파일의 중복문제 해결
	
		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
	
		/* getFileNames()메소드는 열거형으로 Enumeration 객체를 반환
		   객체를 반복하여 업로드된 각 파일 필드의 이름을 얻을 수 있음 */
		// 열거형 : fileName1, fileName2
		Enumeration files = multi.getFileNames();
		
//	    String file1 = "fileName1";
		String file1 = (String) files.nextElement();
		
		// 실제 서버에 저장된 파일명 : Koala1.jpg
		filename1 = multi.getFilesystemName(file1);
		// 클라이언트가 업로드한 파일명 : Koala.jpg
		origfilename1 = multi.getOriginalFileName(file1);
	
// 	    String file2 = "fileName2";		
		String file2 = (String) files.nextElement();
		filename2 = multi.getFilesystemName(file2);
		origfilename2 = multi.getOriginalFileName(file2);
	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<html>
<body>
	<form name="filecheck" action="fileCheck.jsp" method="post">
		<input type="hidden" name="name" value="<%=name%>">
		<input type="hidden" name="subject" value="<%=subject%>">
		<input type="hidden" name="filename1" value="<%=filename1%>">
		<input type="hidden" name="filename2" value="<%=filename2%>">
		<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
		<input type="hidden" name="origfilename2" value="<%=origfilename2%>">
	</form>
	<!-- form name="filecheck"로 설정했기에,
		 javascript:filecheck.submit() 으로 설정해야 함 -->
	<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>
