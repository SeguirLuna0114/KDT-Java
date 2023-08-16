package p2023_08_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/* JDBC(Java Database Connectivity)를 사용하여
 * 데이터베이스에 연결하고, 회원 수를 조회하여 출력하고, 회원 정보를 조회하여 출력
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
		
 * * ResultSet 인터페이스
 	: 데이터베이스로부터 쿼리 실행 결과를 포함하는 테이블 형태의 데이터
 	- ResultSet 객체를 통해 데이터베이스에서 검색된 결과 집합에 접근하고 조작 가능
 	- 데이터베이스에서 가져온 결과를 가리키는 커서(Cursor)와 같은 역할
 	* 객체생성 방법 : Statement 객체의 executeQuery() 메서드를 통해 생성됨
 		- executeQuery() 메서드: SELECT 쿼리를 실행하고 그 결과를 ResultSet 객체로 반환
 	  	ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
 	* 쿼리 실행 : PreparedStatement 객체의 executeQuery() 메서드(조회용 쿼리) 호출하여 쿼리 실행
 					ex) ResultSet rs = pstmt.executeQuery(); // 조회용 쿼리 실행
 	* 			또는 executeUpdate() 메서드(수정, 삭제, 삽입용 쿼리)를 호출하여 쿼리를 실행
 	* 				ex)	int rowsAffected = psmt.executeUpdate(); // 수정, 삭제, 삽입용 쿼리 실행
 	
 	* 주요 메소드
 		- boolean next()메소드: 결과 집합의 다음 행으로 이동하며, 이동할 행이 존재하면 true, 없으면 false를 반환
 			1) next() 메서드가 호출되면, 현재 레코드 위치가 결과 집합의 첫 번째 레코드로 이동
			2) next() 메서드를 호출하면 현재 레코드에서 다음 레코드로 이동
			   다음 레코드가 없으면(결과 집합의 끝에 도달했을 경우) false를 반환
			3) next() 메서드를 통해 현재 레코드로 이동한 후, 각 컬럼에 접근하여 필드 값을 읽어옴
			4) next() 메서드를 여러 번 호출하여 결과 집합의 모든 레코드를 순회
 		
 		- COUNT(*) : SQL 집계 함수 중 하나로, 특정 테이블이나 검색 결과의 레코드 수를 계산하는 데 사용
 					- 결과 집합에 항상 하나의 레코드를 반환(하나의 레코드에 단일 값을 저장하는 방식으로 동작)
 					  => getInt(1)과 같은 메서드를 사용하여 결과 값을 얻어옴
 					  
 		- getInt(String columnLabel) 메소드: ResultSet에서 해당 열로부터 가져온 값이 "정수"일 때 사용하여 해당 값을 가져옴
 		- getString(String columnLabel) 메소드: ResultSet에서 해당 열로부터 가져온 값이 "문자열"일 때 사용하여 해당 값을 가져옴
 */
class JDBC_Select_prepareStatement_OrderBy_count {
	
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

		// ---JDBC_Select 추가된 내용 -------
		// ResultSet 객체 선언
		// -  SELECT 쿼리를 실행한 후 데이터베이스에서 레코드를 가져오기 위함
		ResultSet rs = null;
		// 회원 수를 조회하기 위한 ResultSet 객체를 선언
		// - 회원 수를 조회하는 SQL 쿼리를 작성하고 실행한 후 결과를 rs01에 저장
		ResultSet rs01 = null;
		
		int no = 0;
		String name, email, tel; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언
		
		int cnt = 0; // 회원수 저장

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

//			4. ResultSet객체를 이용하여 전체 회원의 수를 조회하고 출력
			// 회원 수를 조회하는 SQL 쿼리를 작성
			// count(*) : 총 데이터 갯수를 구해주는 함수
			String sql01 = "select count(*) from customer";
			
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql01);
			
			// executeQuery() 메서드를 호출하여 생성한 SQL 쿼리를 실행하고
			// 결과를 ResultSet 객체인 rs01에 저장
			rs01 = pstmt.executeQuery();
			
			// * boolean next()메소드: 레코드(행)을 한 줄씩 순회하면서 다음 레코드로 이동하는 역할을 수행
			if (rs01.next()) {	// count(*)SQL 집계 함수의 결과는 단일값 => while문 대신 if문 사용 가능
				// 첫 번째 컬럼의 값(총 회원수)을 정수로 가져와서 변수 cnt에 저장
				cnt = rs01.getInt(1);
//				cnt = rs01.getInt("count(*)");
			}
			System.out.println("총회원수:" + cnt);

			// ---JDBC_Select 추가된 내용 -------
//			5. 쿼리를 실행하여 결과를 ResultSet 객체에 저장
			// 모든 회원 정보를 조회하는 SQL 쿼리를 작성. 결과는 no 필드의 오름차순으로 정렬
			sql = "SELECT * FROM customer ORDER BY no asc";		// asc(오름차순), desc(내림차순)
			
			System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
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
				
				// 가져온 각 필드 값을 형식에 맞게 출력
				System.out.printf(" %d \t %s \t\t %s \\t\\t %s \n", no, name, email, tel);
			}
			
		} catch (Exception e) {
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
