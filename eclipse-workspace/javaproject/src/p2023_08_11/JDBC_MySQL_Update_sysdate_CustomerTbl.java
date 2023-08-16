package p2023_08_11;

import java.sql.*;
import java.io.*; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
/* JDBC(Java Database Connectivity)를 사용하여
 * 사용자가 입력한 정보를 바탕으로 Oracle 데이터베이스 내의 특정 레코드를 수정
 *  
 * * * PreparedStatement: JDBC에서 사용되는 인터페이스
 * * PreparedStatement 객체: SQL 쿼리를 미리 준비하여 실행할 때 사용하는 객체
 * * PreparedStatement 객체 생성방법
	  1. 데이터베이스에 연결하기 위한 Connection 객체를 획득
	  	  Connection객체는 DriverManager.getConnection() 메서드를 사용하여 얻음
	  2. Connection 객체를 통해 prepareStatement() 메서드를 호출 => PreparedStatement 객체를 생성
		ex)	PreparedStatement pstmt = connection.prepareStatement(sql);
 * * - 쿼리 템플릿에 물음표(?)를 사용해서 매개변수 위치 지정 가능
		ex)	String sql = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
 * * - 매개변수 값 바인딩: PreparedStatement 객체를 생성한 후, setXxx() 메서드를 사용하여 매개변수에 값을 바인딩
 			- void setBoolean(int parameterIndex, boolean x): 주어진 위치의 매개변수에 불리언 값을 설정
 			- void setInt(int parameterIndex, int x): 주어진 위치의 매개변수에 정수 값을 설정
 			- void setString(int parameterIndex, String x): 주어진 위치의 매개변수에 문자열 값을 설정
 * * - 주요 메소드
 * 		1) ResultSet executeQuery(): 실행된 쿼리의 결과를 ResultSet으로 반환. 주로 SELECT 쿼리에서 사용
 * 		2) int executeUpdate(): 실행된 쿼리의 결과로 영향을 받은 행의 수를 반환. 주로 INSERT, UPDATE, DELETE 쿼리에서 사용
*/
class JDBC_MySQL_Update_sysdate_CustomerTbl {
	
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
		
		// 사용자로부터 입력 받을 변경할 데이터를 저장하는 변수
		String name, email, tel, address;
		
		// 변경할 회원의 회원번호를 저장하는 변수
		int ino;

		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");

			/**customer테이블
			 * - no컬럼의 경우 auto_increment를 사용해, 데이터 삽입 시, 값을 지정하지 않아도 됨.
			 * create table customer( 	no int(4) auto_increment  primary key, 
		       		   					name varchar(20),
		       		   					email varchar(20),
		       		   					tel varchar(20),
										address varchar(50),
										reg_date timestamp);
			 */
//			5. 사용자 입력 처리(사용자로부터 변경할 데이터를 입력받음)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에 값 갱신하기 .....");
			System.out.print("수정할 회원의 회원번호를 입력? ");
			ino = Integer.parseInt(br.readLine());

			System.out.print("변경할 이름을 입력:");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print("변경할 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print("변경할 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음
			System.out.print("변경할 주소 입력: ");
			address = br.readLine();

//			6. SQL쿼리 생성 및 실행
			// 업데이트 쿼리 작성. sysdate()함수를 사용해, 데이터베이스 시스템의 현재 날짜와 시간을 가져옴
			sql = "UPDATE customer SET name = ?,email = ?, tel = ?,";
			sql += " address = ?, reg_date=sysdate() where no = ?";
			// ?는 매개변수(파라미터)를 나타내며, 나중에 PreparedStatement 객체에서 실제 값을 설정할 때 사용
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// 매개변수 ?에 변수의 값을 설정
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			pstmt.setInt(5, ino);
			
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 쿼리를 실행하고 데이터베이스에 데이터를 삽입
			// * int executeUpdate 메서드: 쿼리를 실행하고, 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
//			7. 수정된 결과 출력
			if (result == 1) {
				System.out.println("데이터 수정 성공");
			} else {
				System.out.println("데이터 수정 실패");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			8. PreparedStatement와 Connection을 닫아 데이터베이스 연결을 종료
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
