package p2023_08_29;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Oracle 데이터베이스에 연결하고, 
 * SQL DEVELOPER에서 생성한 매개변수가 있는 del_ename이라는 저장 프로시저를 호출하여 실행
 * 이때 입력받은 값을 인자로 받아 프로시저로 전달
 * 
 * - JDBC(Java Database Connectivity)를 이용하여 Oracle 데이터베이스에 연결
 * - CallableStatement 클래스를 사용하여 저장 프로시저를 호출하고 실행
 */
class CallableStatement_2InVarProcedure {

	public static void main(String[] args) {
		// 데이터베이스 연결을 위한 Connection 객체를 초기화
		Connection con = null;
		// 데이터베이스 URL을 설정
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 호출할 저장 프로시저의 SQL 문을 저장할 변수를 선언
		String sql = null;
		// 저장 프로시저 호출을 위한 CallableStatement 객체를 초기화
		CallableStatement cs = null;

		// 입력받은 값을 매개변수로 프로시저에 전달
		System.out.print("탈퇴할 회원명을 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		try {
			// Oracle JDBC 드라이버를 로드 => 오라클 데이터베이스와 통신 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스에 연결
			con = DriverManager.getConnection(url, "scott", "tiger");

			// 호출할 저장 프로시저의 SQL 문
			sql = "{call del_ename(?)}";

			// CallableStatement를 객체를 생성 & 생성한 객체에 호출할 SQL 문을 설정
			cs = con.prepareCall(sql);
			// setString 메소드를 사용하여 첫 번째 매개변수에 회원명 값을 설정
			cs.setString(1, name);
			
			// CallableStatement 객체를 사용하여 저장 프로시저를 실행
			cs.execute();	// execute() 메서드를 호출하면 저장 프로시저가 실행되고 결과가 처리됨
			
			System.out.println("프로시저 실행 완료");

			// 사용이 끝난 CallableStatement 객체와 데이터베이스 연결을 닫음
			cs.close();
			con.close();
			
		} catch (Exception e) {
			// 예외가 발생하면 해당 예외를 처리하여 출력
			System.out.println(e);
		}
	}
}
