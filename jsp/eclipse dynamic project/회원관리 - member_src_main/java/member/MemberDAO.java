// DAO(Data Access Object)

package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	// 싱글톤 : 객체 생성을 1번만 수행한 후, 공유
	private static MemberDAO instance = new MemberDAO();
	
	// 정적 메소드 - 싱글톤으로 생성한 객체 반환
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 커넥션 풀에서 커넥션을 구해오는 메소드(외부 접근 불가하게 private접근제어자 사용)
	private Connection getConnection() throws Exception{
		// JNDI(Java Naming and Directory Interface) 컨텍스트를 초기화
		Context init = new InitialContext();
		// JNDI에서 등록한 데이터 소스에 대한 참조를 가져옴
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		// 데이터 소스로부터 데이터베이스 연결(Connection)을 가져와 반환
		return ds.getConnection();
	}
	
	
	// 회원가입 : 주소값 전달에 의한 메소드 호출 방식(Call by Reference 방식)
	public int insert(MemberDTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// insert SQL문 작성
			String sql = "insert into member ";
				   sql += " values (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, sysdate)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getJumin1());
			pstmt.setString(5, member.getJumin2());
			pstmt.setString(6, member.getMailid());
			pstmt.setString(7, member.getDomain());
			pstmt.setString(8, member.getTel1());
			pstmt.setString(9, member.getTel2());
			pstmt.setString(10, member.getTel3());
			pstmt.setString(11, member.getPhone1());
			pstmt.setString(12, member.getPhone2());
			pstmt.setString(13, member.getPhone3());
			pstmt.setString(14, member.getPost());
			pstmt.setString(15, member.getAddress());
			pstmt.setString(16, member.getGender());
			pstmt.setString(17, member.getHobby());
			pstmt.setString(18, member.getIntro());
			
			// insert SQL문 실행 -> insert된 데이터 개수를 반환
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
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

	
	
	// ID 중복검사 메소드
	public int memberAuth(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문으로 조회한 결과값을 받아올 ResultSet객체
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select * from member where id = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// select SQL문 실행 -> select된 데이터를 저장/받음
			rs = pstmt.executeQuery();
			// 받아온 데이터 유무 조회
			if (rs.next()) {
				// 값이 존재 = 중복 ID 존재O => 사용불가
				result = 1;
			} else {
				// 값이 존재하지 않는 경우 = 중복된 ID 없음 => 사용가능
				result = -1;
			}
			
		} catch (Exception e) {
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
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	// 로그인(회원 인증 처리) 메소드
	public int memberCheck(MemberDTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문으로 조회한 결과값을 받아올 ResultSet객체
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select * from member where id = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			
			// select SQL문 실행 -> select된 데이터를 저장/받음
			rs = pstmt.executeQuery();
			
			// 받아온 데이터(일치하는 id) 유무 조회
			if (rs.next()) {
				// id가 일치하는 경우
				
				// 입력된 비번과 DB에 저장된 비번 일치여부 확인
				if(rs.getString("passwd").equals(member.getPasswd())) {
					// id와 비번 모두 일치하는 경우 => 회원 인증 성공
					result = 1;
				} else {
					// 비번이 일치하지 않는 경우 = 회원 인증 실패
					result = -1;
				}
			} else {
				// id가 불일치하는 경우
				result = -2;
			}
			
		} catch (Exception e) {
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
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	// 한 사람의 상세정보를 구해오는 메소드
	public MemberDTO getMember(String id) {
		// 조회된 id에 따른 데이터를 담아 반환할 DTO객체 생성
		MemberDTO member = new MemberDTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문으로 조회한 결과값을 받아올 ResultSet객체
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select * from member where id = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// select SQL문 실행 -> select된 데이터를 저장/받음
			rs = pstmt.executeQuery();
			
			// select문을 만족하는 데이터를 1개 가져와 DTO클래스 객체에 입력
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setMailid(rs.getString("mailid"));
				member.setDomain(rs.getString("domain"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				member.setPost(rs.getString("post"));
				member.setAddress(rs.getString("address"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setIntro(rs.getString("intro"));
				member.setRegister(rs.getTimestamp("register"));
			}
			
		} catch (Exception e) {
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
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 조회된 id에 해당하는 데이터를 저장한 DTO 객체 반환
		return member;
	}
	
	
	// 회원정보 수정 메소드
	public int update(MemberDTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// update SQL문 작성
			String sql = "update member set name=?, jumin1=?, jumin2=?, mailid=?, ";
				   sql += " domain=?, tel1=?, tel2=?, tel3=?, phone1=?, phone2=?, phone3=?, ";
				   sql += " post=?, address=?, gender=?, hobby=?, intro=?, register=sysdate where id=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getJumin1());
			pstmt.setString(3, member.getJumin2());
			pstmt.setString(4, member.getMailid());
			pstmt.setString(5, member.getDomain());
			pstmt.setString(6, member.getTel1());
			pstmt.setString(7, member.getTel2());
			pstmt.setString(8, member.getTel3());
			pstmt.setString(9, member.getPhone1());
			pstmt.setString(10, member.getPhone2());
			pstmt.setString(11, member.getPhone3());
			pstmt.setString(12, member.getPost());
			pstmt.setString(13, member.getAddress());
			pstmt.setString(14, member.getGender());
			pstmt.setString(15, member.getHobby());
			pstmt.setString(16, member.getIntro());
			pstmt.setString(17, member.getId());
			
			// update SQL문 실행 -> update된 데이터 개수를 result객체에 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
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
		
		// update된 데이터 개수를 반환
		return result;
	}
	
	
	// 회원탈퇴메소드
	public int delete(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// delete SQL문 작성
			String sql = "delete from member where id=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// delete SQL문 실행 -> delete된 데이터 개수를 result객체에 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
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
}
