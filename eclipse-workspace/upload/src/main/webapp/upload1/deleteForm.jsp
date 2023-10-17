<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="color.jsp"%>
<%@page import="upload.BoardDBBean"%>
<%@page import="upload.BoardDataBean"%>

<% 
	// get방식으로 넘어오는 변수 값 설정
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");

	/* 만일, 작성자 이름을 화면에 출력하지 않는다면, DB연동 할 필요X */
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
		<b>글삭제</b><br>

		<form method="post" name="deleteform" action="deletePro.jsp">
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
					<td width="330"><%=board.getWriter() %></td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">비밀번호</td>
					<td width="330">
						<input type="password" size="8" maxlength="12" id="passwd" name="passwd">
					</td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="<%=value_c%>" align="center">
						<input type="submit" value="글삭제">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" 
							   OnClick="location.href='list.jsp?num=<%=num %>' ">
					</td>
				</tr>
			</table>

		</form>
</body>
</html>
