package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;
import service.IdCheck;
import service.Login;
import service.MemberInsert;

/** MVC (Model-View-Controller) 아키텍처에서 컨트롤러 부분을 구현
 *  컨트롤러 클래스는 HTTP GET 및 POST 요청을 처리
 *  이러한 컨트롤러는 클라이언트의 요청을 분석하고,
 *  적절한 모델(비즈니스 로직)과 뷰(사용자 인터페이스)를 호출하여 요청을 처리하는 데 사용됨 */

@WebServlet("*.do")		//  Servlet이 ".do" 확장자를 가진 모든 요청을 처리
public class MemberController extends HttpServlet {
	
	// doGet()메소드와 doPost()메소드애서 공통적인 작업을 처리하는 메소드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 현재 요청의 URI 및 컨텍스트 경로를 추출하여 command 변수에 저장
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();	// 현재 프로젝트 명
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI: "+requestURI);
		System.out.println("contextPath: "+contextPath);
		System.out.println("command: "+command);
//		requestURI: /model2member/MemberInsert.do
//		contextPath: /model2member
//		command: /MemberInsert.do
		
		// 중간에 흐름을 제어하며, 연결시켜주는 코드 작성
		Action action = null;
		ActionForward forward = null;
		
		// 회원가입
		if(command.equals("/MemberInsert.do")) {
			try {
				action = new MemberInsert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		//ID중복 검사(ajax)	
		}else if(command.equals("/IdCheck.do")) {
			try {
				action = new IdCheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원가입 폼	
		}else if(command.equals("/MemberForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberform.jsp");
		
		// 로그인 폼
		}else if(command.equals("/LoginForm.do")) {	
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginform.jsp");
			
		// 로그인(회원인증)	
		}else if(command.equals("/Login.do")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그아웃			
		}else if(command.equals("/Logout.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/logout.jsp");
		}

		
		// null값이 아니기에, 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {	// redirect방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {						// dispatcher방식으로 포워딩
				RequestDispatcher dispatcher =
				   request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);				
			}			
		}	
		
	} // doProcess() end	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		// doProcess()메소드 호출
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		// doProcess()메소드 호출
		doProcess(request, response);
	}

}
