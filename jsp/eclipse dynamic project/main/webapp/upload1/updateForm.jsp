<%@page import="upload.BoardDataBean"%>
<%@page import="upload.BoardDBBean"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="color.jsp"%>

<% 
	// get방식으로 넘어오는 변수 값 설정
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");

	// DB 연동을 위한 DAO클래스 객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 상세정보를 구해오는 메소드 호출
	BoardDataBean board = dao.getContent(num);
%>

<html>
<head>
	<title>게시판</title>
	<link href="style.css" rel="stylesheet" type="text/css">
	<!-- 유효성 검사 -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="check.js"></script>
</head>

<body bgcolor="<%=bodyback_c%>">
	<center>
		<b>글수정</b><br>
		<!-- 첨부파일 업로드 폼 -->
		<form method="post" name="updateform" action="updatePro.jsp" 
			  enctype="multipart/form-data">
			<!-- POST방식으로 hidden값을 전달 -->
			<input type="hidden" name="num" value="<%=num %>">
			<input type="hidden" name="page" value="<%=nowPage %>">

			<table width="430" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="<%=value_c%>">
						<a href="list.jsp?page=<%=nowPage %>">글목록</a>
					</td>
				</tr>
				
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">이 름</td>
					<td width="330">
						<input autofocus type="text" size="10" maxlength="10" 
								id="writer" name="writer" value="<%=board.getWriter() %>">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">제 목</td>
					<td width="330">
						<input type="text" size="40" maxlength="50" 
								id="subject" name="subject" value="<%=board.getSubject() %>">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">Email</td>
					<td width="330">
						<input type="text" size="40" maxlength="30" 
								id="email" name="email" value="<%=board.getEmail() %>">
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="<%=value_c%>" align="center">파일첨부</td>
					<td width="330">
						<!-- 사용자에게 파일을 선택하도록 요청 -->
						<input type="file" size="40" name="upload">
						<!-- 첨부파일이 있는 경우에만, 파일명 출력 -->
				<% 
					if(board.getUpload() != null) {
				%>
						<br><%=board.getUpload() %>
				<%		
					}// if end
				%>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">내 용</td>
					<td width="330">
						<textarea id="content" name="content" rows="13" 
							cols="40"><%=board.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">비밀번호</td>
					<td width="330">
						<input type="password" size="8" maxlength="12" id="passwd" name="passwd">
					</td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="<%=value_c%>" align="center">
						<input type="submit" value="글수정">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" 
							   OnClick="location.href='list.jsp?num=<%=num %>' ">
					</td>
				</tr>
			</table>

		</form>
</body>
</html>
