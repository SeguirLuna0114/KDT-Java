<%@ page contentType="text/html; charset=utf-8" %>

<html>
	<head>
		<title>쿠키를 생성하는 예제</title>
	</head>

<%
   String cookieName = "id";
   Cookie cookie = new Cookie(cookieName, "totoro");
   cookie.setMaxAge(3600); 
   cookie.setValue("guardian");	// 쿠키 값을 guardian으로 수정
   response.addCookie(cookie);	// 쿠키를 응답에 추가
%>

	<body>
	<h2>쿠키를 생성하는 예제</h2>
	<P>

"<%=cookieName%>" 쿠키가생성 되었습니다.<br>

		<input type="button" value="쿠키의 내용확인" 
				onclick="javascript:location.href='getCookie_NameValue.jsp'">
	</P>
	</body>
</html>