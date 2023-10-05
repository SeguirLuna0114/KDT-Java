<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="register.LogonDataBean" %>
<%@ page import="register.LogonDBBean" %>
<%@ include file="color.jsp" %>

<% 
	request.setCharacterEncoding("utf-8");

  	LogonDataBean regBean1 = new LogonDataBean();
// 	regBean1.id="test";
%>

<%-- useBean 액션태그를 사용해 클래스 객체 생성(heap메모리 생성)
	 수정폼을 저장하기 위한 heap메모리 생성 --%>
<jsp:useBean id="regBean" class="register.LogonDataBean" />
<jsp:setProperty name="regBean" property="*" />

<%
	LogonDBBean manager = LogonDBBean.getInstance();

	// id값을 사용하여 수정하려는 데이터를 DTO클래스 타입으로 가져옴
	LogonDataBean old = manager.updateForm(regBean.getId());
	
	// 기존에 저장된 비번과 수정폼에 입력된 비번의 일치여부 확인
	if(old.getPasswd().equals(regBean.getPasswd())){ // 비번 일치시	
		manager.update(regBean);	// update SQL문 실행
%>	
	<script>
		alert("회원수정 성공");
		location.href="list.jsp";
	</script>
	
<% 	} else {	// 비번 불일치	%>

	<script>
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	</script>

<% 	} %>

