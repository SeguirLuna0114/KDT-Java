// DAO 클래스

package send;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class QueryDAO {

	private static QueryDAO instance = new QueryDAO();
	
	public static QueryDAO getInstance(){
		return instance;
	}
	
	public void insert(QueryDTO dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try{
			Class.forName(driver);
			
			// DB접속
			con = DriverManager.getConnection(url,"totoro","totoro123");
			
			// insert SQL문
			String sql="insert into query values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getVclass());
			pstmt.setString(5, dto.getPhone());
			pstmt.executeUpdate();		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(Exception e){					
				}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){					
				}
			}			
		}
		
	}
	
}
