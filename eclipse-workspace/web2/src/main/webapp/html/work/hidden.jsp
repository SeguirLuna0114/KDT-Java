<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%-- <%@ page ... %> 디렉티브 : JSP 페이지의 속성을 설정하는 데 사용--%>
    
	<%-- 웹 브라우저에서 양식(form)을 통해 
	 전송된 데이터를 받아와서 화면에 출력하는 역할 --%>

	<%-- <%= ... %> 표현식: Java 코드를 평가하고 결과를 출력하는 데 사용 --%>

	<%-- HTTP 요청을 통해 전달된 데이터를 받아와서 화면에 출력하는 코드
	request 객체: JSP 페이지에 HTTP 요청 정보를 제공
	getParameter 메서드: HTTP 요청의 쿼리 문자열 또는 양식 데이터에서 
				지정된 이름(input name = "이름")에 해당하는 값을 반환
	--%>
	
myid : <%=request.getParameter("myid") %> <br>
	<%-- 숨겨진 입력 필드(type="hidden")에서 전달된 값 --%>
	
myid01 : <%=request.getParameter("myid01") %> <br>
myid02 : <%=request.getParameter("myid02") %> <br>