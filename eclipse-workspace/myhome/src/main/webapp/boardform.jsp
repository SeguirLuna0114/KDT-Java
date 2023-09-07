<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<!-- header.jsp파일 불러오기 -->
<%@ include file="header.jsp" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시판 폼</title>
</head>

<body>
	<form method="post" action="board.jsp">
		<table border="1" width="500" align="center">
			<caption>게시판</caption>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" size="20" name="writer"
												 id="writer"
												 placeholder="작성자명 입력"
												 value="홍길동">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="passwd" name="passwd"
										 id="passwd"
										 placeholder="2~8자 이내 입력">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" size="50" name="subject"
												 id="subject"
												 placeholder="50자 이내로 입력">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="50" name="content"
							  id="content" 
							  placeholder="200자 이내로 입력">내용입력</textarea>
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="file" name="myfile" id="myfile">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글작성1">		<!-- 전송 기능이 있는(O) 버튼-->
					<input type="button" value="글작성2">		<!-- 전송 기능이 없는(X) 버튼-->
					
					<button>글작성3</button>					<!--전송기능이 있는(O) 버튼-->
					<button type="submit">글작성4</button>	<!--전송기능이 있는(O) 버튼-->
					<button type="button">글작성5</button>	<!--전송기능이 없는(X) 버튼-->
					
					<input type="reset" value="취소">			<!-- 초기화 버튼-->
					<button type="reset">초기화</button>		<!-- 초기화 버튼-->
				</td>
			</tr>
		</table>
	</form>

</body>

</html>


<!-- footer.jsp파일 불러오기 -->
<%@ include file="footer.jsp" %>

