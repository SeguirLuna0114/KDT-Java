// DAO(Data Access Object)

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BoardBean;

public class BoardDAO {
	
	// 싱글톤 : 객체 생성을 한번만 수행
	private static BoardDAO instance = new BoardDAO();
	
	// 싱글톤 객체 호출 메소드
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 커넥션풀에서 커넥션을 구해오는 메소드
	private Connection getConnection() throws Exception {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	
	// 글 작성 : 원문작성
	public int insert(BoardBean board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드 호출 */
			con = getConnection();
			
			// insert SQL문 작성 - 시퀀스의 nextval을 사용하여 insert
			String sql = "insert into model2board values (model2board_seq.nextval, ";
				   sql += " ?, ?, ?, ?, ?, model2board_seq.nextval, ?, ?, ?, sysdate)";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, board.getBoard_file());
			// board_re_ref 필드는 시퀀스를 활용하여 작성
			pstmt.setInt(6, 0);		// board_re_lev
			pstmt.setInt(7, 0);		// board_re_seq
			pstmt.setInt(8, 0);	// board_readcount
			// sysdate로 작성
			
			// insert SQL문 실행
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	
	// 총 데이터 갯수 구하는 메소드
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드 호출 */
			con = getConnection();
			
			// 총 데이터 갯수를 구해오는 select SQL문 작성
			String sql = "select count(*) from model2board";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			
			// select SQL문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				/** 방법
				 * 1. int getInt(int columnIndex)
				 * 2. int getInt(String columnLabel)
				 */
//				result = rs.getInt(1); 
				result = rs.getInt("count(*)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	

	// 글 목록 : 데이터 목록 10개 구해오는 메소드 
	public List<BoardBean> getList(int startRow, int endRow) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드 호출 */
			con = getConnection();
			
			// 글 목록을 구해오는 서브쿼리 select SQL문 작성
			String sql = "select * from ( ";
				   	sql += " select rownum rnum, board.* ";
				   	sql += " from (select * from model2board ";
				   		sql += "	order by board_re_ref desc, board_re_seq asc) board ";
				   sql += " ) where rnum >= ? and rnum <= ?";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// select SQL문 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
	// 조회수 1 증가시키는 메소드
	public void readcountUpdate(int board_num) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드 호출 */
			con = getConnection();
			
			// 조회수 1 증가시키는 update SQL문 작성
			String sql = "update model2board set board_readcount = board_readcount + 1 ";
				   sql += " where board_num = ?";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			// update SQL문 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
	// 상세페이지 : 해당 글의 상세정보를 구해오는 메소드
	public BoardBean getDetail(int board_num) {
		// TODO Auto-generated method stub
		BoardBean board = new BoardBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/* 커넥션풀에서 커넥션을 구해오는 메소드 호출 */
			con = getConnection();
			
			// 해당 글의 상세정보를 구해오는 select SQL문 작성
			String sql = "select * from model2board where board_num=?";
			// PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			// select SQL문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return board;
	}
}
