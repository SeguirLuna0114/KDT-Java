<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<!-- form 태그의 속성
method : 값을 전달하는 속성 : get, post
action : 값이 전달될 파일을 설정
-->


<form method="post" action="login.jsp">
<table border=1 width=350 align=center>
	<caption>로그인</caption>
	<tr>
		<td>ID</td>
		<td><input type=text size=20
							 maxlength=10
							 autofocus="autofocus"
							 name="id"  
							 id="id">		
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" size=20
								   required="required"
								   name="passwd"
								   id="passwd">		
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type=submit value="로그인"> <!--전송기능이 있는 버튼 -->
			<input type="reset" value="취소">	 <!-- 초기화 버튼 -->	
		</td>
	</tr>
</table>
</form>

</body>
</html>

<%@ include file="footer.jsp" %>

