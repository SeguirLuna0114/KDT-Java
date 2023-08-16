package p2023_08_10;

import java.sql.*;

/*
 * Java 프로그램에서 JDBC(Java Database Connectivity) 드라이버를 로드하고 테스트
 */
public class JDBC_MySQL_Connect01 {

	public static void main(String[] args) {

		/** ORACLE JDBC Driver Test ***************************/
//		String driver = "oracle.jdbc.driver.OracleDriver";  
		/******************************************************/

//		1. MySQL JDBC 드라이버 로드
		// MySQL 데이터베이스의 JDBC 드라이버 클래스 이름을 driver 변수에 저장 => MySQL데이터베이스와 연결 도움
		/** My-SQL JDBC Driver Test **************************/
//		String driver = "com.mysql.jdbc.Driver";	// version 5.xx
		String driver = "com.mysql.cj.jdbc.Driver";	// version 8.xx
		/*****************************************************/

		try {
//			2. 드라이버 클래스 로딩
			// JDBC Driver Loading
			Class.forName(driver);
			System.out.println("JDBC Driver Loading 성공~!!");

		} catch (Exception e) {
//			3. 드라이버 로딩과정에서 발생하는 예외 처리
			System.out.println("JDBC Driver Loading 실패~!!");
			e.printStackTrace();
		}
	}
}
