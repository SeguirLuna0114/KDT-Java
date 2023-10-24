<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>

	<a href="./BoardForm.do">글작성</a><br>
	<!-- 방법1) EL(표현 언어)을 사용하여 데이터를 출력 -->
	글 갯수 : ${listcount } 개 <br>

	<!-- 방법2) 스크립트릿 코드를 사용해 속성을 request 객체에서 가져와서 출력 -->
<% 
	int count = ((Integer)request.getAttribute("listcount")).intValue();
%>
	글 갯수 : <%=count %> 개 <br>
	<br>
	
	<table border="1" width="700" align="center">
		<caption><b>게시판 목록</b></caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		
		<!-- 해당 페이지의 블럭 당 시작번호 설정 -->
		<c:set var="num" value="${listcount - (page-1) * 10 }"></c:set>
		<!-- c:forEach태그 사용 => 반복작업 -->
		<c:forEach var="b" items="${boardList }">
			<tr>
				<td>${num }
					<!-- 출력된 num변수를 1 감소시킨 값으로 재정의 -->
					<c:set var="num" value="${num-1 }"></c:set>
				</td>
				<td>
					<!-- 댓글 제목 앞에 (댓글일 경우) 댓글의 깊이만큼 여백 처리 -->
					<c:if test="${b.board_re_lev > 0 }">
						<c:forEach var="i" begin="0" end="${b.board_re_lev }">
							&nbsp;
						</c:forEach>
					</c:if>
					
					<!-- 제목에 상세페이지로 이동하게 링크 설정 -->
					<a href="./BoardDetailAction.do?board_num=${b.board_num }&page=${page}">${b.board_subject }</a>
				</td>
				
				<td>${b.board_name }</td>
				
				<!-- 날짜를 fmt태그를 사용하여 원하는 패턴으로 지정하여 출력 -->
				<td>
					<fmt:formatDate value="${b.board_date }"
									pattern="YYYY-MM-dd HH:mm:ss EEE요일"/>
				</td>
				<td>${b.board_readcount }</td>
			</tr>
		</c:forEach>
		
	</table>
	<br>
	
	
<!-- 페이지 링크 처리 -->
	<center>
		<!-- 글 목록이 존재하는 경우 -->
		<c:if test="${listcount > 0 }">
			
			<!-- 1page로 이동 -->
			<a href="./BoardListAction.do?page=1" 
			   style="text-decoration: none"> << </a>
			   
			<!-- [이전] 블록으로 이동 -->
			<c:if test="${startPage > 10 }">
				<!-- 첫번째 페이지(startPage < 10)인 경우는 [이전]블록 X -->
				<a href="./BoardListAction.do?page=${startPage-10 }">[이전]</a>
			</c:if>
		
			<!-- 각 블럭에 10개의 페이지 출력 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i == page }">
					<!-- 해당 페이지가 현재페이지인 경우, 링크 처리X -->
					[${i }]
				</c:if>
				<c:if test="${i != page }">
					<!-- 해당 페이지가 현재페이지가 아닌 경우, 링크O -->
					<a href="./BoardListAction.do?page=${i}">[${i }]</a>
				</c:if>
			</c:forEach>
		
			<!-- [다음] 블록으로 이동 -->
			<c:if test="${endPage < pageCount }">
				<!-- 마지막 페이지(endPage < pageCount)인 경우는 [다음]블록 X -->
				<a href="./BoardListAction.do?page=${startPage+10 }">[다음]</a>
			</c:if>
			
			<!-- 마지막 page(총 페이지 수 = 마지막 페이지)로 이동 -->
			<a href="./BoardListAction.do?page=${pageCount }" 
			   style="text-decoration: none"> >> </a>
			   
		</c:if>
	
	
	
	</center>


</body>
</html>