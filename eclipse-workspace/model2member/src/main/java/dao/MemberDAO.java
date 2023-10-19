// DAO(Data Access Object)

package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.MemberDTO;

public class MemberDAO {
	
	// 싱글톤 : 객체 생성을 한번만 수행
	private static MemberDAO instance = new MemberDAO();
	
	// 싱글톤 객체를 반환해주는 메소드
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
	
	
	// 회원가입 메소드
	public int insert(MemberDTO member) {
		int result = 0;
		
		return result;
	}

}
