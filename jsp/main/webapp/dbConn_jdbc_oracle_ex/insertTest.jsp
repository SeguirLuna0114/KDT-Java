<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	// 굳이 timestamp객체를 사용하지 않아도, Oracle에서 제공하는 sysdate함수를 사용하여 현재시간 입력 가능
	Timestamp register = new Timestamp(System.currentTimeMillis());
	
	Connection con = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
	try {
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
	
		// JDBC방식
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
	
		String sql = "insert into member1 values (?,?,?,sysdate)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
//		pstmt.setTimestamp(4,register);
	
		// insert SQL문 실행됨
		result = pstmt.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
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

<html>
<head>
	<title>회원가입</title>
</head>
<body>

	<%
		if (result == 1) {
	%>
		<script>
			alert("회원가입 성공");
			location.href = "selectTest.jsp";
		</script>
	<%
		} else {
	%>
		<script>
			alert("회원가입 실패");
			history.go(-1);
		</script>
	<%
		}
	%>
</body>
</html>