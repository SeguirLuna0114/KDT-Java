package p2023_08_08;

import java.sql.*;
import java.io.*; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 

/* JDBC(Java Database Connectivity)를 사용하여
 * Oracle 데이터베이스에 데이터를 추가(Insert)
 * 
 * BufferedReader를 통해 사용자의 입력을 받고, 
 * 생성한 SQL 쿼리를 실행하여 데이터베이스에 새로운 행을 추가
 * 
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
class JDBC_Insert_Statement {
	
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
		// - 연결이 성공적으로 수립될 경우, 이 객체를 통해 데이터베이스 작업 수행 가능
		Connection con = null;
		
		// Statement 객체(sql문을 실행하기 위한 객체)를 선언
		Statement stmt = null;

//		ResultSet rs = null;
		String sql;
		String name, email, tel, no;

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

			// ---JDBC_Insert 추가된 내용-------
//			4. 사용자 입력 받기-사용자로부터 번호, 이름, 이메일, 전화번호를 입력 받음
			// 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(" customer 테이블에 값 입력하기 .....");
			System.out.print(" 번호 입력: ");
			no = br.readLine();		// primary key이기에 중복값X
			System.out.print(" 이름 입력: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print(" 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print(" 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음

//			5. INSERT 쿼리문 작성 및 실행
			// 입력 받은 값을 사용하여 INSERT 쿼리문을 생성
			sql = "INSERT into customer(no, name, email, tel) values ";
			sql += "(" + no + ",'" + name + "','" + email + "','" + tel + "')";
			// ': 작은 따옴표(싱글 쿼트)는 문자열을 나타내는 데 사용
			//		- 큰 따옴표 내에 있는 '는 문자열 내에서 따옴표로 해석
			// ": 큰 따옴표(더블 쿼트)는 SQL 문 내에서는 문자열을 감싸는 데 사용
			// 		- 작은 따옴표 내에 있는 " "는 문자열 내에서 큰 따옴표로 해석
			
			
			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			// 생성한 쿼리문을 실행하여 데이터베이스에 새로운 값을 추가
			// * executeUpdate 메서드: 영향을 받은 행의 수를 반환
			int res = stmt.executeUpdate(sql); // 데이터베이스 파일에 새로운 값을 추가시킴
			if (res == 1) {
				System.out.println(" Data insert success!! ");
			} else {
				System.out.println(" Data insert failed ");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
			// 6. 생성한 Statement와 Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
				// if( rs != null ) rs.close();
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
