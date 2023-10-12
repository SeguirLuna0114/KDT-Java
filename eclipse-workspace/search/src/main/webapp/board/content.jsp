<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>

<!-- 게시판 상세 페이지 - num값과 page값을 request로 받음 -->
<%
	/* HTTP 요청(request)의 매개변수(parameter) 값을 추출하는 메서드 사용
	   => num매개변수와 page매개변수의 값을 받음 */
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("page");
	
	// DAO 객체 호출 => DB와 연결
	BoardDBBean dao = BoardDBBean.getInstance();
	
	// 해당 상세페이지로 이동시, 조회수를 1 증가시키고 & 상세정보를 구하는 메소드 실행
	BoardDataBean board = dao.updateContent(num);
	
	/* 내용 출력시, 입력한 값 그대로 출력되게 설정 
	   1. <pre>태그를 사용하여, 입력한 값 그대로(줄바꿈 포함) 출력되게 설정
	   2. replace메소드를 사용하여 줄바꿈 설정
	*/
	String content = board.getContent().replace("\n", "<br>");
	   
	// 작성일(날짜데이터) 출력 패턴 설정
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
	<title>상세 페이지</title>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="check.js"></script>
</head>

<body bgcolor="<%=bodyback_c%>">
	<center>
		<b>상세 페이지</b>
		
		<table width="500" border="1" align="center" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>">
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">번 호</td>
				<td width="100"><%=board.getNum()%></td>
				<td width="100" bgcolor="<%=value_c%>" align="center">조회수</td>
				<td><%=board.getReadcount()%></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">작성자</td>
				<td width="100"><%=board.getWriter()%></td>
				<td width="100" bgcolor="<%=value_c%>" align="center">작성일</td>
				<td><%=sd.format(board.getReg_date())%></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">제 목</td>
				<td colspan=3 width="400"><%=board.getSubject()%></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">내 용</td>
				<!-- td태그 사이에 출력될 때, 줄바꿈도 포함하여 출력하게 설정 -->
				<td colspan=3 width="400">
					<pre><%=board.getContent()%></pre>
					<%=content %>
				</td>
			</tr>
			<tr>
				<td colspan=4 bgcolor="<%=value_c%>" align="center">
					<!-- 클릭 이벤트가 실행될 때, get방식으로 매개변수(parameter)값을 포함하여 페이지로 전달 -->

					<!-- list.jsp에서 전달받은 num값과 page값을 전달 -->
					<input type="button" value="글수정"
						   onClick="location.href='updateForm.jsp?num=<%=num %>&page=<%=nowPage%>' ">
					
					<input type="button" value="글삭제"
						   onClick="location.href='deleteForm.jsp?num=<%=num %>&page=<%=nowPage%>' ">
					
					<!-- page값을 전달해야, 목록페이지(list.jsp)로 돌아올 갈 수 있음 -->
					<input type="button" value="글목록" 
						   onClick="location.href='list.jsp?page=<%=nowPage%>' ">
				</td>
			</tr>
		</table>

</body>
</html>