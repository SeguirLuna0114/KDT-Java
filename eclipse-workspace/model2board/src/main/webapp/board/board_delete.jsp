<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
<head>
	<title>게시판 삭제</title>
	
	<!-- 유효성 검사 -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
</head>
<body>

	<!-- request로 공유된 값을 구해오는 기존 방식 -->
	board_num1 :<%=request.getParameter("board_num") %> <br>
	page1 : <%=request.getParameter("page") %><br>
	
	<!-- param으로 공유된 값을 구해오는 방법 --> 
	board_num2 : ${param.board_num }<br>
	page2 : ${param.page }<br>

	<form action="<%=request.getContextPath() %>/BoardDelete.do" method="post" >
	<!--get방식으로 전달받은 변수 값을 param.변수명 으로 받음-->
	<input type="hidden" name="board_num" value="${param.board_num }">
	<input type="hidden" name="page" value="${param.page }">
	
		<table width=300 cellpadding="0" cellspacing="0" align=center border=1>
			<tr align="center" valign="middle">
				<td colspan="5">게시판 삭제</td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12" height="16">
					<div align="center">비밀번호</div>
				</td>
				<td>
					<input type="password" name="board_pass" id="board_pass" size="10" maxlength="10"> 
				</td>
			</tr>
			<tr bgcolor="cccccc">
				<td colspan="2" style="height:1px;">
				</td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<tr align="center" valign="middle">
				<td colspan="5">			
					
					<input type=submit value="삭제">
					
					<input type=reset value="취소">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>