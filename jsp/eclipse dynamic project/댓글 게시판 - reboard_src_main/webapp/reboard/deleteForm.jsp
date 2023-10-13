<%@page import="reboard.BoardDataBean"%>
<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>

<% 
	// request로 전달받은 변수 설정
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");
	
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// 상세정보를 구해오는 메소드 호출
	BoardDataBean board = dao.getContent(num);
%>

<!-- 원문 글 작성 -->
<html>
<head>
	<title>글삭제</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<!-- 유효성 검사 -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="check.js"></script>
</head>


<body bgcolor="<%=bodyback_c%>">
	<center>
		<b>글삭제</b> <br>
		<form method="post" action="deletePro.jsp">
			<!-- num변수와 page변수를 hidden으로 전달 -->
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="page" value="<%=nowPage%>">
			
			<!-- 부모 관련 변수는 가져갈 필요 X -->
			<input type="hidden" name="ref" value="<%=board.getRef()%>">
			<input type="hidden" name="re_step" value="<%=board.getRe_step()%>">
			<input type="hidden" name="re_level" value="<%=board.getRe_level()%>">

			<table width="400" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="<%=value_c%>">
						<a href="list.jsp?page=<%=nowPage %>">글목록</a>
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="<%=value_c%>" align="center">이 름</td>
					<td width="330"><%= board.getWriter() %></td>
				</tr>

				<tr>
					<td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
					<td width="330">
						<input type="password" size="8" maxlength="12" id="passwd" name="passwd">
					</td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="<%=value_c%>" align="center">
						<input type="submit" value="글삭제">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" 
							   onClick="location.href='list.jsp?page=<%=nowPage %>' ">
					</td>
				</tr>
			</table>

		</form>
</body>
</html>