<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDAO"%>

<!-- 팝업 창의 닫기버튼 클릭 시 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		
		// 중복 ID인 경우, [닫기]버튼 클릭
		$("#close1").click(function() {
			// 부모 창의 #id 요소의 값을 비움 & 포커스 이동
			opener.$("#id").val("").focus();
			// 창 닫기
			window.close();
		})
		
		// 사용 가능한 ID인 경우, [닫기]버튼 클릭
		$("#close2").click(function() {
			// 부모 창의 #passwd 요소로 포커스를 이동
			opener.$("#passwd").focus();
			// 창 닫기
			window.close();
		})
	}) 
</script>	    


<!-- 사용자가 전달한 id값을 활용해
	 DB를 연동하여 id값이 존재하는지 확인하는 코드 작성 -->
<% 
	/* idcheck.jsp?id= 로 전달된 변수id의 값을 받음 */
	String id = request.getParameter("id");

	/* DAO클래스의 싱글톤 객체 생성 with 메소드*/
	MemberDAO dao = MemberDAO.getInstance();
	
	// id 중복검사 메소드 호출
	int result = dao.memberAuth(id);
	
	if(result == 1) {
		// 중복된 ID 인 경우(중복 id 조회결과가 찾아진 경우)
%>
		<%= id %>는 중복 ID입니다.<br><br><br>
		<!-- 닫기버튼 추가 -->
		<input type="button" value="닫기" id="close1">
		
<%
	} else {
		// 사용 가능한 ID 인 경우(중복id 조회 결과 없는 경우는 -1 리턴됨)
%>
		<%= id %>는 사용 가능한 ID입니다.<br><br><br>
		<!-- 닫기버튼 추가 -->
		<input type="button" value="닫기" id="close2">

<%
	}
%>
  