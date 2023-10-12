package board;

public class BoardDataBean {
	
	// property
	private String writer;
	private String passwd;
	private String subject;
	private String content;
	
	// getXxx & SetXxx
	public String getWriter() {
		return writer;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
