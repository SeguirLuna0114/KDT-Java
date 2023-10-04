// DTO(Data Transfer Object)

package member;

public class MemberDataBean {
	
	// property
	private String id;
	private String passwd;
	
	// getter & setter메소드
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
