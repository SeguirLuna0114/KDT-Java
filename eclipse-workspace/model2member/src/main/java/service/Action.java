package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	// 추상 메소드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
		

}
