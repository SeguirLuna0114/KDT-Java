import java.sql.*;

public class JDBC_Connect02{

  public static void main(String[] args)  {

/** aws_ec2 oracle 접속 *****************************************/
//	String driver = "oracle.jdbc.driver.OracleDriver"; 
//	String url = "jdbc:oracle:thin:@13.124.84.50:1521:xe";
/*******************************************************************/

/** aws_rds oracle 접속 *****************************************/
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@orcl.cyqct7nnxb1u.ap-northeast-2.rds.amazonaws.com:1521:orcl";
/*******************************************************************/	
	
	
	
	
/** My-SQL JDBC Driver *********************************************/
//	String driver ="com.mysql.jdbc.Driver";
//	String url = "jdbc:mysql://localhost/academy";
/*******************************************************************/

    Connection con = null;

    try{

      Class.forName(driver);

/**   ORACLE에서 Connection 객체 ***********************************/
    con = DriverManager.getConnection(url, "master", "oracle123" );
/*******************************************************************/

/**   My-SQL에서 Connection 객체 ***********************************/
//	  con = DriverManager.getConnection(url, "totoro", "1234" );
/*******************************************************************/

		System.out.println("데이터베이스 연결 성공~!!");

    } catch(Exception e){
		System.out.println("데이터베이스 연결 실패~!!");
		e.printStackTrace();
    } finally{
		try{
			if( con != null )         con.close();
		} catch(Exception e){
			System.out.println( e.getMessage( ));  
        }
   }
 }
}  
