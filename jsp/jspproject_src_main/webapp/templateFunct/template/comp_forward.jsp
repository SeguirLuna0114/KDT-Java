<%@ page contentType="text/html; charset=utf-8"%>


<!-- forward 액션 태그를 사용하여 다른 페이지로 전환
	 param 액션 태그를 사용하여 데이터를 전달
	 	- CONTENTPAGE라는 매개변수를 comp.jsp로 설정하여 데이터를 전달
 -->

<jsp:forward page="templateTest.jsp">
	<jsp:param name="CONTENTPAGE" value="comp.jsp" />
</jsp:forward>