package p2023_08_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/* JDBC(Java Database Connectivity)를 사용하여
 * MySQL 데이터베이스에 연결하고, 
 * 입력받은 no에 해당하는 테이블 정보를 수정
 */
public class JDBC_MySQL_Update_sysdate_BoardTbl {

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
		// PreparedStatement 객체 선언 - 미리 컴파일된 SQL문 실행하기위한 객체
		PreparedStatement pstmt = null;
		
		// SQL문을 저장하기 위한 변수
		String sql;
		
		// 입력받은 값들 할당할 변수 선언
		int no;
		String writer, passwd, subject, content;
		// sysdate()로 수정된 시간을 입력해서 reg_date컬럼에 작성할 것
		
		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");
			
//			5. 테이블에서 값을 변경할 내용을 콘솔창에서 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" board 테이블에 값 갱신하기 .....");
			System.out.println("번호를 입력 하세요?");
			no = Integer.parseInt(br.readLine());
			System.out.print("변경할 작성자를 입력하세요: ");
			writer = br.readLine();
			System.out.print("변경할 비밀번호 입력: ");
			passwd = br.readLine();
			System.out.print("변경할 제목 입력: ");
			subject = br.readLine(); 
			System.out.print("변경할 내용을 입력하세요: ");
			content = br.readLine();
			// sysdate로 ts객체에 시간 입력할 것
			
//			6. SQL쿼리 생성 및 PreparedStatement 설정
			// sysdate를 사용해 가입날짜가 아닌 수정날짜로 변경
			// Update쿼리 작성
			sql = "UPDATE board SET writer=?, passwd=?, subject=?, content=?";
			sql += ", reg_date=sysdate() where no = ?";
			
			// prepareStatement객체를 생성해 sql문 실행 준비
			pstmt = con.prepareStatement(sql);
			
			// prepareStatement.set(int idx, String Col)메소드로
			// 데이터 바인딩
			pstmt.setString(1, writer);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			// 직접 Timestamp객체를 생성하지 않고, sysdate를 사용해 쿼리문에 직접 작성 => 시스템의 날짜와 시간 반환
			pstmt.setInt(5, no);
			
//			7. 쿼리 실행 및 결과 출력
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("글 수정 성공!!");
			} else {
				System.out.println("글 수정 실패....");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
			
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
