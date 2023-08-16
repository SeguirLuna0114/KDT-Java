package p2023_08_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/* JDBC(Java Database Connectivity)를 사용하여
 * MySQL 데이터베이스에 연결하고, 입력받은 테이블 정보를 추가
 * 
 * AUTO_INCREMENT: 해당 열의 값을 자동으로 증가시키는 옵션(1~)
 * sysdate(): 데이터베이스 시스템의 현재 날짜와 시간을 가져오는 함수
 */
public class JDBC_MySQL_Insert_AutoIncremen_Sysdate_BoardTbl {

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
		
		// SQL문을 저장할 변수 선언
		String sql;
		
		// 입력받은 값을 변수에 저장
		String writer, passwd, subject, content;
		// 번호 no 필드는 auto-increment 옵션으로 자동 입력할 것
		// reg_date는 sysdate로 입력할 것
		
		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");
		
//			5. 사용자로부터 입력받은 데이터를 데이터베이스에 추가
			// BufferedReader객체 생성은 예외처리를 필요로하지X => try문 밖에 있어도 됨
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Board 테이블에 추가할 회원 정보를 입력...");
			
			// 번호값은 auto-increment옵션으로 자동 입력할 것
			System.out.print("작성자명 입력: ");
			writer = br.readLine();
			System.out.print("비밀번호 입력: ");
			passwd = br.readLine();
			System.out.print("제목 입력: ");
			subject = br.readLine();
			System.out.print("내용 입력: ");
			content = br.readLine();
			// 날짜 또한 sysdate()함수로 현재시간 바로 입력
			
//			6. sysdate를 사용하여 SQL 쿼리 작성
			// INSERT 쿼리문 작성
//			sql = "INSERT into board";	// 모든 필드에 작성하는 경우는 필드명 생략 가능
			sql = "INSERT into board (writer, passwd, subject, content, reg_date)";
			sql += " values (?, ?, ?, ?, sysdate())";
			
//			7. PreparedStatement 객체를 생성하여 쿼리 실행
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// pstmt의 setXxx()메소드로 데이터 바인딩
			// 시퀀스명.nextval 로 다음값을 가져와서 사용X
			pstmt.setString(1, writer);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
//			8. 결과 출력
			if(result==1) {
				System.out.println("글 작성 성공");
			} else {
				System.out.println("글 작성 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			9.생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
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
