<%@ page contentType="text/html; charset=utf-8"%>
<!-- 오류 해결: [project] -> [clean...] -->
<%@ page import="register.LogonDataBean"%>
<%@ page import="register.LogonDBBean"%>
<%@ include file="color.jsp"%>

<%
	request.setCharacterEncoding("utf-8");
	
	// <jsp:useBean> 액션태그와 같은 의미
	LogonDataBean regBean1 = new LogonDataBean();
//	regBean1.id="test";
%>

<jsp:useBean id="regBean" class="register.LogonDataBean" />
<jsp:setProperty name="regBean" property="*" />

<%
//	regBean.id="test";
%>

<%
	// DAO클래스 내 정적메소드 호출 => 싱글톤 객체 반환
	LogonDBBean manager = LogonDBBean.getInstance();
	int result = manager.insertMember(regBean);
	
	if (result == 1) {
%>
	<script>
		alert("회원가입 성공");
		location.href = "list.jsp";
	</script>

<%
	} else {
%>

	<script>
		alert("회원가입 실패");
		history.go(-1);
	</script>

<%
	}
%>

