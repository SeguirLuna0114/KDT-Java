<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 세션으로 공유된 id값을 가져옴 & Object타입으로 반환되기에 다운캐스팅 필요
	String id = (String)session.getAttribute("id");
%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 삭제 폼</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>

	<!-- 외부 자바스크립트 파일 불러오기 -->
	<script src="member.js"></script>
	
</head>

<body>
	<form method="post" action="delete.jsp">
	<!-- DTO property의 이름과 같게 name속성 설정 하여 id값을 hidden으로 전달-->
	<input type="hidden" name="id" value="<%=id%>">
		<table border=1 width=450 align="center">
			<caption>회원 삭제 폼</caption>
			<tr>
				<td>ID</td>
				<td><%=id%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type=password id="passwd" name="passwd">
				</td>
			</tr>
			
			<tr>
				<td colspan=2 align=center>
					<input type=submit value="회원삭제">
					<input type=reset value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>