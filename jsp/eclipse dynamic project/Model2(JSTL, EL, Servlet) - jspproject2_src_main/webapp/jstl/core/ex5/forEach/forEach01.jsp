<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>forEach 태그</title>
</head>
<body>

	<h3>1부터 100까지 홀수의 합</h3>
	<c:set var="sum" value="0" />
	
	<!-- 숫자(값) 좌우를 쌍따옴표("")로 감싸줘야 함 -->
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum + i}" />
	</c:forEach>
	
	결과 = ${sum}<br><br>
	
	<h1>1부터 100까지 홀수, 짝수의 합 구하기</h1>
	<c:set var="odd" value="0"></c:set>
	<c:set var="even" value="0"></c:set>
	
	<c:forEach var="i" begin="1" end="100">
		<!-- 홀수인 경우 -->
		<c:if test="${i%2 == 1 }">
			<c:set var="odd" value="${odd + i }"></c:set>
		</c:if>
		
		<!-- 짝수인 경우 -->
		<c:if test="${i%2 == 0 }">
			<c:set var="even" value="${even + i }"></c:set>
		</c:if>
	</c:forEach>
	
	<!-- 홀수/짝수의 합 출력 -->
	홀수의 합 : ${odd } <br>
	짝수의 합 : ${even } <br>

</body>
</html>