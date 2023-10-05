<%@ page contentType = "text/html; charset=utf-8" %>

<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    
    // 로그인 성공(id와 password가 일치할 경우)
    if (id.equals(password)) {
    	// 세션 설정
        session.setAttribute("MEMBERID", id);
%>

		<html>
			<head><title>로그인성공</title></head>
			<body>
				<script>
					alert("로그인 성공");
					location.href = "sessionLoginCheck_getAttribute.jsp";
				</script>

			</body>
		</html>

<%
    } else { // 로그인 실패시
%>

		<script>
			alert("로그인에 실패하였습니다.");
			location.href = "sessionLoginCheck_getAttribute.jsp";
			
			// 이전 파일로 돌아가기
//			history.go(-1);
//			history.back();
		</script>
<%
    }
%>
