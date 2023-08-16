package p2023_08_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class JDBC_Select_BoardTbl {

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
		ResultSet rs_cnt = null;	// 데이터 총 개수를 조회하기 위한 ResultSet 객체를 선언
		ResultSet rs = null;	// SELECT 쿼리문의 결과를 할당할 Result객체
		
		// SQL문을 저장할 변수 선언
		String sql;
		
		// 각 컬럼의 자료형에 따라 구해온 값을 할당할 변수 선언
		int no = 0;
		String writer, passwd, subject, content, ts;
		
		// 데이터의 총 개수를 저장할 변수
		int count = 0;
		
		try {
//			3. 드라이버 로드 -> 데이터베이스 연결
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");
			
//			4. SQL 쿼리 생성 및 실행
//			4-1. 총 데이터를 조회하는 SQL 쿼리 작성
			String sql_cnt = "SELECT count(*) FROM board";
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql_cnt);
			
			// executeQuery() 메서드를 호출하여 생성한 SQL 쿼리를 실행하고
			// 결과를 ResultSet 객체인 rs_cnt에 저장
			rs_cnt = pstmt.executeQuery();
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할
			// 이때, count(*)SQL 집계 함수의 결과는 단일값 => while문 대신 if문 사용 가능
			if (rs_cnt.next()) {
				// getInt(int columnIndex) 메소드를 사용하여 컬럼 값 가져옴
				// 첫번째 컬럼의 값(데이터 총 개수)를 정수로 가져와서 변수 count에 저장
				count = rs_cnt.getInt(1);
			}
			System.out.println("총 데이터 갯수: "+count);
			
//			4-2. SELECT쿼리 작성
			sql = "SELECT * FROM board ORDER BY no DESC";
			// ORDER BY 구문을 사용해서 특정 열의 값에 따라 정렬(DESC - 내림차순)
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리 실행할 준비
			pstmt = con.prepareStatement(sql);	// PreparedStatement 객체는 재사용 가능
			
			// executeQuery()메소드로 생성한 SQL쿼리를 실행하고 결과를 ResultSet객체인 rs에 저장
			rs = pstmt.executeQuery();
			
//			5. ResultSet에서 레코드를 하나씩 가져와 필드값 출력
			// sysdate로 작성된 Timestamp클래스 값을 데이터포맷팅하여 출력
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss EEE요일");
			
			System.out.println("번호 \t 작성자 \t 비밀번호 \t 제목 \t 내용 \t\t 작성날짜");
			System.out.println("------------------------------------------------------------");
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			while(rs.next()) {
				no = rs.getInt("no");
				writer = rs.getString("writer");
				passwd = rs.getString("passwd");
				subject = rs.getString("subject");
				content = rs.getString("content");
				ts = dateFormat.format(rs.getTimestamp("reg_date"));
				// 만일, 데이터 포맷팅 하지 않고, 그냥 시간 날짜 데이터를 출력하는 경우 
//				ts = rs.getTimestamp("reg_date");
				
				// printf()메소드로 출력하는 방법(정수는 %d, 문자열은 %s)
				System.out.printf("%d번 \t %s \t %s \t %s \t %s \t %s \n", no, writer, passwd, subject, content, ts);
				// 그냥 출력하는 방법
//				System.out.print(no+"\t"+writer+"\t"+passwd+"\t"
//								+subject+"\t"+content+"\t\t"+ts+"\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
//			8.생성한 ResultSet, prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
				// 객체가 초기값이 할당되어 초기화 되었다면, 객체는 null이 아니고 올바르게 생성되었다는 것
				if(rs_cnt != null) {
					rs_cnt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// 객체가 초기화되지 않았을 경우(객체 == null), close()호출이 아닌, 예외처리
				System.out.println(e.getMessage());
			}
		}
	}

}
