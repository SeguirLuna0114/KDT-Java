package p2023_08_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* JDBC(Java Database Connectivity)를 사용하여
 * MySQL 데이터베이스에 연결하고, 
 * 입력받은 no에 해당하는 레코드(행) 삭제
 * 
 * - 삭제시에는, Primary Key로 설정된 컬럼의 데이터를 활용해서 삭제
 * *delete 데이터 삭제
 * 형식: 1) delete from 테이블명;		// 테이블의 전체 레코드(행)값을 삭제
 * 		2) delete from 테이블명 where 조건절		// 조건에 해당하는 레코드(행)값만 삭제
 */
public class JDBC_MySQL_Delete_BoardTbl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/** ORACLE JDBC Driver Test *****************************************/
		// Oracle JDBC 드라이버 클래스
//		String driver = "oracle.jdbc.driver.OracleDriver";
		// url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/*******************************************************************/

//		1. MySQL JDBC 드라이버 및 연결정보 설정
		/* MySQL 데이터베이스의 JDBC 드라이버 클래스 이름을 driver변수에 저장
		   		연결할 MySQL 데이터베이스의 URL을 url변수에 저장
				- localhost: 데이터베이스 서버가 실행중인 호스트 IP
				- jsptest: 연결할 데이터베이스 이름 */		
		/** My-SQL JDBC Driver *********************************************/
		String driver = "com.mysql.cj.jdbc.Driver";		// version 8.xx
		String url = "jdbc:mysql://localhost:3306/jsptest";	// version 8.xx
				
		// 강사님 mysql로 접속하는 url(타 IP주소로 접속)
//		String url = "jdbc:mysql://172.30.1.33:3306/jsptest";	// version 8.xx
		/*******************************************************************/
		
		
//		2. 데이터베이스 연결객체 및 PreparedStatement 객체 선언
		// Connection 객체(데이터베이스 연결 객체)를 선언 => 이 객체를 통해 데이터베이스 작업 수행 가능
		Connection con = null;
		// PreparedStatement 객체(미리 컴파일된 SQL문 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;
		
		// SQL문을 저장하기 위한 변수
		String sql;
		
		// 입력받은 no에 해당하는 데이터(레코드)를 삭제
		int no;
		
		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");
			
//			5. 테이블에서 값을 삭제할 no를 콘솔창에서 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("board 테이블에서 삭제할 글 번호(no)를 입력....");
			System.out.print("번호를 입력하세요?");
			no = Integer.parseInt(br.readLine());		// 예외 발생 가능성 O(숫자로 변환할 수 없는 문자 입력시)
			
//			6. SQL 쿼리 생성 및 PreparedStatement 객체 설정
			// DELETE 쿼리문 작성
			sql = "DELETE FROM board WHERE no = ?";		// 해당하는 no와 일치하는 레코드 삭제
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// pstmt의 setXxx()메소드로 데이터 바인딩
			pstmt.setInt(1, no);
			
//			7. 쿼리 실행 및 결과 출력
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println(no+"번 글 삭제 성공");
			} else {
				System.out.println("글 삭제 실패...");
			}
			
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("숫자만 입력하세요!");
			
		} finally {
//			8. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
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
