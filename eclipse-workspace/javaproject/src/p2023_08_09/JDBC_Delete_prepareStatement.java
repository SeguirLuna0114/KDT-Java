package p2023_08_09;

import java.sql.*;
import java.io.*; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
/* JDBC(Java Database Connectivity)를 사용하여
 * 사용자가 입력한 정보(회원정보)를 바탕으로 Oracle 데이터베이스 내의 특정 레코드를 삭제
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
class JDBC_Delete_prepareStatement {
	
	public static void main(String[] args) {
//		1. 드라이버 로딩 및 연결설정
		// Oracle JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		// url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// - "jdbc:oracle:thin:" : JDBC드라이버를 사용하여 Oracle데이터베이스에 접속. 
		// 	  thin은 Oracle Thin 클라이언트를 사용한다는 의미
		// - "@localhost" : 데이터베이스 서버의 IP주소. localhost로 설정하면 현재 실행중인 컴퓨터에 데이터베이스 서버가 있다는 것을 의미
		// - "1521" : 데이터베이스 포트번호 의미. Oracle 데이터베이스는 기본적으로 1521 포트 사용
		// - "xe" : 데이터베이스 객체 이름 의미. Oracle 데이터베이스의 인스턴스 중 xe(Express Edition, 간편버전)을 의미.
		
//		2. 데이터베이스 연결객체 및 PreparedStatement 객체 선언
		// Connection 객체(데이터베이스 연결 객체)를 선언
		// - 연결이 성공적으로 수립될 경우, 이 객체를 통해 데이터베이스 작업 수행 가능
		Connection con = null;
		
		// PreparedStatement 객체(미리 컴파일된 SQL 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;
		
		// SQL 쿼리를 저장하는 문자열 변수
		String sql;
		
		// 사용자로부터 입력 받을 변경할 데이터를 저장하는 변수
		String name, email, tel;
		// 삭제할 회원의 회원번호를 저장하는 변수
		int ino;

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Delete 변경된 내용-------
//			4. 사용자 입력 처리(사용자로부터 삭제할 회원의 회원번호를 입력받음)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
			System.out.print("삭제할 회원의 회원번호를 입력하세요? ");
			ino = Integer.parseInt(br.readLine()); // 테이블에서 삭제할 name 필드 값을 입력 받음

//			5. SQL쿼리 생성 및 실행
			// DELETE 쿼리문을 작성
			sql = "DELETE FROM customer WHERE no = ?";
			// ?는 매개변수(파라미터)를 나타내며, 나중에 PreparedStatement 객체에서 실제 값을 설정할 때 사용
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// 첫 번째 매개변수 위치에 회원번호를 설정
			pstmt.setInt(1, ino);
			
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 쿼리를 실행하고 데이터베이스에 데이터를 삽입
			// * int executeUpdate 메서드: 쿼리를 실행하고, 영향을 받은 행의 수를 반환 
			int result = pstmt.executeUpdate();
			
//			6. 쿼리실행 결과 출력
			// 반환된 결과로 삭제된 레코드 수 확인
			if (result == 1) {
				System.out.println("회원 삭제 성공");
			} else {
				System.out.println("회원 삭제 실패");
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
//			7. 생성한 Statement와 Connection 객체를 닫아서 데이터베이스 연결을 종료(자원 해제)
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
