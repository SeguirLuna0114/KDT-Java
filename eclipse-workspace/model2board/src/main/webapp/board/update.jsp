<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("글 수정 성공");
	// 목록 페이지로 이동
	location.href="<%=request.getContextPath()%>/BoardListAction.do?page="+${param.page};
</script>