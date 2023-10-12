<%@ page contentType = "text/html; charset=utf-8" %>

<!-- import 디렉티브를 사용하여 Timestamp 및 SimpleDateFormat 클래스를 가져옴 -->
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	// 문자 인코딩을 설정
    request.setCharacterEncoding("utf-8");
%>

<%-- memberInfo라는 이름의 JavaBean 객체를 생성 --%>
<jsp:useBean id="memberInfo" class="member.MemberInfo" />

<%-- property="*"를 사용하여 모든 속성을 설정
	 => JavaBean의 모든 속성에 대해 해당하는 입력 파라미터 값을 할당 --%>
<jsp:setProperty name="memberInfo" property="*" />

<%-- password 속성에 memberInfo 객체의 id 값을 할당 --%>
<jsp:setProperty name="memberInfo" property="password"
                 value="<%= memberInfo.getId() %>" />

<%-- registerDate 속성에 현재 시간의 타임스탬프 값을 할당 --%>                 
<jsp:setProperty property="registerDate" name="memberInfo"
	value="<%=new Timestamp(System.currentTimeMillis()) %>"/>                 

<%
	// SimpleDateFormat 클래스를 사용하여 날짜 형식을 지정
	SimpleDateFormat sd = 
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");
%>

<html>
<head><title>가입</title></head>

<body>
	<%-- <jsp:getProperty> 태그를 사용하여 JavaBean 객체의 속성을 출력 --%>
	<table width="400" border="1" cellpadding="0" cellspacing="0">
		<tr><td>아이디</td>
			<td><jsp:getProperty name="memberInfo" property="id" /></td>
			<td>암호</td>
			<td><jsp:getProperty name="memberInfo" property="password" /></td>
		</tr>
		<tr><td>이름</td>
			<td><jsp:getProperty name="memberInfo" property="name" /></td>
			<td>이메일</td>
			<td><jsp:getProperty name="memberInfo" property="email" /></td>
		</tr>
		<tr><td>주소</td>
			<td colspan="3">
			<jsp:getProperty name="memberInfo" property="address" /></td>
		</tr>
		<tr><td>날짜</td>
			<td colspan="3">
			<%-- <jsp:getProperty name="memberInfo" property="registerDate" /> --%>
			
			<!-- registerDate 속성은 SimpleDateFormat을 사용하여 날짜 형식을 변경하여 출력 -->
			<%=sd.format(memberInfo.getRegisterDate()) %>
			
			</td>
		</tr>
	</table>

</body>

</html>