package p2023_08_08;

import java.sql.*;
/* JDBC를 통해 데이터베이스와 상호작용(Select)
 * "customer" 테이블의 데이터를 조회하여 
 * 번호, 이름, 이메일, 전화번호를 출력하는 예제
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
		
 * * ResultSet 인터페이스
 	: 데이터베이스로부터 쿼리 실행 결과를 포함하는 테이블 형태의 데이터
 	- ResultSet 객체를 통해 데이터베이스에서 검색된 결과 집합에 접근하고 조작 가능
 	- 데이터베이스에서 가져온 결과를 가리키는 커서(Cursor)와 같은 역할
 	* 객체생성 방법 : Statement 객체의 executeQuery() 메서드를 통해 생성됨
 		- executeQuery() 메서드: SELECT 쿼리를 실행하고 그 결과를 ResultSet 객체로 반환
 	  	ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
 	
 	* 주요 메소드
 		- boolean next()메소드: 결과 집합의 다음 행으로 이동하며, 이동할 행이 존재하면 true, 없으면 false를 반환
 		- getInt(String columnLabel) 메소드: 현재 행에서 지정된 열(column)의 데이터를 가져옴
 */
class JDBC_Select_Statement_ResultSet {
	
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
		
		// ---JDBC_Select 추가된 내용 -------
		ResultSet rs = null;
		int no = 0;
		String name, email, tel; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			// 지정된 URL, 사용자 이름("scott"), 비밀번호("tiger")로 데이터베이스에 연결
			con = DriverManager.getConnection(url, "scott", "tiger");
//			System.out.println(con);
			
			
			// Connection 객체의 createStatement() 메서드를 사용하여 Statement 객체를 생성
			// createStatement() 메서드: 데이터베이스와 상호작용하여 SQL 문을 실행하기 위한 Statement 객체를 생성
			// Statement 객체는 SQL 문을 실행하는 데 사용. 데이터베이스와의 상호작용을 위한 인터페이스 역할
			stmt = con.createStatement();
//			System.out.println(stmt);
			
			
			// ---JDBC_Select 추가된 내용 -------
//			4. ResultSet 객체를 생성하고 SELECT 쿼리문 실행
			//  "customer" 테이블에서 모든 열과 행을 선택하는 SELECT 쿼리문을 생성
			sql = "SELECT * FROM customer";
			// sql 자체는 대소문자 구분X
			
			System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
			System.out.printf("-----------------------------------------------------------------\n");
			
			// 생성한 쿼리문을 실행하고 결과를 ResultSet 객체에 저장
			// - ResultSet은 쿼리 실행 결과를 포함하는 테이블 형태의 데이터
			rs = stmt.executeQuery(sql); // 얻어진 레코드를 가져옴

//			5. 결과 출력
			// ResultSet 객체에 있는 각 행을 반복하면서 각 필드의 값을 가져와 출력
			// boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
				System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email, tel);
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			6. 생성한 ResultSet, Statement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {// rs, stmt, con 객체를 close() 메서드를 호출해 해제
				if (rs != null)
					rs.close();
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
