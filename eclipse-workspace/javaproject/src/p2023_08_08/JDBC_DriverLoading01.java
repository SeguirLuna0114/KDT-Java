package p2023_08_08;

import java.sql.*;

/* 데이터베이스에 접속하기 위해 JDBC 드라이버를 로드하는 과정을 보여주는 예제
 * 
 * JDBC(Java Database Connectivity)는 자바 언어를 사용하여 
 * 데이터베이스와 상호작용하기 위한 API(응용 프로그램 프로그래밍 인터페이스)를 제공
 * 
 * # static Class<?> forName(String className) 메소드 => Class.forName("String")으로 실행
 * : 주어진 문자열로 지정된 "className"을 동적으로 로딩
 * - 문자열 "className": 드라이버 클래스의 전체 이름(패키지명 포함)을 나타내는 문자열
 * - 위 메소드는 주로 JDBC드라이버 클래스를 로드하는데 사용
 * - 해당 클래스의 바이트 코드가 JVM(Java Virtual Machine)에 로드되며,
 *   클래스 초기화 블록이 실행
 */
public class JDBC_DriverLoading01 {

	public static void main(String[] args) {

		// 오라클 데이터베이스용 드라이버
		/** ORACLE JDBC Driver Test ***************************/
		String driver = "oracle.jdbc.driver.OracleDriver";
		/******************************************************/

		// MySQL 데이터 베이스용 드라이버
		/** My-SQL JDBC Driver Test **************************/
//		String driver ="com.mysql.jdbc.Driver";
		/*****************************************************/

		try {
			// JDBC Driver Loading(해당 드라이버 클래스가 JVM에 로드됨)
			// 선택된 드라이버를 동적으로 로딩
			Class.forName(driver);
			System.out.println("JDBC Driver Loading 성공~!!");

		} catch (Exception e) {
			// 드라이버 로딩이 실패한 경우, 해당 문장이 출력
			System.out.println("JDBC Driver Loading 실패~!!");
			e.printStackTrace();	// 예외의 상세 내용을 출력
		}
	}
}
