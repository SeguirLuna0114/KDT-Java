<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>

<html>
<head>
	<title>회원목록</title>
</head>
<body>
	<h2>회원목록</h2>

	<a href="insertTestForm.jsp">회원가입</a>
	<TABLE width="800" border="1">
		<TR>
			<TD width="100">아이디</TD>
			<TD width="100">패스워드</TD>
			<TD width="100">이름</TD>
			<TD width="250">가입일자</TD>
			<TD width="100">수정</TD>
			<TD width="100">삭제</TD>
		</TR>

		<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs01 = null;
			int cnt = 0;
	
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password = "tiger";
	
				// JDBC방식
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
	
				// 1. 총 회원수를 구해주는 sql문 - count(*)
				pstmt = con.prepareStatement("select count(*) from member1");
				rs01 = pstmt.executeQuery();	// select문 실행
				
				// next()메소드로 SQL문을 만족하는 데이터를 가져오면 true가 리턴됨
				if (rs01.next()) {
					// getInt(int columnIndex)
					cnt = rs01.getInt(1);
//					cnt = rs01.getInt("count(*)");
				}
	
				// 2. 회원 목록 데이터를 가져오는 sql문 - select * from 테이블명
				String sql = "select * from member1";
	
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();		// select문 실행
				
				// 날짜 출력 형식 설정
				SimpleDateFormat sd =
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
				// next()메소드로 SQL문을 만족하는 데이터를 가져오면 true가 리턴됨
				while (rs.next()) {
					String id = rs.getString("id");
					String passwd = rs.getString("passwd");
					String name = rs.getString("name");
					Timestamp register = rs.getTimestamp("reg_date");
		%>
		<TR>
			<TD width="100"><%=id%></TD>
			<TD width="100"><%=passwd%></TD>
			<TD width="100"><%=name%></TD>
			<%-- reg_date를 SimpleDateFormat클래스를 사용하여 형식 설정
				 <TD width="250"><%=register.toString()%></TD> --%>
			<TD width="250"><%=sd.format(register)%></TD>
			
			<TD width="100">
				<!-- where조건절에 id값을 사용하기 위해서 필요 -->
				<a href="updateTestForm.jsp?id=<%=id%>">수정</a>
			</TD>
			<TD width="100">
				<!-- where조건절에 id값을 사용하기 위해서 필요 -->
				<a href="deleteTestForm.jsp?id=<%=id%>">삭제</a>
			</TD>
		</TR>
		<%
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException sqle) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException sqle) {
					}
				if (con != null)
					try {
						con.close();
					} catch (SQLException sqle) {
					}
			}
		%>
	</TABLE>

	총 회원수:<%=cnt%>명

</body>
</html>