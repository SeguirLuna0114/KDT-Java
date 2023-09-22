package chap11.member;

import java.util.Date;

public class MemberInfo {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private Date registerDate;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String val) {
		this.id = val;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String val) {
		this.password = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String val) {
		this.name = val;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String val) {
		this.address = val;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date val) {
		this.registerDate = val;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String val) {
		this.email = val;
	}
}
