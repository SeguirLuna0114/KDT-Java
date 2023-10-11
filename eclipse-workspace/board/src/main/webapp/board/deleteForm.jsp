<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>

<% 
	/* HTTP 요청(request)의 매개변수(parameter) 값을 추출하는 메서드 사용
	=> num매개변수와 page매개변수의 값을 받음 */
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");

	/* 만일, 작성자를 불러올 필요가 없다면, DB연동할 필요X */
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// num값에 해당하는 상세정보를 구해오는 메소드 호출
	BoardDataBean board = dao.getContent(num);
%>

<!DOCTYPE html>
<html>
<head>
	<title>글삭제</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="check.js"></script>
</head>

<body bgcolor="<%=bodyback_c%>">
	<center>
		<b>글삭제</b>
		<br>
		<form method="post" name="deleteform" action="deletePro.jsp">
			<!-- 변수(parameter)값을 post방식으로 전달
				 form태그 하위에 hidden객체로 num값과 page값을 전달 -->
			<input type="hidden" name="num" value="<%=num %>">
			<input type="hidden" name="page" value="<%=nowPage %>">

			<table width="430" border="1" align="center"
					cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" >
				<tr>
					<!-- 글 목록 링크를 통해 페이지를 이동할 경우, list.jsp파일의 page로 이동하게 설정 -->
					<td align="right" colspan="2" bgcolor="<%=value_c%>">
						<a href="list.jsp?page=<%=nowPage%>">글목록</a>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">작성자</td>
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
								onClick="location.href='list.jsp?page=<%=nowPage%>'">
					</td>
				</tr>
			</table>

		</form>
</body>
</html>
