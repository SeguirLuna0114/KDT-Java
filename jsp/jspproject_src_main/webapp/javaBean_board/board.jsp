<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// 문자 인코딩
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="board.BoardDataBean"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

작성자 : <%=board.getWriter() %><br>
비밀번호 : <%=board.getPasswd() %><br>
제목 : <%=board.getSubject() %><br>
내용 : <%=board.getContent() %><br>