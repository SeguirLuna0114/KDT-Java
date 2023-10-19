package service;

public class ActionForward {

	// 포워딩 방식 설정
	private boolean redirect;
	// 포워딩 페이지명 설정
	private String path;
	
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
