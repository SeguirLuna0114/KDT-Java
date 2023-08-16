package p2023_08_10;

import java.sql.*;

public class JDBC_MySQL_Connect02 {

	public static void main(String[] args) {

		/** ORACLE JDBC Driver Test *****************************************/
//		String driver = "oracle.jdbc.driver.OracleDriver"; 
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		/*******************************************************************/

//		1. MySQL JDBC 드라이버 및 연결정보 설정
		// MySQL 데이터베이스의 JDBC 드라이버 클래스 이름을 driver변수에 저장
		// 연결할 MySQL 데이터베이스의 URL을 url변수에 저장
		//		- localhost: 데이터베이스 서버가 실행중인 호스트 IP
		//		- jsptest: 연결할 데이터베이스 이름		
		/** My-SQL JDBC Driver *********************************************/
//		String driver = "com.mysql.jdbc.Driver";		// version 5.xx
//		String url = "jdbc:mysql://localhost:3306/jsptest?serverTimezone=Asia/Seoul&useSSL=false";	// version 5.xx
		String driver = "com.mysql.cj.jdbc.Driver";		// version 8.xx
		String url = "jdbc:mysql://localhost:3306/jsptest";	// version 8.xx
		
		// 강사님 mysql로 접속하는 url
//		String url = "jdbc:mysql://172.30.1.33:3306/jsptest";	// version 8.xx
		/*******************************************************************/

//		2. Connection 객체 선언
		// 데이터베이스와의 연결을 나타내는 Conneciton 객체 선언
		Connection con = null;

		try {

//			3. MySQL JDBC 드라이버 클래스를 로드
			Class.forName(driver);

			/** ORACLE에서 Connection 객체 ***********************************/
//    		con = DriverManager.getConnection(url, "scott", "tiger" );
			/*******************************************************************/

//			4. Connection 객체 생성 => MySQL데이터베이스에 대한 연결 생성
			//		- Connection getConnection("url", "user", "password")
			/** My-SQL에서 Connection 객체 ***********************************/
			con = DriverManager.getConnection(url, "jspid", "jsppass");
			/*******************************************************************/

//			5. 데이터베이스 연결 확인
			System.out.println("데이터베이스 연결 성공~!!");

		} catch (Exception e) {
			// 데이터베이스 연결과정에서 발생하는 예외 처리
			System.out.println("데이터베이스 연결 실패~!!");
			e.printStackTrace();
			
		} finally {
//			6. 데이터베이스 연결을 안전하게 종료
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
