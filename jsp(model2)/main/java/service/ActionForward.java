package service;

public class ActionForward {

	// 포워딩 방법 설정
	private boolean redirect;
	// 포워딩 파일명 설정
	private String path;
	
	// Getter & setter
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
