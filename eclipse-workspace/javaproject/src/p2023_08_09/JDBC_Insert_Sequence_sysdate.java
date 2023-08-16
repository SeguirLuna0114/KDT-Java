package p2023_08_09;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/*	Oracle 데이터베이스에 새로운 레코드를 삽입하는 예제
	단, "시퀀스"를 사용하여 SQL 쿼리 작성
	
 * * 시퀀스: 데이터베이스에서 사용되는 객체로, 일련번호(Sequence Number)를 생성하는 데 사용
	- 고유한 값을 생성하는 데 사용되며, 자동으로 순차적으로 증가하는 값을 제공
		CREATE SEQUENCE customer_no_seq
    	START WITH 1		// 시작값이 1
    	INCREMENT BY 1		// 1씩 증가

	시퀀스(customer_no_seq)를 이용하여 no 필드에 고유한 번호를 생성
	첫번째 물음표(?)의 위치(no 필드 위치)에 시퀀스명.nextval 작성
	=> 시퀀스명.nextval: 시퀀스에서 다음 값을 가져오는 역할을 수행
		- 데이터베이스에서 새로운 레코드를 삽입할 때 고유한 값을 자동으로 생성하는 데 활용
			 	
 * * sysdate: Oracle 데이터베이스에서 사용되는 특별한 함수로, 현재 시스템의 날짜와 시간을 반환
	=> 현재 시스템의 날짜와 시간 정보를 가져오는 함수
	- 데이터베이스 서버의 현재 날짜와 시간을 사용하여 
	테이블의 날짜/시간 필드에 값을 삽입하거나 조회 가능
 */
class JDBC_Insert_Sequence_sysdate {
	public static void main(String[] args) {

//		1. 드라이버 로딩 및 연결설정
		// Oracle JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		// url은 데이터베이스 서버와 연결하고, 데이터베이스 객체에 접근하기 위한 정보 포함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

//		2. 데이터베이스 연결객체 및 PreparedStatement 객체 선언		
		// Connection 객체(데이터베이스 연결 객체)를 선언
		Connection con = null;
		// PreparedStatement 객체(미리 컴파일된 SQL 실행하기 위한 객체) 선언
		PreparedStatement pstmt = null;

//		ResultSet rs = null;
		// SQL문을 저장할 변수 선언
		String sql;

		// 입력값을 저장할 변수 선언
		String name, email, tel, no, address;

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Insert 추가된 내용-------
//			4. 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(" customer 테이블에 값 입력하기 .....");
//			System.out.print(" 번호 입력: ");		// 번호값은 시퀀스로 자동 입력
//			no = br.readLine().trim();
			System.out.print(" 이름 입력: ");
			name = br.readLine().trim(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print(" 이메일 입력: ");
			email = br.readLine().trim(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print(" 전화번호 입력: ");
			tel = br.readLine().trim(); // 테이블에 추가할 tel 필드 값을 입력 받음
			System.out.println("주소를 입력 하세요?");
			address = br.readLine().trim();
//			int ino = Integer.parseInt(no);

			// Timestamp 객체를 생성하여 현재 시간을 저장
//			Timestamp ts = new Timestamp(System.currentTimeMillis());

//			5. "시퀀스"를 사용하여 SQL 쿼리 작성 및 PreparedStatement 설정
			// INSERT 쿼리문을 작성
			sql = "INSERT into customer (no, name, email, tel, address, reg_date)";
			/* 	시퀀스: 데이터베이스에서 사용되는 객체로, 일련번호(Sequence Number)를 생성하는 데 사용
			 	- 고유한 값을 생성하는 데 사용되며, 자동으로 순차적으로 증가하는 값을 제공
			 	CREATE SEQUENCE customer_no_seq
    				START WITH 1		// 시작값이 1
    				INCREMENT BY 1		// 1씩 증가

			 * 	시퀀스(customer_no_seq)를 이용하여 no 필드에 고유한 번호를 생성
			 	첫번째 물음표(?)의 위치(no 필드 위치)에 시퀀스명.nextval 작성
			 	=> customer_no_seq.nextval: 시퀀스에서 다음 값을 가져오는 역할을 수행
			 	
			 *	sysdate: Oracle 데이터베이스에서 사용되는 특별한 함수로, 현재 시스템의 날짜와 시간을 반환
			 	=> 현재 시스템의 날짜와 시간 정보를 가져오는 함수
			 	- 데이터베이스 서버의 현재 날짜와 시간을 사용하여 
			 	  테이블의 날짜/시간 필드에 값을 삽입하거나 조회 가능
			*/
			sql += " values (customer_no_seq.nextval, ?, ?, ?,?,sysdate)";		// values 앞에 간격을 벌려줘야 함(형식상 오류 발생)
			
//			6. PreparedStatement 객체 생성하여 쿼리 실행
			// PreparedStatement 객체를 생성하여 작성한 쿼리를 실행할 준비
			pstmt = con.prepareStatement(sql);
			
			// pstmt의 setXxx()메소드로 데이터 바인딩
			// 시퀀스명.nextval 로 다음값을 가져와서 사용X
//			pstmt.setInt(1, customer_no_seq.nextval);	// 오류발생
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			
			// 직접 Timestamp객체를 생성하지 않고, 'sysdate'를 사용하여 시스템의 날짜와 시간 반환
//			pstmt.setTimestamp(5, ts);		// 직접 Timestamp객체 생성하는것
			
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
//			7. 결과 출력
			if (result == 1) {
				System.out.println(" Data insert success!! ");
			} else {
				System.out.println(" Data insert failed ");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			
		} finally {
//			8. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
			try {
//				if( rs != null )   rs.close();        
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
