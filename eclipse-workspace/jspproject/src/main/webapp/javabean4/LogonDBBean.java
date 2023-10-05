// DAO(Data Access Object)

package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LogonDBBean {
	
	// 싱글톤 : 객체 생성을 1번만 수행한 후, 공유
	private static LogonDBBean instance = new LogonDBBean();

	// 정적 메소드 - 싱글톤으로 생성한 객체 반환
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	// 회원가입 : 주소값 전달에 의한 메소드 호출 방식(Call by Reference 방식)
	public int insertMember(LogonDataBean member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		/**************** Oracle 연결 설정하는 부분 *****************************/
 		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/********************************************************************/
		
		try {
			// JDBC방식으로 DB접속
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// insert SQL문 작성
			String sql = "insert into member2 values (?, ?, ?, ?, ?, ?, ?, sysdate)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getJumin1());
			pstmt.setString(5, member.getJumin2());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getBlog());
			
			// insert SQL문 실행 -> insert된 데이터 개수를 반환
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			// 리소스 닫기
			try {
				// 초기값이 null이기에, null값이 아닌 경우 close
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// insert된 데이터 개수를 반환
		return result;
	}
	
	
	// 전체 회원목록(List) 구해오는 메소드
	public List<LogonDataBean> selectMember() {
		List<LogonDataBean> list = new ArrayList<LogonDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/**************** Oracle 연결 설정하는 부분 *****************************/
 		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/********************************************************************/
		
		try {
			// JDBC방식으로 DB접속
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// 테이블의 모든 데이터를 가져오는 select SQL문 작성
			String sql = "select * from member2";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			while(rs.next()) {
				// DTO클래스 객체 생성
				LogonDataBean member = new LogonDataBean();
//				member.id = "test";   // 접근안됨(private 접근 제어자)
				
				// ResultSet객체에 반환된 필드값을 set메소드 호출을 통해 DTO객체에 저장
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setEmail(rs.getString("email"));
				member.setBlog(rs.getString("blog"));
				member.setReg_date(rs.getDate("reg_date"));		// getDate()메소드 사용
				
				// DTO클래스 객체를 List에 추가
				list.add(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 닫기
			try {
				// 초기값이 null이기에, null값이 아닌 경우 close
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// DTO클래스 데이터타입의 list를 반환
		return list;
	}
	
	
	// 회원 수정폼 : 회원 1명 정보 구하기
	public LogonDataBean updateForm(String id) {
		// DTO클래스 객체 생성
		LogonDataBean member = new LogonDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/**************** Oracle 연결 설정하는 부분 *****************************/
 		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/********************************************************************/
		
		try {
			// JDBC방식으로 DB접속
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// 테이블에서 id에 해당하는 데이터를 가져오는 select SQL문 작성
			String sql = "select * from member2 where id = ?";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// Select SQL문 실행
			rs = pstmt.executeQuery();
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			while(rs.next()) {
				// ResultSet객체에 반환된 필드값을 set메소드 호출을 통해 DTO객체에 저장
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setEmail(rs.getString("email"));
				member.setBlog(rs.getString("blog"));
				member.setReg_date(rs.getDate("reg_date"));		// getDate()메소드 사용
			}
		
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			// 리소스 닫기
			try {
				// 초기값이 null이기에, null값이 아닌 경우 close
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// DTO클래스 데이터타입으로 반환
		return member;
	}
	
	
	// 회원정보 수정 메소드
	// 주소값 전달에 의한 메소드 호출 방식(Call by Reference 방식)
	public int update(LogonDataBean member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		/**************** Oracle 연결 설정하는 부분 *****************************/
 		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/********************************************************************/
		
		try {
			// JDBC방식으로 DB접속
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// 테이블에서 id에 해당하는 데이터를 가져오는 update SQL문 작성
			String sql = "update member2 set name=?, jumin1=?, jumin2=?,";
				   sql += "email=?, blog=?, reg_date=sysdate where id=?";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getJumin1());
			pstmt.setString(3, member.getJumin2());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getBlog());
			pstmt.setString(6, member.getId());
			
			// update SQL문 실행 -> 실행결과 변경된 데이터 (행)개수를 가져옴
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 닫기
			try {
				// 초기값이 null이기에, null값이 아닌 경우 close
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	// 회원정보 삭제
	public int delete(LogonDataBean member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		/**************** Oracle 연결 설정하는 부분 *****************************/
 		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/********************************************************************/
		
		try {
			// JDBC방식으로 DB접속
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			// 테이블에서 id에 해당하는 데이터를 삭제하는 delete SQL문 작성
			String sql="delete from member2 where id=?";
			
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			
			// delete SQL문 실행 -> 실행결과 삭제된 데이터 (행)개수를 가져옴
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 삭제된 데이터 (행)개수 반환
		return result;
	}
}
