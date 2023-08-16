package p2023_08_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/* Oracle 데이터베이스에서 레코드를 출력하는 예제
	
 * * Timestamp 클래스 값을 SimpleDateFormat을 사용하여 포맷팅
 	1. SimpleDateFormat 객체 생성 with 지정형식
 	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");
 	
 	2. while문 내에서 
 		Timestamp 클래스로 구현된 필드를 getTimestamp()메소드로 가져오고
 		반환되는 Timestamp값을 SimpleDateFormat 형식으로 포맷팅
 		
 		while (rs.next()) {
 			String ts = dateFormat.format(rs.getTimestamp("reg_date"));
 			// 가져온 각 필드 값을 형식에 맞게 출력
			System.out.printf(" %d \t %s \t\t %s \t\t %s \t %s \t %s \t \n", no, name, email, tel, address, ts);
		}
 */
class JDBC_Select_Sequence_SimpleDateFormat {
	public static void main(String[] args) {

//		1. 드라이버 로딩 및 연결설정
		// Oracle JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		// url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

//		2. 데이터베이스 연결객체 및 PreparedStatement 객체 선언		
		// Connection 객체(데이터베이스 연결 객체)를 선언
		Connection con = null;
		// PreparedStatement 객체(미리 컴파일된 SQL 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;
		
		// ---JDBC_Select 추가된 내용 -------
		// ResultSet 객체 선언
		// -  SELECT 쿼리를 실행한 후 데이터베이스에서 레코드를 가져오기 위함
		ResultSet rs = null;
		
		int no = 0;
		String name = "", email = "", tel = "", address = "", ts = ""; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Select 추가된 내용 -------
//			4. SQL쿼리 생성 및 실행 
			sql = "SELECT * FROM customer";
			System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \t 주소\t 날짜\n");
			System.out.printf("-----------------------------------------------------------------\n");
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// executeQuery() 메서드를 호출하여 생성한 SQL 쿼리를 실행하고
			// 결과를 ResultSet 객체인 rs에 저장
			rs = pstmt.executeQuery(); // 얻어진 레코드를 가져옴

//			5. ResultSet에서 레코드를 하나씩 가져와 필드 값을 출력
			// 회원들의 가입날짜를 연, 월, 일 시:분:초 로 출력
			// Timestamp 클래스 값을 SimpleDateFormat을 사용하여 포맷팅
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");

			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			while (rs.next()) {
				// ResultSet 객체(rs)에서 getXxx()메소드를 사용해 데이터값을 가져옴
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
				address = rs.getString("address");
				
				// Timestamp 클래스의 구현에 따라 toString()메소드로 지정한 형식에 맞게 출력
//				ts = rs.getTimestamp("reg_date").toString();
				
				ts = dateFormat.format(rs.getTimestamp("reg_date"));
				
				// 가져온 각 필드 값을 형식에 맞게 출력
				System.out.printf(" %d \t %s \t\t %s \t\t %s \t %s \t %s \t \n", no, name, email, tel, address, ts);
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			6. 생성한 ResultSet, prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {// rs, stmt, con 객체를 close() 메서드를 호출해 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
