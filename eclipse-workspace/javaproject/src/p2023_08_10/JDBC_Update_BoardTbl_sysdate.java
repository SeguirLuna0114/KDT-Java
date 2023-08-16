package p2023_08_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_Update_BoardTbl_sysdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1. 드라이버 로딩 및 연결설정
		// Oracle JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		// url - Connection객체 생성시, 사용하며 객체에 접근하기 위한정보 포함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
//		2. 데이터베이스 연결 객체 및 PreparedStatement객체 선언
		// Connection객체 선언 - 데이터베이스 연결 객체
		Connection con = null;
		// PreparedStatement 객체 선언 - 미리 컴파일된 SQL문 실행하기위한 객체
		PreparedStatement pstmt = null;
		
		// SQL문을 저장하기 위한 변수
		String sql;
		
		// 입력받은 값들 할당할 변수 선언
		int no;
		String writer, passwd, subject, content;
		// sysdate로 수정된 시간을 입력해서 reg_date컬럼에 작성할 것
		
		try {
//			3. 드라이버 로드 -> 데이터베이스 연결
			// JDBC Driver Loading(문자열로 표시된 드라이버 클래스 로드)
			Class.forName(driver);
			
			// Connection 객체 생성
			// DriverManager클래스의 getConnection()메소드를 사용해 데이터베이스에 연결
			con = DriverManager.getConnection(url, "scott", "tiger");
			
//			4. 테이블에서 값을 변경할 내용을 콘솔창에서 입력받음
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" board 테이블에 값 갱신하기 .....");
			System.out.println("번호를 입력 하세요?");
			no = Integer.parseInt(br.readLine());
			System.out.print("변경할 작성자를 입력하세요: ");
			writer = br.readLine();
			System.out.print("변경할 비밀번호 입력: ");
			passwd = br.readLine();
			System.out.print("변경할 제목 입력: ");
			subject = br.readLine(); 
			System.out.println("변경할 내용을 입력하세요?");
			content = br.readLine();
			// sysdate로 ts객체에 시간 입력할 것
			
//			5. SQL쿼리 생성 및 PreparedStatement 설정
			// sysdate를 사용해 가입날짜가 아닌 수정날짜로 변경
			// Update쿼리 작성
			sql = "UPDATE board SET writer=?, passwd=?, subject=?, content=?";
			sql += ", reg_date=sysdate where no = ?";
			
			// prepareStatement객체를 생성해 sql문 실행 준비
			pstmt = con.prepareStatement(sql);
			
			// prepareStatement.set(int idx, String Col)메소드로
			// 데이터 바인딩
			pstmt.setString(1, writer);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			// 직접 Timestamp객체를 생성하지 않고, sysdate를 사용해 쿼리문에 직접 작성 => 시스템의 날짜와 시간 반환
			pstmt.setInt(5, no);
			
//			6. 쿼리 실행 및 결과 출력
			// executeUpdate() 메서드는 쿼리를 실행하고 영향을 받은 행의 수를 반환
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("글 수정 성공!!");
			} else {
				System.out.println("글 수정 실패....");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
			
		} finally {
//			7. 생성한 prepareStatement, Connection 객체를 닫아서 데이터베이스 연결을 종료
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
