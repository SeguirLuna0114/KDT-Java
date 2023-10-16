// DAO(Data Access Object)클래스

package reboard;

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
	
	
	// 원문 글 작성(Insert)하는 메소드
	public int insert(BoardDataBean board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// insert SQL문 작성
			String sql = "insert into reboard ";
				   sql += " values(reboard_seq.nextval, ";
				   sql += " ?, ?, ?, ?, sysdate, ?, reboard_seq.nextval, ?, ?, ?, ?)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// num 멤버변수는 requence의 nextval을 이용해서 입력
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPasswd());
			// reg_date 멤버변수는 sysdate를 이용해 입력
			pstmt.setInt(5, 0);						// readcount
			// ref 멤버변수도 requence의 nextval을 이용해서 입력
			pstmt.setInt(6, 0);						// re_step
			pstmt.setInt(7, 0);						// re_level
			pstmt.setString(8, board.getContent());
			pstmt.setString(9, board.getIp());
			
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
	
	
	// 총 데이터 갯수(count(*)) 구하는 메소드
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 총 데이터 갯수를 구해오는 select SQL문 작성
			String sql = "select count(*) from reboard";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// select SQL문 실행 -> select된 데이터 개수를 반환
			rs = pstmt.executeQuery();
			
			// 가져올 데이터가 존재한다면, 결과값을 받아옴
			if(rs.next()) {
				/** getInt()메소드 사용하여 결과값을 받아옴
				 * 	1. getInt(int columnIndex)메소드 : 컬럼인덱스(1부터 시작)를 매개변수로 설정
				 * 	2. getInt(String columnLabel)메소드 : 컬럼명을 매개변수로 설정
				 * */
//				result = rs.getInt(1);
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
		
		// 구해온 데이터 갯수를 반환
		return result;
	}
	
	
	// 페이징 처리하여 데이터 목록 구하기 : 데이터 10개(블럭 크기만큼) 추출
	public List<BoardDataBean> getList(int startRow, int endRow) {
		// 구한 목록데이터를 반환할 List인터페이스 객체 생성
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 해당 구간의 데이터 목록를 구해오는 서브쿼리 select SQL문 작성
			/** ref컬럼을 기준으로 내림차순 정렬 
			 * 	& re_step(댓글 출력순서)컬럼을 기준으로 오름차순 정렬
			 *	-ref 컬럼: 게시물의 그룹을 나타냄 => 같은 그룹의 게시물은 ref 값이 같음
			 *			  내림차순으로 정렬하면 가장 최근에 작성된 게시물이 상단에 나타남
			 *	-re_step 컬럼: 게시물의 순서를 나타냄
			 *				  오름차순으로 정렬하여 먼저 작성된 댓글이 먼저 나타나게 함
			 *				  동일한 그룹 내에서 댓글의 출력 순서를 조절 오름차순으로 정렬 
			 *  */
			String sql = "select * from ";
				   sql += " (select rownum rnum, sub_board.* from ";
				   sql += " (select * from reboard order by ref desc, re_step asc) sub_board) ";
				   sql += " where rnum between ? and ?";
//				   sql += " where rnum >= ? and rnum <= ?";		// between을 사용하지 않을 경우
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// select SQL문 실행 -> select된 데이터 개수를 반환
			rs = pstmt.executeQuery();
			
			// 가져올 데이터가 존재한다면, 결과값을 1개씩 받아옴
			while(rs.next()) {
				// DTO클래스 타입으로 가져온 데이터를 List에 추가
				BoardDataBean board = new BoardDataBean();
				
				// getXxx메소드로 데이터를 가져와서 setXxx메소드로 설정
	   			board.setNum(rs.getInt("num"));
	   			board.setWriter(rs.getString("writer"));
	   			board.setEmail(rs.getString("email"));
	   			board.setSubject(rs.getString("subject"));
	   			board.setPasswd(rs.getString("passwd"));
	   			board.setReg_date(rs.getTimestamp("reg_date"));
	   			board.setReadcount(rs.getInt("readcount"));
	   			
	   			board.setRef(rs.getInt("ref"));
	   			board.setRe_step(rs.getInt("re_step"));
	   			board.setRe_level(rs.getInt("re_level"));
	   			
	   			board.setContent(rs.getString("content"));
	   			board.setIp(rs.getString("ip"));
	   			
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
		
		// 구한 데이터목록을 List타입으로 반환
		return list;
	}
	
	
	// 조회수 1 증가 & 상세정보를 구해오는 메소드
	public BoardDataBean updateContent(int num) {
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 1. 조회수를 1 증가시키는 update SQL문 작성
			sql = "update reboard set readcount = readcount+1 ";
			sql += " where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// update SQL문 실행
			pstmt.executeUpdate();
			
			
			// 2. 상세정보를 구해오는 select SQL문 작성
			sql = "select * from reboard where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// select SQL문 실행 -> select된 데이터 개수를 반환
			rs = pstmt.executeQuery();
			
			// 가져올 데이터가 존재한다면, 결과값을 1개씩 받아옴
			if(rs.next()) {
				// getXxx메소드로 데이터를 가져와서 setXxx메소드로 설정
	   			board.setNum(rs.getInt("num"));
	   			board.setWriter(rs.getString("writer"));
	   			board.setEmail(rs.getString("email"));
	   			board.setSubject(rs.getString("subject"));
	   			board.setPasswd(rs.getString("passwd"));
	   			board.setReg_date(rs.getTimestamp("reg_date"));
	   			board.setReadcount(rs.getInt("readcount"));
	   			
	   			board.setRef(rs.getInt("ref"));
	   			board.setRe_step(rs.getInt("re_step"));
	   			board.setRe_level(rs.getInt("re_level"));
	   			
	   			board.setContent(rs.getString("content"));
	   			board.setIp(rs.getString("ip"));
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
		
		// 상세정보를 저장한 DTO객체 반환
		return board;
	}
	
	
	// 댓글 작성 메소드
	public int reply(BoardDataBean board) {
		int result = 0;
		
		// 부모글에 대한 정보
		int ref = board.getRef();
		int re_level = board.getRe_level();
		int re_step = board.getRe_step();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			/** 1. 원문이 부모인 경우
			 * 		원문의 re_step=0이기 때문에, 모든 댓글들의 re_step값이 1씩 증가
			 *  2. 댓글이 부모인 경우
			 *  	부모의 re_step값보다 큰 댓글들만 re_step값이 1씩 증가됨
			 */
			// 1. re_step값을 1 증가시키는 update SQL문 작성(댓글 출력순서 조정)
			// 	- 부모글의 ref값과 같고, re_step값보다 큰 경우에 re_step값 1 증가시킴(답글 출력순서 1 증가)
			sql = "update reboard set re_step = re_step + 1 ";
			sql += " where ref = ? and re_step > ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			
			// update SQL문 실행
			pstmt.executeUpdate();
			
			
			// 2.insert SQL문 작성
			sql = "insert into reboard ";
			sql += " values(reboard_seq.nextval, ";
			sql += " ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?)";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			
			// num 멤버변수는 requence의 nextval을 이용해서 입력
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPasswd());
			// reg_date 멤버변수는 sysdate를 이용해 입력
			pstmt.setInt(5, 0);						// readcount(조회수값은 0 설정)
			pstmt.setInt(6, ref);					// ref(부모의 ref값을 설정)
			pstmt.setInt(7, re_step+1);				// re_step(부모의 re_step값보다 1 증가)
			pstmt.setInt(8, re_level+1);			// re_level(부모의 re_level값보다 1 증가)
			pstmt.setString(9, board.getContent());
			pstmt.setString(10, board.getIp());
			
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
		// 작성된 댓글 개수 반환
		return result;
	}
	
	
	// 수정 폼 : 데이터 1개의 상세정보를 추출해오는 메소드
	public BoardDataBean getContent(int num) {
		// 정보를 저장할 DTO클래스 객체 생성
		BoardDataBean board = new BoardDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			// 상세정보를 구해오는 select SQL문 작성
			sql = "select * from reboard where num = ?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// select SQL문 실행 -> select된 데이터 개수를 반환
			rs = pstmt.executeQuery();
			
			// 가져올 데이터가 존재한다면, 결과값을 1개씩 받아옴
			if(rs.next()) {
				// getXxx메소드로 데이터를 가져와서 setXxx메소드로 설정
	   			board.setNum(rs.getInt("num"));
	   			board.setWriter(rs.getString("writer"));
	   			board.setEmail(rs.getString("email"));
	   			board.setSubject(rs.getString("subject"));
	   			board.setPasswd(rs.getString("passwd"));
	   			board.setReg_date(rs.getTimestamp("reg_date"));
	   			board.setReadcount(rs.getInt("readcount"));
	   			
	   			board.setRef(rs.getInt("ref"));
	   			board.setRe_step(rs.getInt("re_step"));
	   			board.setRe_level(rs.getInt("re_level"));
	   			
	   			board.setContent(rs.getString("content"));
	   			board.setIp(rs.getString("ip"));
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
			String sql = "update reboard set writer=?, email=?, subject=?, ";
				   sql += " content=? where num=?";
			// PreparedStatement객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNum());
			
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
	
	
	// 글 삭제
	public int delete(BoardDataBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql="";
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드를 사용 */
			con = getConnection();
			
			/** 원문의 경우와 댓글의 경우 sql문이 다름
			 * 1. 원문(re_level=0)을 삭제하는 경우 - update문을 사용
			 * 		- 원본 게시물의 정보를 유지한 채로 실제 내용을 삭제하는 것이 아니라,
			 * 		  사용자에게 삭제되었음을 알림
			 * 2. 댓글을 삭제하는 경우 - delete문을 작성해서 삭제 실행	
			 * 		- 댓글은 다른 게시물의 하위에 속하는 글이며, 그 내용 자체가 삭제되어야함
			 * */
			if(board.getRe_level() == 0) {
				// 원문인 경우, 제목과 내용 값을 변경
				// update SQL문 작성
				sql = "update reboard set subject=?, content=? where num=?";
				// PreparedStatement객체 생성
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "관리자에 의해서 삭제됨");
				pstmt.setString(2, " ");
				pstmt.setInt(3, board.getNum());
				
			} else {
				// 댓글인 경우, 삭제 실행
				// delete SQL문 작성
				sql = "delete from reboard where num=?";
				// PreparedStatement객체 생성
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board.getNum());
			}
			
			// SQL문 실행 -> 결과 데이터 개수를 반환
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
