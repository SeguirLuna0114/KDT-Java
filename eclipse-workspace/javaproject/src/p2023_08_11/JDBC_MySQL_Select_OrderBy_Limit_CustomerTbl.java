package p2023_08_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/* JDBC(Java Database Connectivity)를 사용하여
 * MySQL 데이터베이스에 연결하고, 회원 수를 조회하여 출력하고, 회원 정보를 조회하여 출력
 ** ORDER BY [컬럼명] ASC/DESC	: 해당 컬럼을 기준으로 오름차순/내림차순 정렬
 * 	1. 최근에 가입한 고객 순으로 정렬
 * 		ORDER	BY	컬럼명	정렬형식(ASC: 오름차순, DESC: 내림차순)
 * 		ex) sql = "SELECT * FROM customer ORDER BY no desc";
 * 
 ** LIMIT 연산자: 데이터 범위 지정
 *	2. 최근에 가입한 고객 5명만 검색
 *		LIMIT	추출할 인덱스 시작번호, 추출할 데이터(행) 갯수
 *		ex) sql = "SELECT * FROM customer ORDER BY no desc LIMIT 0, 5";
 */
class JDBC_MySQL_Select_OrderBy_Limit_CustomerTbl {
	
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

		// ---JDBC_Select 추가된 내용 -------
		// ResultSet 객체 선언
		// -  SELECT 쿼리를 실행한 후 데이터베이스에서 레코드를 가져오기 위함
		ResultSet rs = null;
		
		int no = 0;
		String name, email, tel, address, reg_date; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언
		
		int cnt = 0; // 회원수 저장
		

		try {
//			3. MySQL JDBC 드라이버 클래스를 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			con = DriverManager.getConnection(url, "jspid", "jsppass");

			
			// ---JDBC_Select 추가된 내용 -------
			/**customer테이블
			 * - no컬럼의 경우 auto_increment를 사용해, 데이터 삽입 시, 값을 지정하지 않아도 됨.
			 * create table customer( 	no int(4) auto_increment  primary key, 
		       		   					name varchar(20),
		       		   					email varchar(20),
		       		   					tel varchar(20),
										address varchar(50),
										reg_date timestamp);
			 */
//			5. 쿼리를 실행하여 결과를 ResultSet 객체에 저장
			// 모든 회원 정보를 조회하는 SQL 쿼리를 작성
			/** ORDER BY [컬럼명] ASC/DESC	: 해당 컬럼을 기준으로 오름차순/내림차순 정렬
			 * 	1. 최근에 가입한 고객 순으로 정렬
			 * 		ORDER	BY	컬럼명	정렬형식(ASC: 오름차순, DESC: 내림차순)
			 * 		ex) sql = "SELECT * FROM customer ORDER BY no desc";
			 * 
			 ** LIMIT 연산자: 데이터 범위 지정
			 *	2. 최근에 가입한 고객 5명만 검색
			 *		LIMIT	추출할 인덱스 시작번호, 추출할 데이터(행) 갯수
			 *		ex) sql = "SELECT * FROM customer ORDER BY no desc LIMIT 0, 5";
			 */
			sql = "SELECT * FROM customer ORDER BY no desc";
//			sql = "SELECT * FROM customer ORDER BY no desc LIMIT 0, 5";		// asc(오름차순), desc(내림차순)
			
			System.out.printf("번호 \t 이름 \t 이메일 \t\t\t 전화번호 \t\t 주소 \t\t 날짜 \n");
			System.out.printf("-----------------------------------------------------------------\n");
			
			// PreparedStatement 객체를 생성하여 SQL 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// PreparedStatement 객체의 executeQuery() 메서드를 호출하여 SQL 쿼리를 실행하고
			// 결과를 ResultSet 객체에 저장. 이때 쿼리 결과는 조회된 데이터의 레코드들이 포함됨
			rs = pstmt.executeQuery(); // 얻어진 레코드를 가져옴

			
//			6. ResultSet에서 레코드를 하나씩 가져와 필드 값을 출력
			// ResultSet 객체의 next() 메서드를 반복적으로 호출하여 결과 레코드를 하나씩 순회
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			while (rs.next()) {
				// 현재 순회 중인 행의 "no" 컬럼의 정수값을 가져와서 no 변수에 저장
				no = rs.getInt("no");
				
				// 현재 순회 중인 행의 지정한 열에서 문자열 값을 가져와 변수에 저장
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
				address = rs.getString("address");
				reg_date = rs.getTimestamp("reg_date").toString();
				
				// 가져온 각 필드 값을 형식에 맞게 출력
				System.out.printf(" %d \t %s \t %s \t %s \t %s \t %s \n"
						, no, name, email, tel, address, reg_date);
			}
			
		} catch (Exception e) {
			// 데이터베이스 연결과정에서 발생하는 예외 처리
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			7. 생성한 ResultSet, prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {// rs, stmt, con 객체를 close() 메서드를 호출해 해제
				if (rs != null)
					rs.close();
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
