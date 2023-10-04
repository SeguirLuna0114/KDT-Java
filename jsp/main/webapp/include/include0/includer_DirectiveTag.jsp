<%@ page contentType = "text/html; charset=utf-8" %>

<html>
<head><title>include 디렉티브</title>
</head>

<body>

<%
    int number = 10;
%>

<%-- <%@ include %> 디렉티브 태그 --%>
<%@ include file="includee.jsp" %>

공통변수 DATAFOLDER = "<%= dataFolder %>"

</body>

</html>