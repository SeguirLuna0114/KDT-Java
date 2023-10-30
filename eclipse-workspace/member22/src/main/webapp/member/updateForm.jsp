<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member"%>
<%@ page import="dao.MemberDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	MemberDao md = new MemberDao();
	Member mem = md.select(id);
%>

<h2>정보 수정</h2>
<form action="updatePro.jsp">
	<input type="hidden" name="id" value="<%=mem.getId() %>">
	<table><tr><td>아이디</td>
			   <td><input type="text" name="id" value="<%=mem.getId() %>" disabled="disabled"></td>
			</tr>
			<tr><td>암호</td>
				<td><input type="text" name="password" value="<%=mem.getPassword() %>"></td>
			</tr>
			<tr><td colspan="2" align="right">
					<input type="submit" value="변경"> 
					<input type="button" value="취소" onclick="history.go(-1)">
				</td>
			</tr>
	</table>
</form>

</body>
</html>