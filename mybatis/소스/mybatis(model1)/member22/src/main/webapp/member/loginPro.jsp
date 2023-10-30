<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDao"%>

<jsp:useBean id="mem" class="model.Member"/>
<jsp:setProperty property="*" name="mem"/>

<%
MemberDao md = new MemberDao();
int result = md.chk(mem);

if (result==1) {
	session.setAttribute("id",mem.getId());
%> 
	<script>
		alert("환영합니다.");
		location.href="main.jsp";
	</script>
<%
} else if (result == -1) {
%> 
	<script>
		alert("비번이 다릅니다.");
		history.go(-1);
	</script>
<%
} else {
%> 
	<script>
		alert("그런 ID가 없습니다.");
		history.go(-1);
	</script>
<%
}
%>
