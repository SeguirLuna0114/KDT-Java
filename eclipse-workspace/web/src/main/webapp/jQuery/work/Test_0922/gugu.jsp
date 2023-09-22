<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String danStr = request.getParameter("dan");
	int dan = Integer.parseInt(danStr);
%>

구구단 <%=dan %>단
<br><br>
<%=dan%> * 1 = <%=dan * 1%><br>
<%=dan%> * 2 = <%=dan * 2%><br>
<%=dan%> * 3 = <%=dan * 3%><br>
<%=dan%> * 4 = <%=dan * 4%><br>
<%=dan%> * 5 = <%=dan * 5%><br>
<%=dan%> * 6 = <%=dan * 6%><br>
<%=dan%> * 7 = <%=dan * 7%><br>
<%=dan%> * 8 = <%=dan * 8%><br>
<%=dan%> * 9 = <%=dan * 9%><br>
