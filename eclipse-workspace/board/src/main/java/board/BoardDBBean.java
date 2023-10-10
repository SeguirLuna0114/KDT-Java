// DAO(Data Access Object)클래스

package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	
	
	// 글 작성 메소드
	public int insert(BoardDataBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// insert SQL문 작성
			String sql = "insert into board ";
				   sql += " values (?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getNum());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getPasswd());
			pstmt.setInt(6, board.getReadcount());
			pstmt.setString(7, board.getContent());
			pstmt.setString(8, board.getIp());
			
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
	
	
	// 총 데이터 개수를 구해오는 메소드
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select count(*) from board";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);

			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			if(rs.next()) {
				// int getInt(int columnIndex) 메소드 사용하는 경우
//				result = rs.getInt(1);
				
				// int getInt(String columnLabel) 메소드를 사용하는 경우
				result = rs.getInt("count(*)");
			}
			
		} catch (Exception e) {
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
		// 총 데이터 개수 반환
		return result;
	}
	
	
	// 게시판 목록 구하기 - 게시판 목록(List)를 page_size크기(10)만큼 추출하는 메소드
	public List<BoardDataBean> getList(int startRow, int endRow) {
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 서브쿼리 select SQL문 작성
			String sql = "select * from ";
				   sql += " (select rownum rnum, board.* from ";
				   sql += " (select * from board order by num desc) board) ";
				   sql += " where rnum >= ? and rnum <= ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			while(rs.next()) {
				// DTO클래스 객체 생성
				BoardDataBean board = new BoardDataBean();
				
				// ResultSet객체에 반환된 필드값을 set메소드 호출을 통해 DTO객체에 저장
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getTimestamp("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				
				// DTO클래스 객체를 List에 추가
				list.add(board);
			}
			
		} catch (Exception e) {
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
	
	
	// 전체 글 목록(List) 구해오는 메소드
	public List<BoardDataBean> selectList() {
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
			String sql = "select * from board";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);

			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			while(rs.next()) {
				// DTO클래스 객체 생성
				BoardDataBean board = new BoardDataBean();
				
				// ResultSet객체에 반환된 필드값을 set메소드 호출을 통해 DTO객체에 저장
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setPasswd(rs.getString("passwd"));
				board.setReg_date(rs.getTimestamp("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				
				// DTO클래스 객체를 List에 추가
				list.add(board);
			}
			
		} catch (Exception e) {
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
	
	
	// 
	
}
