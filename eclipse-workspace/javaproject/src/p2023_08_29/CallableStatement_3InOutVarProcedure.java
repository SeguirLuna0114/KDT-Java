package p2023_08_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Oracle 데이터베이스에 연결하고, 
 * SQL DEVELOPER에서 생성한 매개변수의 MODE가 in, out으로 되어있는 저장 프로시저를 호출하여 실행
 * 
 * - JDBC(Java Database Connectivity)를 이용하여 Oracle 데이터베이스에 연결
 * - CallableStatement 클래스를 사용하여 저장 프로시저를 호출하고 실행
 */
class CallableStatement_3InOutVarProcedure {
	public static void main(String[] args) {
		// 데이터베이스 연결을 위한 Connection 객체를 초기화
		Connection con = null;
		// 데이터베이스 URL을 설정
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 호출할 저장 프로시저의 SQL 문을 저장할 변수를 선언
		String sql = null;
		
		// name 매개변수 값을 고정값으로 사용하는 경우
//		String name = "홍길동";
		
		// 저장 프로시저 호출을 위한 CallableStatement 객체를 초기화
		CallableStatement cs = null;
		
		// 입력받은 값을 매개변수로 프로시저에 전달
		System.out.println("고객 이름을 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name;

		try {
			// 입력받은 조회할 고객 명
			name = br.readLine();
			
			// Oracle JDBC 드라이버를 로드 => 오라클 데이터베이스와 통신 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스에 연결
			con = DriverManager.getConnection(url, "scott", "tiger");

			// 호출할 저장 프로시저의 SQL 문
			sql = "{call sel_customer(?,?,?)}";

			// CallableStatement를 객체를 생성 & 생성한 객체에 호출할 SQL 문을 설정
			cs = con.prepareCall(sql);
			
			/** 프로시저 매개변수가 있는 경우,
			 *  CallableStatement의 setXxx(parameterIndex, value) 메서드를 사용하여 값을 설정
			 *  - parameterIndex를 프로시저의 매개변수 목록에서 매개변수의 인덱스로 대체하고, 
			 *  - value에 전달할 실제 값을 입력
			 */
			// setString 메소드를 사용하여 첫 번째 매개변수에 회원명 값을 설정
			cs.setString(1, name);
			
			/**
			 * void registerOutParameter(int parameterIndex, int sqlType) 메소드
			 * :  저장 프로시저의 출력 매개변수를 등록하는 역할
			 * - 출력 매개변수의 데이터 타입을 지정하고, 저장 프로시저 실행 후 그 값을 얻어올 수 있게 함
			 * => 프로시저 실행 후에 각 출력 매개변수의 값을 
			 * 	  getXxx(int parameterIndex) 메소드를 사용하여 가져올 수 있음
			 * 
			 * - java.sql.Types.Xxx
			 *  : JDBC (Java Database Connectivity)를 통해 데이터베이스와 상호 작용할 때 
			 *    사용되는 데이터 타입을 나타내는 상수
			 *    Java의 데이터 타입과 일치하지 않을 수 있기에, 이를 매핑해주는 역할 수행
			 */
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			// 두 번째 매개변수를 문자열(VARCHAR) 타입으로 설정 => String으로 얻을 수 있음
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			// 세 번째 매개변수를 문자열(VARCHAR) 타입으로 설정 => String으로 얻을 수 있음

			// CallableStatement 객체를 사용하여 저장 프로시저를 실행
			cs.execute();	// execute() 메서드를 호출하면 저장 프로시저가 실행되고 결과가 처리됨
			
			/** void getXxx(int parameterIndex) 메소드
			 * : CallableStatement 객체에서 지정된 인덱스의 출력 매개변수 값을 
			 * 	 지정한 데이터타입으로 가져오기위해 사용
			 * 	- parameterIndex는 출력 매개변수의 순서를 나타내는 정수 값(1부터 시작)
			 */
			System.out.println("이름 \t 이메일 \t\t 전화번호   ");
			System.out.println("-----------------------------------------------");
			System.out.println(name + " \t " + cs.getString(2) + " \t " + cs.getString(3));

			// 사용이 끝난 CallableStatement 객체와 데이터베이스 연결을 닫음
			cs.close();
			con.close();
			
		} catch (Exception e) {
			// 예외가 발생하면 해당 예외를 처리하여 출력
			System.out.println("고객 정보가 없습니다.");	// 고객정보가 없는 경우
//			System.out.println(e);
		}
	}
}
