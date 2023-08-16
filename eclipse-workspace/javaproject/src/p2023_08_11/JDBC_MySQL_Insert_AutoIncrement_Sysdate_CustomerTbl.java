package p2023_08_11;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* JDBC(Java Database Connectivity)를 사용하여
 * MySQL 데이터베이스에 연결하고, 입력받은 회원정보를 추가
 * 
 * insert 테이터 입력
 * 형식: 1) 선택한 컬럼에만 해당 데이터 입력
 * 			insert into 테이블명(컬럼1, 컬럼2,...) values (데이터1, 데이터2,...);
 * 		2) 모든 컬럼에 대해 데이터 입력
 * 			insert into 테이블명 values (데이터1, 데이터2,...);
 * 
 * - AUTO_INCREMENT: 해당 열의 값을 자동으로 증가시키는 옵션(1~)
 * - sysdate(): 데이터베이스 시스템의 현재 날짜와 시간을 가져오는 함수
*/

class JDBC_MySQL_Insert_AutoIncrement_Sysdate_CustomerTbl {
	
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

//		ResultSet rs = null;
		// SQL 쿼리를 저장하는 문자열 변수
		String sql;

		// 입력 받을 데이터를 저장할 변수
		String name, email, tel, address;

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

//			5. 사용자 입력 받기-사용자로부터 이름, 이메일, 전화번호, 주소를 입력 받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(" customer 테이블에 값 입력하기 .....");
			System.out.print(" 이름 입력: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print(" 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print(" 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음
			System.out.println(" 주소 입력: ");
			address = br.readLine();

//			6. INSERT 쿼리문 작성 및 실행
			// INSERT 쿼리문을 작성
			/** no컬럼에 대해서는 auto_increase 키워드를 사용해 테이블 생성했기에,
			 * 1부터 1씩 증가된 값을 자동으로 입력 => 데이터 삽입 시, 값을 지정하지 않아도 됨
			 * 
			 ** reg_date컬럼에 대해서는
			 * sysdate()함수를 사용해, 데이터베이스 시스템의 현재 날짜와 시간을 가져옴
			 */
			sql = "INSERT into customer (name, email, tel, address, reg_date)";
			sql += " values (?, ?, ?, ?, sysdate())";
			// ?는 매개변수(파라미터)를 나타내며, 나중에 PreparedStatement 객체에서 실제 값을 설정할 때 사용
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// 매개변수 ?에 변수의 값을 설정
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 쿼리를 실행하고 데이터베이스에 데이터를 삽입
			// * int executeUpdate 메서드: 쿼리를 실행하고, 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("데이터 입력 성공");
			} else {
				System.out.println("데이터 입력 실패");
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
//				7. PreparedStatement와 Connection을 닫아 데이터베이스 연결을 종료
			try {
				// if (rs != null)
				// rs.close();
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
