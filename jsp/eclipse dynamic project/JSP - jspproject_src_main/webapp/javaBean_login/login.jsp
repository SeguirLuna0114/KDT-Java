<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 문자 인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<%-- <jsp:useBean>태그 사용 => 클래스의 객체 생성--%>
<jsp:useBean id="member" class="member.MemberDataBean"></jsp:useBean>

<%-- <jsp:setProperty>태그 사용 => 객체 속성 설정
	 property="*"를 사용하여 모든 속성에 대해 해당하는 입력파라미터값을 할당 --%>
<jsp:setProperty property="*" name="member"/>

Id : <%=member.getId() %><br>
비밀번호 : <%=member.getPasswd() %><br>