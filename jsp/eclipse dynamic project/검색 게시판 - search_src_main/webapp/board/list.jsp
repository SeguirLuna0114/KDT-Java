<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@page import="java.util.List"%>

<!-- 게시판 목록 페이지 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판 목록</title>
</head>
<body>

<!-- 한 페이지에서 보여주는 리스트의 개수를 설정 & 검색기능 설정 -->
<% 
// 	검색 항목(sel)과 검색어(find)를 받는 부분
	// 전달받은 검색항목 값과 검색어 값을 받음
	String sel = request.getParameter("sel");
	String find = request.getParameter("find");


// 	페이지 번호 설정하는 부분
	// 1. 한 화면(페이지)에 출력할 데이터 갯수
 	int page_size = 10;

	/* HTTP 요청(request)의 매개변수(parameter) 값을 추출하는 메서드 사용하여 page값을 받음 */
	String pageNum = request.getParameter("page");
	if(pageNum == null) {
		// 페이지가 전달되지 않은 경우
		pageNum = "1";		// 1page : 최근글이 보이는 페이지
	}
	
	// 2. 현재 페이지 번호가 저장될 변수
	int currentPage = Integer.parseInt(pageNum);
	
	
//	총 데이터 갯수 or 검색된 데이터 개수
	int count = 0;
	/* DB연결을 한 후 select count(*) from table SQL문을 통해
	   sel값과 find값을 기준으로 count변수를 구함*/
	BoardDBBean dao = BoardDBBean.getInstance();
	count = dao.getCount(sel, find);
	// console창에 출력
	System.out.println("count: "+count);
	
	
	// 3. 페이지 변수 설정
	/* 전체 데이터를 내림차순으로 정렬한 후,  page_size(10)만큼 잘라서 보여줌
	   startRow : 각 page에 추출할 데이터의 시작번호
	   endRow : 각 page에 추출할 데이터의 끝번호 
	   
	   ex) currentPage=1인 경우, startRow = 1, endRow = 10
	   ex) currentPage=2인 경우, startRow = 11, endRow = 20
	   => startRow : 시작값은 1이고, 간격이 10인 등차수열 => 10n -9 => 10(n-1)+1 
	   => endRow : 시작값은 10이고, 간격이 10인 등차수열 => 10n => 10(n) */
	int startRow = (currentPage -1) * page_size + 1;
	int endRow = currentPage * page_size;
	
	
// 	게시판의 여러 "목록"을 불러오기 위해 List클래스 사용
	List<BoardDataBean> list = null;
	if(count > 0) {
		list = dao.getList(startRow, endRow, sel, find);
	}
	System.out.println("list: " + list);
	
	if(count == 0) {
		// 작성된 글이 없는 경우
%>
		 <p>작성된 글이 없습니다.</p>

<%
	} else {
		// 	작성된 글이 있는 경우	
%>

	<a href="writeForm.jsp">글작성</a>
	<p>검색된 글 갯수 : <%=count %></p>
	<p>한 페이지에 출력할 데이터 갯수 : <%=page_size %></p>

	<table align=center width=700 border=1>
		<caption>게시판 목록</caption>
		<!-- 각 column의 타이틀 값 -->
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>IP주소</th>
		</tr>

	<%
		/* number : 브라우저의 각 페이지에 출력될 시작번호
		   ex) page = 1인 경우, 시작번호 : count(196)
		   ex) page = 2인 경우, 시작번호 : count(196) - 10 
		   ex) page = 3인 경우, 시작번호 : count(196) - 20
		   => 시작번호(number) = count - (page-1) * page_size */
		int number = count - (currentPage - 1) * page_size;
		   
		// 작성일 출력패턴 지정
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		for (int i = 0; i < list.size(); i++) {
			/* Object get(int index)메소드를 사용하여 데이터를 가져오기에,
			   다운캐스팅 필요하지만,
			   generic<BoardDataBean>을 사용하고 있어서 다운캐스팅 생략 가능
			   BoardDataBean board = (BoardDataBean) list.get(i); */
			BoardDataBean board = list.get(i);
	%>
		<tr>
			<!-- 시작번호로부터 1씩 감소시킴(후행연산) -->
			<td><%=number-- %></td>
			
			<!-- 상세페이지(content.jsp)로 이동하는 하이퍼링크 설정 -->
			<td>
				<!-- 하이퍼링크를 클릭할 때, get방식으로 매개변수(parameter)값을 포함하여 페이지로 전달
					 이때, page값을 전달해야, 상세페이지(content.jsp)에서 목록페이지(list.jsp)로 돌아올 수 있음 -->
				<a href="content.jsp?num=<%=board.getNum() %>&page=<%=currentPage %>">
					<%=board.getSubject()%></a>
			</td>
			<td><%=board.getWriter()%></td>
			<td><%=sd.format(board.getReg_date()) %></td>
			<td><%=board.getReadcount()%></td>
			<td><%=board.getIp()%></td>
		</tr>
	<%
		}// end for
	%>

	</table>
<% 
	}// end if
%>

	<br>

	<center>
