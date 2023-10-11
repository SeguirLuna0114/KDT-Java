<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Attribute Test</title>
</head>
<body>
	<h2>영역과 속성 테스트</h2>
	<table border="1">
		<tr>
			<td colspan="2">Application 영역에 저장된 내용들</td>
		</tr>
		
		<!-- 애플리케이션 스코프에 저장된 "name"과 "id" 데이터를 표시 -->
		<tr>
			<td>이름</td>
			<td><%=application.getAttribute("name")%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=application.getAttribute("id")%></td>
		</tr>
	</table>
	<br>
	
	
	<table border="1">
		<tr>
			<td colspan="2">Session 영역에 저장된 내용들</td>
		</tr>
		
		<!-- session의 name값을 모르고있는 경우 속성값 가져오는 방법 -->
		<%
			// 세션 스코프에 저장된 모든 속성 이름을 가져옴
			Enumeration e = session.getAttributeNames();
			// 모든 세션 속성을 반복하며 각 속성의 값을 가져옴
			while (e.hasMoreElements()) {
				String attributeName = (String) e.nextElement();
				String attributeValue = (String) session.getAttribute(attributeName);
		%>
		<tr>
			<td><%=attributeName%></td>
			<td><%=attributeValue%></td>
		</tr>
		<%
			}
		%>
		
		<!-- session의 name값을 알고있는 경우 속성값 가져오는 방법 -->
		<tr>
			<td>email</td>
			<td><%=session.getAttribute("email") %></td>
		</tr>
		<tr>
			<td>address</td>
			<td><%=session.getAttribute("address") %></td>
		</tr>
		<tr>
			<td>tel</td>
			<td><%=session.getAttribute("tel") %></td>
		</tr>
	</table>
</body>
</html>
