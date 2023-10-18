<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core 태그 라이브러리 선언 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>choose 태그</title>
</head>
<body>
<!-- 다중 조건식 : choose태그
	1. 조건식을 만들때는 if태그 대신에 when태그로 조건식을 만듬
	2. 여러 조건식이 모두 참이라도, 가장 먼저 만족하는 조건식 아래쪽의 문장만 실행하고 빠져나감
	3. 위의 조건식을 만족 하지 않을때는 otherwise태그 아랫쪽의 문장을 실행
-->

<ul>
	<c:choose>
		<c:when test="${param.name == 'toto' }">
			<li>당신의 이름은 ${param.name } 입니다.</li>
		</c:when>
		<c:when test="${param.age >= 20 }">
			<li>당신의 나이는 20세 이상 입니다.</li>
		</c:when>
		<c:otherwise>
			<li>당신의 이름은 'toto'가 아니고, 나이는 20세 미만입니다.</li>
		</c:otherwise>
	</c:choose>
</ul>

</body>
</html>
    