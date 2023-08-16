package p2023_08_09;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/* 	
 * Oracle 데이터베이스의 지정 테이블에서 레코드를 삭제하는 예제
 */
class JDBC_Delete_Sequence {
	
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
		
		// SQL문을 저장할 변수 선언
		String sql;
		
		// 삭제할 번호를 입력받는 no변수 선언
		int no;
		String name, email, tel;

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Delete 변경된 내용-------
//			4. 사용자로부터 삭제할 레코드의 번호를 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
			System.out.print("삭제할 회원 번호를 입력하세요: ");
			no = Integer.parseInt(br.readLine()); // 테이블에서 삭제할 name 필드 값을 입력 받음

//			5. SQL쿼리 생성 및 실행
			// DELETE 쿼리문을 작성
			sql = "DELETE FROM customer WHERE no = ?";
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// pstmt의 setXxx()메소드로 데이터 바인딩
			pstmt.setInt(1, no);
			
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
//			6. 결과 출력
			if (result == 1) {
				System.out.println(" 데이터 삭제 성공!! ");
			} else {
				System.out.println(" 데이터 삭제 실패 ");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			8. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
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
