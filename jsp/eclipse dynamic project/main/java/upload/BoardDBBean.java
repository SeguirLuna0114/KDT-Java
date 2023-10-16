// DAO(Data Access Object)클래스

package upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDBBean {

	// 싱글톤 : 객체 생성을 1번만 수행한 후, 공유
	private static BoardDBBean instance = new BoardDBBean();

	// 정적 메소드 - 싱글톤으로 생성한 객체 반환
	public static BoardDBBean getInstance() {
		return instance;
	}

	// 커넥션 풀에서 커넥션을 구해오는 메소드(외부 접근 불가하게 private접근제어자 사용)
	private Connection getConnection() throws Exception {
		// JNDI(Java Naming and Directory Interface) 컨텍스트를 초기화
		Context init = new InitialContext();
		// JNDI에서 등록한 데이터 소스에 대한 참조를 가져옴
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		// 데이터 소스로부터 데이터베이스 연결(Connection)을 가져와 반환
		return ds.getConnection();
	}
	
	
	// 글 작성
	public int insert(BoardDataBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// insert SQL문 작성
			String sql = "insert into upload ";
				   sql += " values(upload_seq.nextval, ";
				   sql += " ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// num 멤버변수는 requence의 nextval을 이용해서 입력
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPasswd());
			// reg_date 멤버변수는 sysdate를 이용해 입력
			pstmt.setInt(5, board.getReadcount());	// readcount : 0
			pstmt.setString(6, board.getContent());
			pstmt.setString(7, board.getIp());
			pstmt.setString(8, board.getUpload());
			
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
		// insert 성공한 글 개수 반환
		return result;
	}
	
	
	// 총 데이터 갯수 구하는 메소드 - count(*)
	public int getCount() {
		// 총 데이터갯수를 받아올 변수
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select count(*) from upload";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// select SQL문 실행 -> select된 데이터를 rs객체에 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				/* 방법1) int getInt(int columnIndex) 메소드 사용 */
//				result = rs.getInt(1);
				/* 방법2) int getInt(String columnLabel) 메소드 사용 */
				result = rs.getInt("count(*)");
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
		// 구해온 총 데이터 갯수를 반환
		return result;
	}

	
	// 게시물 목록 : 데이터 10개 추출하는 메소드
	public List<BoardDataBean> getList(int startRow, int endRow) {
		// list 객체에 추가하여 값을 리턴
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 데이터 10개를 추출하는 서브쿼리 select SQL문 작성
			String sql = "select * from ";
				   sql += " (select rownum rnum, upload.* from ";
				   sql += " (select * from upload order by num desc) upload) ";
				   sql += " where rnum between ? and ?";
//				   sql += " where rnum >= ? and rnum <= ?";		// between 대신 연산자 활용하여 작성 가능
			
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// select SQL문 실행 -> select된 데이터를 rs객체에 반환
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// DTO클래스 객체 생성 -> list에 추가
				BoardDataBean board = new BoardDataBean();
				
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getTimestamp("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setUpload(rs.getString("upload"));
				
				list.add(board);
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
		
		return list;
	}
	
	
	
	// 상세 페이지 : 조회수 1 증가 & 상세정보 구하는 메소드
	public BoardDataBean updateContent(int num) {
		// 상세정보를 DTO객체에 저장해서 반환
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 1. update SQL문 작성
			String sql = "update upload set readcount = readcount + 1 ";
				   sql += " where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// update SQL문 실행
			pstmt.executeUpdate();
			
			
			// 2. 상세정보를 구해오는 select SQL문 작성
			sql = "select * from upload where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// select SQL문 실행 -> select된 데이터를 rs객체에 반환
			rs = pstmt.executeQuery();
			// 조건절을 만족하는 데이터 1개를 가져옴
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getTimestamp("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setUpload(rs.getString("upload"));
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
		return board;
	}
	
	
	// 수정 폼 : 상세정보를 구해오는 메소드
	public BoardDataBean getContent(int num) {
		// 상세정보를 DTO객체에 저장해서 반환
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 상세정보를 구해오는 select SQL문 작성
			String sql = "select * from upload where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// select SQL문 실행 -> select된 데이터를 rs객체에 반환
			rs = pstmt.executeQuery();
			// 조건절을 만족하는 데이터 1개를 가져옴
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getTimestamp("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setUpload(rs.getString("upload"));
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
		return board;
	}
	
	
	// 글 수정
	public int update(BoardDataBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// update SQL문 작성
			String sql = "update upload set writer=?, email=?, subject=?, ";
				   sql += " content=?, ip=?, upload=? where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getIp());
			pstmt.setString(6, board.getUpload());
			pstmt.setInt(7, board.getNum());	
			
			// update SQL문 실행 -> 수정된 데이터 개수를 반환
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
