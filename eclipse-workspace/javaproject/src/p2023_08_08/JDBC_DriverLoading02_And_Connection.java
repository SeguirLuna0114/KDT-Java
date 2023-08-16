package p2023_08_08;

import java.sql.*;

/*	JDBC를 사용하여 데이터베이스에 올바른 드라이버 및 연결 URL을 사용하여
 *  데이터베이스에 연결을 시도하고, 연결이 성공한 경우 연결을 닫는 과정을 보여주는 예제
 *  
 * 	# static Class<?> forName(String className) 메소드 => Class.forName("String")으로 실행
 * 	: 주어진 문자열로 지정된 "className"을 동적으로 로딩
 *	- 문자열 "className": 드라이버 클래스의 전체 이름(패키지명 포함)을 나타내는 문자열
 * 	- 위 메소드는 주로 JDBC드라이버 클래스를 로드하는데 사용
 * 	- 해당 클래스의 바이트 코드가 JVM(Java Virtual Machine)에 로드되며,
 *   	클래스 초기화 블록이 실행
 *   
 *  # 데이터베이스 연결
 *  1. Connection 객체를 선언
		- 데이터베이스 연결을 나타냄. 
		- 연결이 성공적으로 수립될 경우, 이 객체를 통해 데이터베이스 작업 수행 가능
		Connection con = null;
	2. DriverManager 클래스의 getConnection메소드를 사용하여 데이터베이스에 연결을 시도
		- static Connection getConnection(String url, String user, String password) 메소드 사용
		- url: 연결 URL, user: 데이터베이스 사용자 이름, password: 비밀번호
		
	# String url = "jdbc:oracle:thin:@172.30.1.33:1521:xe";
		url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
	- "jdbc:oracle:thin:" : JDBC드라이버를 사용하여 Oracle데이터베이스에 접속. 
							thin은 Oracle Thin 클라이언트를 사용한다는 의미
	- "@localhost" : 데이터베이스 서버의 IP주소. localhost로 설정하면 현재 실행중인 컴퓨터에 데이터베이스 서버가 있다는 것을 의미
	- "1521" : 데이터베이스 포트번호 의미. Oracle 데이터베이스는 기본적으로 1521 포트 사용
	- "xe" : 데이터베이스 객체 이름 의미. Oracle 데이터베이스의 인스턴스 중 xe(Express Edition, 간편버전)을 의미.
 */
public class JDBC_DriverLoading02_And_Connection {

	public static void main(String[] args) {

		// 드라이버 및 URL 선택(사용하려는 데이터베이스에 따라 주석 해제하여 해당 드라이버와 URL 연결)
		// 오라클 데이터베이스에 대한 드라이버 및 연결 URL
		/** ORACLE JDBC Driver Test *****************************************/
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@172.30.1.33:1521:xe";
		/*******************************************************************/
//		 url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
//		 - "jdbc:oracle:thin:" : JDBC드라이버를 사용하여 Oracle데이터베이스에 접속. 
//									thin은 Oracle Thin 클라이언트를 사용한다는 의미
//		 - "@localhost" : 데이터베이스 서버의 IP주소. localhost로 설정하면 현재 실행중인 컴퓨터에 데이터베이스 서버가 있다는 것을 의미
//		 - "1521" : 데이터베이스 포트번호 의미. Oracle 데이터베이스는 기본적으로 1521 포트 사용
//		 - "xe" : 데이터베이스 객체 이름 의미. Oracle 데이터베이스의 인스턴스 중 xe(Express Edition, 간편버전)을 의미.
		
		
		// MySQL 데이터베이스에 대한 드라이버 및 연결 URL
		/** My-SQL JDBC Driver *********************************************/
//		String driver ="com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost/academy";
		/*******************************************************************/

		// Connection 객체를 선언
		// - 데이터베이스 연결을 나타냄. 
		// - 연결이 성공적으로 수립될 경우, 이 객체를 통해 데이터베이스 작업 수행 가능
		Connection con = null;

		try {
			// JDBC Driver Loading(해당 드라이버 클래스가 JVM에 로드됨)
			// 선택된 드라이버를 동적으로 로딩
			Class.forName(driver);

			// DriverManager 클래스를 사용하여 데이터베이스에 연결을 시도
			// - static Connection getConnection(String url, String user, String password) 메소드 사용
			// 		- url: 연결 URL, 두 번째 인자: 데이터베이스 사용자 이름, 세 번째 인자: 비밀번호
			/** ORACLE에서 Connection 객체 ***********************************/
			con = DriverManager.getConnection(url, "scott", "tiger");
			/*******************************************************************/

			/** My-SQL에서 Connection 객체 ***********************************/
//	  		con = DriverManager.getConnection(url, "totoro", "1234" );
			/*******************************************************************/

			// 데이터베이스 연결이 성공하면 출력
			System.out.println("데이터베이스 연결 성공~!!");

		} catch (Exception e) {
			// 데이터베이스 연결 과정에서 예외가 발생한 경우, 해당 예외를 처리
			System.out.println("데이터베이스 연결 실패~!!");
			e.printStackTrace();	// 예외의 상세 내용이 출력
			
		} finally {
			// 연결을 닫아 데이터베이스 리소스를 해제 
			try {
				if (con != null)
					// .close();를 호출하여 데이터베이스 연결을 닫음
					con.close();
				
			} catch (Exception e) {
				// 데이터베이스 연결 과정에서 예외가 발생한 경우, 해당 예외를 처리
				System.out.println(e.getMessage());
			}
		}
	}
}