<!-- 페이지 링크 설정 - get방식으로 page매개변수를 url에 포함하여 페이지에 전달 -->
	<% 	// 데이터가 존재할 경우에만 페이지링크 설정
		if(count > 0) {
	
			// pageCount : 총 페이지 수
			int pageCount = count / page_size + ((count % page_size == 0) ? 0 : 1);
				
			/* startPage : 각 블럭의 시작 페이지 번호 : 1, 11, 21, ...
			   endPage : 각 블럭의 끝 페이지 번호 : 10, 20, 30, ...
			   block : 페이지 번호를 나열할 단위 : 1,2,...,10
				   		(1개의 블럭의 크기 = 10개의 페이지로 구성) */
			int startPage = ((currentPage - 1)/10) * 10 + 1;
			int block = 10;
			int endPage = startPage + block -1;
				
			// 가장 마지막 블럭에 endPage값을 pageCount로 수정
			if(endPage > pageCount) {
				endPage = pageCount;
			}
	%>
	
	<!-- case1) 검색기능 없이,
				전체 데이터로 페이지 이동 설정하는 경우 -->
		<% 
			// 전체 목록 페이지 링크
			if(sel == null && find == null) {
		%>
				<!-- 첫번째 페이지로 이동하게 설정 -->
				<a href="list.jsp?page=1"
				   style="text-decoration:none"> ◀◀</a>
				   
		<%
				// 1. 블럭 단위로 (이전 블록으로) 이동하게 설정
				if(startPage > 10) {
		%>
					<!-- 화살표를 클릭할 경우, 각 블럭의 첫번째 페이지로 이동하게 설정 -->
					<a href="list.jsp?page=<%=startPage-10 %>"
					   style="text-decoration:none"> ◁[이전]</a>
		<%
				}
		
				// 2. 각 블럭 당 10개의 페이지 출력
				for(int i=startPage; i<=endPage; i++) {
					if(i == currentPage) {
						// 현재 페이지인 경우의 페이지번호 => 링크 X
		%>
						[<%=i%>]
		<%
					} else {
						// 현재 페이지가 아닌 경우의 페이지번호 => 링크 삽입
		%>
						<a href="list.jsp?page=<%=i %>">[<%=i %>]</a>
		<%	
					}
				}
				
				// 3. 다음 블럭 단위로 이동하게 설정
				if(endPage < pageCount) {
		%>
					<!-- 화살표를 클릭할 경우, 각 블럭의 마지막 페이지로 이동하게 설정 -->
					<a href="list.jsp?page=<%=startPage+10 %>"
					   style="text-decoration:none"> [다음]▷</a>
		<% 
				}
		%>
				<!-- 마지막 페이지로 이동하게 설정 -->
				<a href="list.jsp?page=<%=pageCount %>"
				   style="text-decoration:none"> ▶▶</a>
	
				
	<!-- case2) 검색기능을 활용하여,
				선택된 데이터로 페이지 이동 설정하는 경우 -->
		<%
			} else if(sel != null & find != null) {
				// 검색 목록 페이지 링크
		%>
				<!-- 첫번째 페이지로 이동하게 설정 -->
				<a href="list.jsp?page=1&sel=<%=sel %>&find=<%=find %>"
				   style="text-decoration:none"> ◀◀</a>
				   
		<%
				// 1. 블럭 단위로 (이전 블록으로) 이동하게 설정
				if(startPage > 10) {
		%>
					<!-- 화살표를 클릭할 경우, 각 블럭의 첫번째 페이지로 이동하게 설정 -->
					<a href="list.jsp?page=<%=startPage-10 %>&sel=<%=sel %>&find=<%=find %>"
					   style="text-decoration:none"> ◁[이전]</a>
		<%
				}
		
				// 2. 각 블럭 당 10개의 페이지 출력
				for(int i=startPage; i<=endPage; i++) {
					if(i == currentPage) {
						// 현재 페이지인 경우의 페이지번호 => 링크 X
		%>
						[<%=i%>]
		<%
					} else {
						// 현재 페이지가 아닌 경우의 페이지번호 => 링크 삽입
		%>
						<a href="list.jsp?page=<%=i %>&sel=<%=sel %>&find=<%=find %>">[<%=i %>]</a>
		<%	
					}
				}
				
				// 3. 다음 블럭 단위로 이동하게 설정
				if(endPage < pageCount) {
		%>
					<!-- 화살표를 클릭할 경우, 각 블럭의 마지막 페이지로 이동하게 설정 -->
					<a href="list.jsp?page=<%=startPage+10 %>&sel=<%=sel %>&find=<%=find %>"
					   style="text-decoration:none"> [다음]▷</a>
		<% 
				}
		%>
				<!-- 마지막 페이지로 이동하게 설정 -->
				<a href="list.jsp?page=<%=pageCount %>&sel=<%=sel %>&find=<%=find %>"
				   style="text-decoration:none"> ▶▶</a>
	<% 
			} //end if-elseif
		} //end if
	%>
	
	</center>
	<br><br><br>
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
		$(document).ready(function() {
			$("form").submit(function() {
				/* select태그의 값을 설정하지 않으면, 값 전달X */
				if($("select").val() == "") {
					alert("검색할 항목을 선택 하세요?");
					$("select").focus();
					return false;
				}
				
				/* id값이 find인 태그 값을 입력하지 않으면, 값 전달X */
				if($("#find").val() == "") {
					alert("검색어를 입력 하세요?");
					$("#find").focus();
					return false;
				}
			});
		});
	</script>
	
	
	<!-- 검색기능 구현 -->
	<form action="list.jsp">
		<!-- 해당 sel변수값과 find변수값을 list.jsp파일로 전달 -->
		<select name="sel">
			<option value="">검색</option>
			<option value="writer">작성자</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="find" id="find">
		<input type="submit" name="검색" value="검색">
	</form>
			
</body>
</html>