package p2023_08_08;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * JDBC(Java Database Connectivity)를 사용하여
 * 사용자가 입력한 정보를 바탕으로 Oracle 데이터베이스 내의 특정 테이블에서 레코드(행) 삭제

 * * Connection 객체(데이터베이스 연결 객체)
 	- 연결이 성공적으로 수립될 경우, 이 객체를 통해 데이터베이스 작업 수행 가능
 	- DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
 		con = DriverManager.(String url, String user, String password);
			- 지정된 url, 사용자 이름("user"), 비밀번호("password")로 데이터베이스에 연결
 * * Statement 객체(sql문을 실행하기 위한 객체)
 	- Connection 객체의 createStatement() 메서드를 사용하여 Statement 객체를 생성
	- createStatement() 메서드: 데이터베이스와 상호작용하여 SQL 문을 실행하기 위한 Statement 객체를 생성
	- Statement 객체는 SQL 문을 실행하는 데 사용. 데이터베이스와의 상호작용을 위한 인터페이스 역할
		stmt = con.createStatement();		
		
 *	작은따옴표(') 큰따옴표(")
 	': 작은 따옴표(싱글 쿼트)는 문자열을 나타내는 데 사용
		- 큰 따옴표 내에 있는 '는 문자열 안에서 문자열 값을 감싸는 데 사용
	": 큰 따옴표(더블 쿼트)는 SQL 문 내에서는 문자열 뿐만 아니라 변수명, 문장 등을 표현하는 데에도 사용될
		- 작은 따옴표 내에 있는 " "는 문자열 내에서 큰 따옴표로 해석 
 */
class JDBC_Delete_Statement {
	
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

//		2. 데이터베이스 연결객체 및 Statement 객체 선언
		// Connection 객체(데이터베이스 연결 객체)를 선언
		Connection con = null;
		// Statement 객체(sql문을 실행하기 위한 객체)를 선언
		Statement stmt = null;
		
		// SQL문을 저장할 변수 선언
		String sql;
		// 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		int no;
		String name, email, tel;

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			// 지정된 URL, 사용자 이름("scott"), 비밀번호("tiger")로 데이터베이스에 연결
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// Connection 객체의 createStatement() 메서드를 사용하여 Statement 객체를 생성
			// createStatement() 메서드: 데이터베이스와 상호작용하여 SQL 문을 실행하기 위한 Statement 객체를 생성
			// Statement 객체는 SQL 문을 실행하는 데 사용. 데이터베이스와의 상호작용을 위한 인터페이스 역할
			stmt = con.createStatement();

			// ---JDBC_Delete 변경된 내용-------
//			4. 사용자 입력 처리(사용자로부터 삭제할 레코드의 회원번호를 입력받음)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
			System.out.print("삭제할 회원번호를 입력하세요: ");
//			no = Integer.parseInt(br.readLine()); // 테이블에서 삭제할 name 필드 값을 입력 받음
			String n = br.readLine();
			
//			5. SQL쿼리 생성 및 실행
			// DELETE 쿼리문을 작성
//			sql = "DELETE FROM customer WHERE no =" + no;	// no를 숫자로 처리한 경우
			// 변수명 좌우에 외따옴표(')를 사용 & 문자열 좌우에 쌍따옴표(")
			// n변수 양쪽에 외따옴표(')가 없기에, 숫자로 처리됨
			sql = "DELETE FROM customer WHERE no =" + n;	// no를 문자로 처리한 경우
			// DELETE FROM customer WHERE no = 123;와 같은 형태
			
			
//			6. 생성한 쿼리문을 사용하여 데이터베이스 내용을 삭제
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 생성한 쿼리문을 실행하여 데이터베이스 파일에서 레코드 삭제시킴
			int result = stmt.executeUpdate(sql); 
			// * executeUpdate 메서드: 영향을 받아 업데이트 된 행(레코드)의 수를 반환
			
			// 처리결과 출력
			if (result == 1) {
				System.out.println("회원삭제 성공");
			} else {
				System.out.println("회원삭제 실패");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			7. 생성한 Statement와 Connection 객체를 닫아서 데이터베이스 연결을 종료(자원 해제)
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
