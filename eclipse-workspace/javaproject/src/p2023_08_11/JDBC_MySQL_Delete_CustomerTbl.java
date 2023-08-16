package p2023_08_11;

import java.sql.*;
import java.io.*; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
/* JDBC(Java Database Connectivity)를 사용하여
 * 사용자가 입력한 정보(회원정보)를 바탕으로 MySQL 데이터베이스 내의 특정 레코드를 삭제
*/
class JDBC_MySQL_Delete_CustomerTbl {
	
	public static void main(String[] args) {
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
		
		// PreparedStatement 객체(미리 컴파일된 SQL 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;
		
		// SQL 쿼리를 저장하는 문자열 변수
		String sql;
		
		// 삭제할 회원의 회원번호를 저장하는 변수
		int ino;

		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");

			/** 테이블에 no컬럼의 데이터들을 보여주는 코드**********
			 * 	SELECT no FROM customer;
			 * 	ResultSet 객체 활용
			 */
			String sqlno = "SELECT no FROM customer";
			pstmt = con.prepareStatement(sqlno);
			ResultSet rsno = pstmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			
			sb.append("회원 번호 리스트 출력: \n{");
			int cnt=0;
			while (rsno.next()) {
				int no = rsno.getInt("no");
				sb.append(no).append(' ');
				cnt++;
				if(cnt % 10 == 0) {
					sb.append('\n');
				}
			}
			sb.append('}').append('\n');
			System.out.println(sb);
			/*********************************************/
			
//			5. 사용자 입력 처리(사용자로부터 삭제할 회원의 회원번호를 입력받음)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
			System.out.print("삭제할 회원의 회원번호를 입력하세요? ");
			ino = Integer.parseInt(br.readLine());

			
//			6. SQL쿼리 생성 및 실행
			// DELETE 쿼리문을 작성
			sql = "DELETE FROM customer WHERE no = ?";
			// ?는 매개변수(파라미터)를 나타내며, 나중에 PreparedStatement 객체에서 실제 값을 설정할 때 사용
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// 첫 번째 매개변수 위치에 회원번호를 설정
			pstmt.setInt(1, ino);
			
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 쿼리를 실행하고 데이터베이스에 데이터를 삽입
			// * int executeUpdate 메서드: 쿼리를 실행하고, 영향을 받은 행의 수를 반환 
			int result = pstmt.executeUpdate();
			
//			7. 쿼리실행 결과 출력
			// 반환된 결과로 삭제된 레코드 수 확인
			if (result == 1) {
				System.out.println("회원 삭제 성공");
			} else {
				System.out.println("회원 삭제 실패");
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
//			8. 생성한 Statement와 Connection 객체를 닫아서 데이터베이스 연결을 종료(자원 해제)
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
