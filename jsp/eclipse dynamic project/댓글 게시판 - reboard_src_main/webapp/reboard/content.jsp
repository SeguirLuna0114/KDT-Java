<%@page import="java.text.SimpleDateFormat"%>
<%@page import="reboard.BoardDataBean"%>
<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// request로 넘어온 변수값을 설정
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");
	
	// DB와의 연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 조회수 1 증가 & 상세정보를 구해오는 메소드 호출
	BoardDataBean board = dao.updateContent(num);
	
	// 부모글 정보 구하기 - 댓글 insert할 경우 필요한 변수
	int ref = board.getRef();
	int re_level = board.getRe_level();
	int re_step = board.getRe_step();
	
	// <td>태그 사이에 줄바꿈 문자 또한 출력하기 위해서, 개행문자 설정
	String content = board.getContent().replace("\n", "<br>");
	
	// 작성일(날짜, 시간) 출력 형식 설정
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세 페이지</title>
</head>
<body>

	<table border=1 width=400 align="center">
		<caption>상세 페이지</caption>
		<tr>
			<td>번호</td>
			<td><%= board.getNum() %></td>
			<td>조회수</td>
			<td><%= board.getReadcount() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%= board.getWriter() %></td>
			<td>작성일</td>
			<td><%= sd.format(board.getReg_date()) %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><%= board.getSubject() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">
				<pre><%= board.getContent() %></pre>
				<%= content %>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<!-- replyForm파일에는 기본적으로 num값과 page값을 전달하고,
									부모글 정보 변수인 ref, re_level, re_step변수를 get방식으로 전달해야 함 -->
				<input type="button" value="댓글"
						onClick="location.href='replyForm.jsp?page=<%=nowPage%>&num=<%=num %>&ref=<%=ref %>&re_level=<%=re_level %>&re_step=<%=re_step %>' ">
				
				<input type="button" value="수정"
						onClick="location.href='updateForm.jsp?page=<%=nowPage%>&num=<%=num %>' ">
				
				<input type="button" value="삭제"
						onClick="location.href='deleteForm.jsp?page=<%=nowPage%>&num=<%=num %>' ">
				
				<input type="button" value="목록"
						onClick="location.href='list.jsp?page=<%=nowPage%>' ">
		</tr>
				
	</table>

</body>
</html>

