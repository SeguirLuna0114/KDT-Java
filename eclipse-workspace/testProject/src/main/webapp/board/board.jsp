<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// 문자 인코딩
	request.setCharacterEncoding("utf-8");
%>

<!-- 액션태그를 사용하여 자바빈 클래스(DTO)에 저장 -->
<jsp:useBean id="board" class="board.BoardBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<!-- 저장된 값 출력 -->
제목 : <%=board.getTitle() %> <br>
작성자 : <%=board.getName() %> <br>
비밀번호 : <%=board.getPassword() %> <br>
내용 : <%=board.getContent() %> <br>