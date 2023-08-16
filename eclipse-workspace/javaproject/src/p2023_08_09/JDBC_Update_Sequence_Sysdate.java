package p2023_08_09;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/* 	Oracle 데이터베이스의 지정 테이블에서 레코드를 갱신(수정)하는 예제	
 * 	단, 직접 Timestamp객체를 생성하지 않고, 'sysdate'를 사용하여 시스템의 날짜와 시간 반환
 * * sysdate: Oracle 데이터베이스에서 사용되는 특별한 함수로, 현재 시스템의 날짜와 시간을 반환
	=> 현재 시스템의 날짜와 시간 정보를 가져오는 함수
	- 데이터베이스 서버의 현재 날짜와 시간을 사용하여 
	테이블의 날짜/시간 필드에 값을 삽입하거나 조회 가능
 */
class JDBC_Update_Sequence_Sysdate {
	
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

		// SQL문을 저장할 변수 선언
		String sql;
		// 수정할 번호를 입력받는 no변수 선언
		int no;
		// 수정된 값을 입력받을 변수 선언
		String name, email, tel, address;

		try {
//			3. 드라이버 로드 -> 데이터베이스 연결 -> SQL문 실헹할 Statement 객체 생성
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스를 로드)
			Class.forName(driver);
			
			// Connection 객체 생성
			// DriverManager 클래스의 getConnection()메소드를 사용하여 데이터베이스에 연결을 생성
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Insert 추가된 내용-------
//			4. 테이블에서 값을 변경할 내용을 콘솔창에서 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에 값 갱신하기 .....");
			System.out.println("번호를 입력 하세요?");
			no = Integer.parseInt(br.readLine());
			System.out.print("변경할 이름을 입력하세요: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print("변경할 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print("변경할 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음
			System.out.println("변경할 주소를 입력하세요?");
			address = br.readLine();
			
//			5. Timestamp 객체 생성
			// Timestamp ts 객체를 생성하여 현재 시간을 저장
//			Timestamp ts = new Timestamp(System.currentTimeMillis());

//			6. SQL 쿼리 작성 및 PreparedStatement 설정
			// sysdate를 사용해 가입날짜가 아닌 수정날짜로 변경
			sql = "UPDATE customer SET name=?, email = ?, tel = ?,";
			sql += " address=?, reg_date=sysdate where no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			// 직접 Timestamp객체를 생성하지 않고, 'sysdate'를 사용하여 시스템의 날짜와 시간 반환
//			pstmt.setTimestamp(5, ts);		// 직접 Timestamp객체 생성하는것
			pstmt.setInt(5, no);
			
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();

//			7. 결과 출력
			if (result == 1) {
				System.out.println(" 데이터 수정 성공!! ");
			} else {
				System.out.println(" 데이터 수정 실패 ");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
//			8. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
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
