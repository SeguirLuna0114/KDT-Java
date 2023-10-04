// DAO(Data Access Object)

package register;

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
		
		return result;
	}
}
