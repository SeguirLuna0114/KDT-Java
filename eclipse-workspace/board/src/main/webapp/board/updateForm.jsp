<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//세션으로 공유된 id값을 가져옴 & Object타입으로 반환되기에 다운캐스팅 필요
	int num = (int)session.getAttribute("num");

	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// num값에 해당하는 상세정보를 구해오는 메소드 호출
	BoardDataBean db = dao.get(num);
%>

<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="check.js"></script>
</head>

<body bgcolor="<%=bodyback_c%>">
	<center>
		<b>글쓰기</b> <br>
		<form method="post" name="writeform" action="updatePro.jsp">

			<table width="430" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="<%=value_c%>">
						<a href="list.jsp"> 글목록</a>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">이 름</td>
					<td width="330">
						<input type="text" size="10" maxlength="10" id="writer" name="writer">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">제 목</td>
					<td width="330">
						<input type="text" size="40" maxlength="50" id="subject" name="subject">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">Email</td>
					<td width="330">
						<input type="text" size="40" maxlength="30" id="email" name="email">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">내 용</td>
					<td width="330">
						<textarea id="content" name="content" rows="13" cols="40"></textarea>
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
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" onClick="location.href='list.jsp'">
					</td>
				</tr>
			</table>

		</form>
</body>
</html>
