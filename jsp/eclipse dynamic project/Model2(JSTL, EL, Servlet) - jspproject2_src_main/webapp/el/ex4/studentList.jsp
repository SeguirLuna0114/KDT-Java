<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// Post방식으로 전송될 때, 한글인코딩 설정
	request.setCharacterEncoding("utf-8");
%>

<!-- DTO객체 생성 및 post방식으로 전송된 값 설정 -->
<jsp:useBean id="student" class="model.Student" />
<jsp:setProperty property="*" name="student" />


<!-- 데이터 불러오는 방식
	 1. getProperty 액션태그를 사용하여 DTO객체에 저장된 값을 불러와 출력 -->
<h3>getProperty 액션태그로 출력</h3>
학번 : <jsp:getProperty property="no" name="student" /><br>
이름 : <jsp:getProperty property="name" name="student" /><br>
전공 : <jsp:getProperty property="major" name="student" /><br>
학년 : <jsp:getProperty property="grade" name="student" /><br>
E-Mail : <jsp:getProperty property="email" name="student" /><br>
연락처 : <jsp:getProperty property="phone" name="student" /><br>
주소 : <jsp:getProperty property="address" name="student" /><br>
<br>


<!-- 데이터 불러오는 방식
	 2. 표현식 태그를 사용하여 DTO객체에 저장된 값을 불러와 출력 -->
<h3>표현식 태그로 출력</h3>
학번 : <%=student.getNo()%><br>
이름 : <%=student.getName()%><br>
전공 : <%=student.getMajor()%><br>
학년 : <%=student.getGrade()%><br>
E-Mail : <%=student.getEmail()%><br>
연락처 : <%=student.getPhone()%><br>
주소 : <%=student.getAddress()%><br>
<br>


<!-- 데이터 불러오는 방식
	 3. EL(표현언어)을 사용하여 student객체의 각 필드의 속성값을 가져와 표시
	    ${DTO객체.해당필드명 } -->
<h3>표현언어(EL)로 출력</h3>
<%-- EL(표현언어) 중괄호 안에서는 메소드 호출X
학번 : ${student.getNo() } <br> --%>
학번 : ${student.no } <br>
이름 : ${student.name } <br>
전공 : ${student.major } <br>
학년 : ${student.grade } <br>
E-Mail : ${student.email } <br>
연락처 : ${student.phone } <br>
주소 : ${student.address } <br>
