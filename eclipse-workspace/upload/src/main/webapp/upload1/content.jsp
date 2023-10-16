<%@page import="java.text.SimpleDateFormat"%>
<%@page import="upload.BoardDataBean"%>
<%@page import="upload.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="color.jsp"%>
    
<% 
	// get방식으로 전달되는 값을 받음
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");
	
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 조회수 1 증가시키고, 상세정보를 구해오는 메소드 호출
	BoardDataBean board = dao.updateContent(num);	
	
	// 내용(content)를 줄바꿈을 반영하기 위해 개행문자를 설정
	String content = board.getContent().replace("\n", "<br>");
	
	// 작성일(날짜, 시간) 출력 형식 지정
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세 페이지</title>
</head>
<body bgcolor="<%=bodyback_c%>">

	<table border="1" width="500" align="center" bgcolor="<%=bodyback_c%>">
		<caption>상세 페이지</caption>
		<tr>
			<td bgcolor="<%=value_c%>" align="center">번호</td>
			<td><%=board.getNum() %></td>
			<td bgcolor="<%=value_c%>" align="center">조회수</td>
			<td><%=board.getReadcount() %></td>
		</tr>
		<tr>
			<td bgcolor="<%=value_c%>" align="center">작성자</td>
			<td><%=board.getWriter() %></td>
			<td bgcolor="<%=value_c%>" align="center">작성일</td>
			<td><%=sd.format(board.getReg_date()) %></td>
		</tr>
		<tr>
			<td bgcolor="<%=value_c%>" align="center">제목</td>
			<td colspan="3"><%=board.getSubject() %></td>
		</tr>
		<tr>
			<td bgcolor="<%=value_c%>" align="center">내용</td>
			<td colspan="3"><%=content %>
				<pre><%=board.getContent() %></pre>
			</td>
		</tr>
		<tr>
			<td bgcolor="<%=value_c%>" align="center">첨부파일</td>
			<td colspan="3">
				<!-- 첨부파일이 있는 경우에만, 파일명을 클릭하면 다운로드되게 설정 -->
		<% 
			if(board.getUpload() != null) {
		%>
				<a href="file_down.jsp?file_name=<%=board.getUpload() %>">
					<%=board.getUpload() %>
				</a>
		<%	
			} // if end
		%>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center" bgcolor="<%=value_c%>">
				<input type="button" value="글수정"
						onClick="location.href='updateForm.jsp?page=<%=nowPage%>&num=<%=num %>' ">
				<input type="button" value="글삭제"
						onClick="location.href='deleteForm.jsp?page=<%=nowPage%>&num=<%=num %>' ">
				<input type="button" value="글목록"
						onClick="location.href='list.jsp?page=<%=nowPage%>' "> 
			</td>
		</tr>
	</table>

</body>
</html>