<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>forEach 태그</title>
</head>
<body>

	<h3>List 객체</h3>

<%
	/* List객체 생성 및 데이터 추가 */
	List list = new ArrayList();
	list.add("자바");
	list.add("웹표준");
	list.add("JSP");
	list.add("오라클");
	list.add("스프링");
	list.add("파이썬");
	list.add("텐스플로우");
	list.add("케라스");
	
	/* slist라는 이름으로 List 객체를 요청(request) 스코프에 저장
		-> JSTL에서 해당 slist 변수를 사용하여 데이터에 접근할 수 있음 */
	request.setAttribute("slist", list);		// 공유 설정
%>

	<!-- JSTL을 사용한 데이터 출력 -->
	<%-- 방법1
		c:set 태그를 사용하여 s1이라는 변수에 list를 할당하고,
		c:forEach 태그를 사용하여 s1의 내용을 반복
		
	    <c:set var="s1" value="<%=list%>"/>
		: JSTL 변수와 스크립트릿 변수 간의 혼합 사용으로 인해 작동하지 않음
		  스크립트릿(<% %> 블록) 내에서 선언된 변수는 JSTL 변수가 아니며
		  ${} 표현식을 사용하여 접근할 수 없음
	 --%>
	<c:set var="s1" value="<%=list%>"/>
	<c:forEach var="s2" items="${s1}">
	    ${s2} <br>  
	</c:forEach>
	<br><br>
	
	<!-- 방법2
		slist 변수를 직접 사용하여 List 객체의 내용을 반복
		
		request.setAttribute("slist", list);를 사용하여
		slist 변수를 요청(request) 스코프에 설정하고,
		이 변수를 JSTL로 직접 사용
	-->
	<c:forEach var="s" items="${slist}">
	    ${s} <br>
	</c:forEach>
	
	<br><br>

</body>
</html>