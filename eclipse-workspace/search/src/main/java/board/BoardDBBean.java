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
				   sql += " values (board_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			// num멤버변수를 sequence의 nextval로 설정
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPasswd());
			pstmt.setInt(5, board.getReadcount());		// 0
			pstmt.setString(6, board.getContent());
			pstmt.setString(7, board.getIp());
			
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
	
	
	// 총 데이터 개수를 구해오는 메소드 or 검색어를 포함한 데이터의 개수를 구해오는 메소드
	public int getCount(String sel, String find) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		// 작성할 sql문
		String sql = "";
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// select SQL문 작성
//				데이터 개수를 구해오는 sql문
			sql = "select count(*) from board";
			
			if(sel != null && find != null) {
//				검색항목(sel)이 검색어(find)를 포함한 데이터의 개수를 %와일드카드를 사용해 구해오는 sql문
				sql += " where "+sel+" like '%"+find+"%' ";
			}
			
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
		// select된 데이터 개수 반환
		return result;
	}
	
	
	
	/* 게시판 목록 구하기 - 게시판 목록(List)를 page_size크기(10)만큼 추출하는 메소드
	 * - 매개변수 중 sel변수와 find변수가 전달되지 않는 경우, 전체 게시판 목록을 구함
	 * - 매개변수 sel변수와 find변수가 전달되면, 검색된 게시판 목록만 구함
	*/
	public List<BoardDataBean> getList(int startRow, int endRow, String sel, String find) {
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		// sql문
		String sql = "";
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 서브쿼리 select SQL문 작성
			if(sel != null && find != null) {
//				검색항목(sel)이 검색어(find)를 사용해, 검색된 게시판 목록을 구해오는 sql문
				sql = "select * from ";
				sql += " (select rownum rnum, board.* from ";
				sql += " (select * from board where "+sel+" like '%"+find+"%' ";
				sql += " order by num desc) board) ";
				sql += " where rnum >= ? and rnum <= ?";
			
			} else {
//				전체 게시판 목록를 구해오는 sql문
				sql = "select * from ";
				sql += " (select rownum rnum, board.* from ";
				sql += " (select * from board order by num desc) board) ";
				sql += " where rnum >= ? and rnum <= ?";
			}
			
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
	
	
	// 해당 상세페이지로 이동시, 조회수를 1 증가시키고 & 상세정보를 구하는 메소드
	public BoardDataBean updateContent(int num) {
		// 검색한 1개의 결과를 DTO객체에 저장한 후, 반환
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 1. 조회수를 1 증가시키는 update SQL문 작성
			String sql = "update board set readcount=readcount+1 ";
				   sql += " where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// update SQL문 실행
			pstmt.executeUpdate();
			
			// 2. 1개의 글의 상세정보를 구하는 select SQL문 작성
			sql = "select * from board where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			if(rs.next()) {
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
		
		// 조회수를 1 증가시키고 & 상세정보를 구한 DTO객체 반환
		return board;
	}
	
	
	// 수정폼 : 상세 정보를 구해오는 메소드
	public BoardDataBean getContent(int num) {
		// 검색한 1개의 결과를 DTO객체에 저장한 후, 반환
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// select문 실행해 가져온 결과를 저장
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 1개의 글의 상세정보를 구하는 select SQL문 작성
			String sql = "select * from board where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			// select SQL문 실행 -> 쿼리실행결과를 resultSet객체에 반환
			rs = pstmt.executeQuery();
			
			// 데이터를 1개씩 가져오는 next()메소드 사용 -> 데이터를 가져오면 true 리턴
			if(rs.next()) {
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
		
		// 상세정보를 구한 DTO객체 반환
		return board;
	}
	
	
	// 글 수정 메소드
	public int update(BoardDataBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// update SQL문 작성
			String sql = "update board set writer=?, email=?, subject=?,";
				   sql += " content=? where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNum());
			
			// update SQL문 실행 -> update된 데이터 개수를 반환
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
		
		// 수정된 데이터 개수를 반환
		return result;
	}
	
	
	// 글 삭제 메소드
	public int delete(int num) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// delete SQL문 작성
			String sql = "delete from board where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// delete SQL문 실행 -> delete된 데이터 개수를 반환
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
		
		// 삭제된 데이터 개수 반환
		return result;
	}
}
