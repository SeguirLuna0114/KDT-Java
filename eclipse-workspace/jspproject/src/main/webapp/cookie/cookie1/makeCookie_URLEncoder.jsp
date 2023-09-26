<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.net.URLEncoder" %>

<%  // 쿠키값을 URLEncoder 클래스를 이용해서 인코딩 한다.
	/* URLEncoder.encode(String s, String enc)
		- s: URL로 인코딩할 문자열
		- enc: 문자열을 어떤 문자 인코딩 방식으로 변환할지를 나타내는 문자열(UTF-8"과 같은 문자 인코딩을 지정)
	*/
    Cookie cookie = new Cookie("name", URLEncoder.encode("최범균"));
    response.addCookie(cookie);
%>

<html>
	<head><title>쿠키생성</title></head>
	<body>

		<%= cookie.getName() %> 쿠키의 값 = "<%= cookie.getValue() %>"

	</body>
</html>