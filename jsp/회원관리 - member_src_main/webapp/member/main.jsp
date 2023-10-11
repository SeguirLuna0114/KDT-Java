<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* session으로 공유된 id값을 가져옴
	   Object getAttribute()메소드는 값을 Object타입으로 반환
	   => session에 공유된 자료형으로 다운캐스팅 필요 */
	String id = (String)session.getAttribute("id");
	
	if(id != null) {
		// 세션으로 공유된 id가 있는 경우 => 정상적인 로그인
%>
		<%=id %>님 환영합니다. <br><br><br>
		
		<a href="updateform.jsp">정보수정 <br>
		<a href="logout.jsp">로그아웃</a> <br>
		<a href="deleteform.jsp">회원탈퇴</a> <br>

<%
	} else {
		// 세션으로 공유된 id가 없는 경우 => 비정상적인 접근
%>
		<a href="memberform.html">회원가입</a> <br>
		<a href="loginform.html">로그인</a> <br>

<%
	}
%>