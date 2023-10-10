<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	System.out.println("id:" +  id);
	
	// DAO클래스의 객체를 가져옴
	MemberDAO dao = MemberDAO.getInstance();
	
	/* ID중복체크 메소드 실행
	   - 반환값 : 1 (중복 ID)
	   - 반환값 : -1 (사용 가능한 ID) */
	int result = dao.memberAuth(id);
	// 콘솔창에 출력
	System.out.println("result:" + result);
	
	// 웹 브라우저에 출력되는 값이 callback함수로 리턴됨
	out.println(result);
	
%>