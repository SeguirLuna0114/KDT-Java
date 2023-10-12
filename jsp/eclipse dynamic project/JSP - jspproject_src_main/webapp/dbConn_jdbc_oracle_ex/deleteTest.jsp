<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
	
		// JDBC 방식
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
	
		String sql = "select * from member1 where id = ?";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		// select문 실행
		rs = pstmt.executeQuery();
	
		if (rs.next()) {
			String rId = rs.getString("id");
			String rPasswd = rs.getString("passwd");
	
			if (id.equals(rId) && passwd.equals(rPasswd)) {
				// 비번 일치하는 경우
				sql = "delete from member1 where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				// delete SQL문 실행
				pstmt.executeUpdate();
%>
			<script>
				alert("회원 삭제 성공");
				// 삭제 성공시 회원목록(select)페이지로 이동
				location.href = "selectTest.jsp";
			</script>
<%
			} else {
				// 비번 불일치하는 경우
%>
			<script>
				alert("비밀번호가 틀렸습니다.");
				// 이전페이지로 되돌아감
				history.go(-1);
			</script>
<%
			}
%>


<%
		} else {
%>

		<script>
			alert("ID가 틀렸습니다.");
			history.go(-1);
		</script>

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