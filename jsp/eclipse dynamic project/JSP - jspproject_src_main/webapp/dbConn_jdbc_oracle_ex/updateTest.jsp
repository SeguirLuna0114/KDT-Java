<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		// JDBC방식
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
	
		String sql = "select * from member1 where id=?";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
	
		if (rs.next()) { // id가 있으면
			String rId = rs.getString("id");
			String rPasswd = rs.getString("passwd");
	
			if (id.equals(rId) && passwd.equals(rPasswd)) {
				// 비밀번호 일치하는 경우 - 이름과 수정 날짜를 update
				sql = "update member1 set name= ?, reg_date=sysdate  where id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				
				// update SQL문 실행
				pstmt.executeUpdate();
%>
			<script>
				alert("회원 정보 수정 성공");
				location.href = "selectTest.jsp";
			</script>
<%
			} else {
				// 비밀번호 불일치 시
%>
			<script>
				alert("비밀번호가 틀렸습니다");
				// 이전 페이지(수정 form)으로 돌아감
				history.go(-1);
			</script>

<%
			}
		} else {
%>
		<script>
			alert("아이디가 틀렸습니다.");
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