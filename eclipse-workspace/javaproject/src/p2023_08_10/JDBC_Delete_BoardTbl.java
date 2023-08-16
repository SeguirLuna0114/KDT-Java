package p2023_08_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* 	
 * Oracle 데이터베이스의 지정 테이블에서 레코드를 삭제하는 예제
 */
public class JDBC_Delete_BoardTbl {

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
		
		// SQL문을 저장하기 위한 변수
		String sql;
		
		// 입력받은 no에 해당하는 데이터(레코드)를 삭제
		int no;
		
		try {
//			3. 드라이버 로드 -> 데이터베이스 연결
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스 로드)
			Class.forName(driver);
			
			// Connection 객체 생성 with DriverManager.getConnection()메소드
			con = DriverManager.getConnection(url, "scott", "tiger");
			
//			4. 테이블에서 값을 삭제할 no를 콘솔창에서 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("board 테이블에서 삭제할 글 번호(no)를 입력....");
			System.out.print("번호를 입력하세요?");
			no = Integer.parseInt(br.readLine());
			
//			5. SQL 쿼리 생성 및 PreparedStatement 객체 설정
			// DELETE 쿼리문 작성
			sql = "DELETE FROM board WHERE no = ?";
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// pstmt의 setXxx()메소드로 데이터 바인딩
			pstmt.setInt(1, no);
			
//			6. 쿼리 실행 및 결과 출력
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println(no+"번 글 삭제 성공");
			} else {
				System.out.println("글 삭제 실패...");
			}
			
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
			
		} finally {
//			7. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
