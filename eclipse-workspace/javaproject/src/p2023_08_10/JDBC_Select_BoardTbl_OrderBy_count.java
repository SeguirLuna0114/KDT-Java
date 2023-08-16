package p2023_08_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class JDBC_Select_BoardTbl_OrderBy_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1. 드라이버 로딩 및 연결 설정
		// Oracle JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		// url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
//		2. 데이터베이스 연결 객체 및 PreparedStatement 객체 선언
		// Connection 객체(데이터베이스 연결 객체) 선언
		Connection con = null;
		// PreparedStatement 객체(미리 컴파일된 SQL문 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;
		
		// ResultSet 객체 선언 - SELECT쿼리를 실행한 후 결과값을 데이터베이스에서 가져오기 위함
		ResultSet rs = null;
		// 회원 수를 조회하기 위한 ResultSet 객체를 선언
		// - 회원 수를 조회하는 SQL 쿼리를 작성하고 실행한 후 결과를 rs01에 저장
		ResultSet rs01 = null;
		
		// SQL문을 저장할 변수 선언
		String sql;
		
		// 변수 선언
		int no = 0;
		String writer, passwd, subject, content, ts;
		int cnt = 0; // 회원수 저장

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");
			
//			5. ResultSet객체를 이용하여 전체 회원의 수를 조회하고 출력
			// 회원 수를 조회하는 SQL 쿼리를 작성
			// count(*) : 총 데이터 갯수를 구해주는 함수
			String sql01 = "select count(*) from board";
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql01);
			
			// executeQuery() 메서드를 호출하여 생성한 SQL 쿼리를 실행하고
			// 결과를 ResultSet 객체인 rs01에 저장
			rs01 = pstmt.executeQuery();
			
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			if (rs01.next()) {	// count(*)SQL 집계 함수의 결과는 단일값 => while문 대신 if문 사용 가능
				// 첫 번째 컬럼의 값(총 회원수)을 정수로 가져와서 변수 cnt에 저장
				cnt = rs01.getInt(1);
//				cnt = rs01.getInt("count(*)");
			}
			System.out.println("총 데이터 갯수:" + cnt);
			
			
//			6. SQL 쿼리 생성 및 실행
			// SELECT쿼리 작성
			sql = "SELECT * FROM board";
			
			System.out.println("번호 \t 작성자 \t 비밀번호 \t 제목 \t 내용 \t\t 작성날짜");
			System.out.println("------------------------------------------------------------");
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// executeQuery()메소드로 생성한 SQL쿼리를 실행하고 결과를 ResultSet객체인 rs에 저장
			rs = pstmt.executeQuery();
			
//			7. ResultSet에서 레코드를 하나씩 가져와 필드값 출력
			// sysdate로 작성된 Timestamp클래스 값을 데이터포맷팅하여 출력
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss EEE요일");
			
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			while(rs.next()) {
				no = rs.getInt("no");
				writer = rs.getString("writer");
				passwd = rs.getString("passwd");
				subject = rs.getString("subject");
				content = rs.getString("content");
				ts = dateFormat.format(rs.getTimestamp("reg_date"));
				System.out.printf("%d \t %s \t %s \t %s \t %s \t\t %s", no, writer, passwd, subject, content, ts);
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
//			8.생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
