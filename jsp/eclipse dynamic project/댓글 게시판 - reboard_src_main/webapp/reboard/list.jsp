<%@page import="java.text.SimpleDateFormat"%>
<%@page import="reboard.BoardDataBean"%>
<%@page import="java.util.List"%>
<%@page import="reboard.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>

<% 
	// 1.한 화면(페이지)에 출력할 데이터 갯수 설정
	int page_size = 10;

	String pageNum = request.getParameter("page");
	if(pageNum == null) {
		pageNum = "1";		// 1page : 최근글이 보이는 페이지
	}
	
	// 2. 현재 페이지 번호
	int currentPage = Integer.parseInt(pageNum);
	
	// 3. 총 데이터 갯수
	int count = 0;
	
	// DB연동을 위해 DAO객체 호출
	BoardDBBean dao = BoardDBBean.getInstance();
	// 총 데이터 갯수를 구해오는 메소드 호출
	count = dao.getCount();
	// 데이터 갯수를 콘솔에 출력
	System.out.println("count : " + count);
	
	
	/* 4. 페이지 번호에 따라, 각 블럭의 크기만큼 데이터를 잘라서 화면에 출력
		- startRow : 각 page에 추출할 데이터의 시작번호
		- endRow : 각 page에 추출할 데이터의 끝 번호	
		*등비수열 : a_n = r * (n-1) + a_1 			*/
	int startRow = (currentPage -1) * page_size + 1;
	int endRow = currentPage * page_size;
	
	// List인터페이스를 활용하여 데이터를 가져옴
	List<BoardDataBean> list = null;
	if(count > 0) {
		// 가져올 데이터가 존재하면, 데이터를 가져오는 메소드 실행
		list = dao.getList(startRow, endRow);
	}
	System.out.println("list : " + list);
	
	
	if(count == 0) {
		// 검색된 데이터가 없는 경우
%>
		작성된 글이 없습니다.
<% 
	} else {
		// 검색된 데이터가 존재하는 경우
%>
		<!-- 글 작성 폼으로 이동하게 링크 설정-->
		<a href="writeForm.jsp">글 작성</a>
		<br>
		글 갯수 : <%=count %>개
		
		<table border=1 width=700 align=center>
			<caption>게시판 목록</caption>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>IP주소</th>
			</tr>
			
			<!-- 리스트에 저장된 데이터를 for문을 활용해 출력 -->
	<%
		// 작성일(날짜&시간)을 지정 형식으로 출력
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/* number : 웹 브라우저에서 각 페이지에 출력될 시작 번호
			- 화면 출력번호는 새로 파생된 변수를 사용
			- num값은 주로 sql문 작성시, where절에서 사용
			  중간에 데이터가 삭제될 경우, 연속적인 번호X			*/
		int number = count - (currentPage-1)*page_size;
			
		for(int i=0; i<list.size(); i++) {
			// 제너릭을 사용하고 있어, Object형으로 돌려주더라도 다운캐스팅은 필요X
			BoardDataBean board = list.get(i);
	%>
			<tr>
				<!-- 화면 출력번호 -->
				<td><%= number-- %></td>
					
				<!-- 댓글 제목 앞에 여백을 추가  -->
				<td>
	<% 			// 댓글 제목 앞에 여백 추가
				// 댓글의 경우 Re_level변수의 값이 0보다 큼
				if(board.getRe_level() > 0) {
					// 제목 앞에 댓글의 깊이만큼 수평간격을 넓힘
					for(int j=1; j<=board.getRe_level(); j++){ %>
						&nbsp;&nbsp;
	<% 				}
				}
	%>
					<!-- 제목 좌우에 상세페이지로 이동하는 하이퍼링크 설정 -->
					<a href="content.jsp?num=<%= board.getNum() %>&page=<%= currentPage %>">
							<%= board.getSubject() %></a>
				</td>
				<td><%= board.getWriter() %></td>
				<td><%= sd.format(board.getReg_date()) %></td>
				<td><%= board.getReadcount() %></td>
				<td><%= board.getIp() %></td>
			</tr>
			
	<%	
		} // end for
			
	%>
		</table>
		
<% 
	}// if~else end
%>


<!-- 페이지 링크 설정 -->
	<center>
<% 
	if(count > 0) {
		
		// pageCount : 총 페이지수
		int pageCount = count / page_size + ((count % page_size == 0) ? 0 : 1);
		
		// startPage : 각 블럭의 시작 페이지 번호 : 1, 11, 21,...
		// endPage : 각 블럭의 끝 페이지 번호 	: 10, 20, 30,...
		int startPage = ((currentPage - 1) / 10) * 10 + 1;
		int block = 10;			// 1개의 블럭은 10개의 page로 구성
		int endPage = startPage + block - 1;
		
		// 가장 마지막 블럭에는 endPage값을 pageCount값으로 설정 -> 존재하지 않는 페이지X
		if(endPage > pageCount) {
			endPage = pageCount;
		}
%>
		<!-- 1page로 이동 -->
		<a href="list.jsp?page=1"
			style="text-decoration:none">◀◀</a>
<% 
		// 이전 블록으로 이동
		if(startPage > 10) {
%>
			<a href="list.jsp?page=<%= startPage-10 %>">◁[이전]</a>
<%			
		}


		// 각 블럭당 10개의 페이지 출력
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage) {
				// 현재 페이지인 경우, 링크X
%>
				[<%= i %>]
<%			} else {
				// 현재 페이지가 아닌 경우, 링크삽입O
%>
				<a href="list.jsp?page=<%= i %>">[<%= i %>]</a>
<%
			}
		}// end for
		
		
		// 다음 블럭으로 이동
		if(endPage < pageCount) {
%>			
			<a href="list.jsp?page=<%= startPage+10 %>">[다음]▷</a>	
<%			
		}
%>			
		<!-- 마지막 페이지로 이동 -->
		<a href="list.jsp?page=<%= pageCount %>"
			style="text-decoration:none">▶▶</a>
<%		
	} // end if
%>
	</center>

</body>
</html>

