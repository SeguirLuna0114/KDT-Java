//DTO(Data Transfer Object) 클래스

package board;

public class BoardBean {
	
	// property
	private String title;
	private String name;
	private String password;
	private String content ;
	
	
	// getXxx and setXxx 메소드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
