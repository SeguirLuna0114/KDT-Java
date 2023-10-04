<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page isErrorPage = "true" %>
<!-- 현재 페이지가 에러 페이지임을 나타내기 위해 사용
	 isErrorPage 속성이 true로 설정 => 예외가 발생했을 때 실행됨
 -->

<html>
<head><title>에러 발생</title></head>
<body>

	요청 처리 과정에서 에러가 발생하였습니다.<br>
	빠른 시간 내에 문제를 해결하도록 하겠습니다.
	<p>
		<!-- 발생한 예외의 클래스 이름을 출력 -->
	에러 타입: <%= exception.getClass().getName() %> <br>
	
		<!-- 예외 객체에 포함된 메시지를 가져옴 -->
	에러 메시지: <b><%= exception.getMessage() %> </b>
	
</body>
</html>

