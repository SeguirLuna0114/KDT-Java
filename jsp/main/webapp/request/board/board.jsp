<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String passwd = request.getParameter("passwd");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// replace("\n", "<br>"): \n을 <br>태그로 치환
	String contents =
			request.getParameter("content").replace("\n", "<br>");
%>

작성자 : <%=writer%><br>
비밀번호 : <%=passwd%><br>
제목 : <%=subject%><br>
내용01 : <pre><%=content%></pre><br><br>
내용01 : <br><%=contents%>


<html>
<head>
<title>요청 파라미터 출력</title>
</head>
<body>

	<table border=1 width=600 align=center>
		<caption>게시판</caption>
		<tr>
			<th >작성자</th>
			<td><%=writer%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=passwd%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=subject%></td>
		</tr>
		<tr>
			<!-- 변수 좌우에 pre태그를 사용하게 되면,
				 태그 내부의 코드 블록은 그대로 표시되며, 줄 바꿈과 들여쓰기가 그대로 유지됨  -->
			<th>내용01</th>
			<td><pre><%=content%></pre></td>
		</tr>
		<tr>
			<th>내용02</th>
			<td><%=contents%></td>
		</tr>
	</table>
</body>
</html>
