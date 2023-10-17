// DTO(Data Transfer Object) 클래스

package upload;

import java.sql.Timestamp;

public class BoardDataBean {

	// property
	private int num;
	private String writer;
	private String email;
	private String subject;
	private String passwd;
	private Timestamp reg_date;
	private int readcount;
	private String content;
	private String ip;
	private String upload;
	
	
	// getXxx and setXxx 메소드	
	public int getNum() {
		return num;
	}
	public String getWriter() {
		return writer;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject() {
		return subject;
	}
	public String getPasswd() {
		return passwd;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public String getContent() {
		return content;
	}
	public String getIp() {
		return ip;
	}
	public String getUpload() {
		return upload;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
}
