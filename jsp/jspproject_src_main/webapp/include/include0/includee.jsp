<%@ page contentType = "text/html; charset=utf-8" %>

<%-- <%@ include %> 디렉티브 태그를 사용했기에,
	불려지는 파일(includer.jsp)에 있는 내용을 가져옴
	=> includer.jsp파일에서 선언한 number변수 사용 가능--%>
includer.jsp에서 지정한 번호: <%= number %>

<p>

<%
    String dataFolder = "c:\\data";
%>