<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="member.MemberDataBean"></jsp:useBean>

<jsp:setProperty property="*" name="member"/>

ID: <%=member.getId() %><br>
비밀번호: <%=member.getPasswd() %><br>
성명: <%=member.getName() %><br>
주민번호: <%=member.getJumin1() %>-<%=member.getJumin2() %><br>
E-Mail: <%=member.getMailid() %>@<%=member.getDomain() %><br>
전화번호: <%=member.getTel1() %>-<%=member.getTel2() %>-<%=member.getTel3() %><br>
핸드폰: <%=member.getPhone1() %>-<%=member.getPhone2() %>-<%=member.getPhone3() %><br>
우편번호: <%=member.getPost() %><br>
주소: <%=member.getAddress() %><br>
성별: <%=member.getGender() %><br>
취미: <%=member.getHobby() %><br>
자기소개: <%=member.getIntro() %><br>
