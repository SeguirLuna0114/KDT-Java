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
import service.BoardAddAction;
import service.BoardDelete;
import service.BoardDetailAction;
import service.BoardListAction;
import service.BoardModify;
import service.BoardModifyForm;
import service.BoardReply;
import service.BoardReplyForm;

@WebServlet("*.do")	// do 확장자로 요청하는 모든 요청을 받는다는 의미
public class BoardController extends HttpServlet {

	// doGet(), doPost() 메소드의 공통적인 작업을 처리하는 메소드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI: " +requestURI);
		System.out.println("contextPath: " + contextPath);
		System.out.println("command: " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		
		// 글 작성(원문 작성)
		if(command.equals("/BoardAddAction.do")) {
			try {
				action = new BoardAddAction();
				// Action 객체가 글작성 처리를 수행하고, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// 글 작성 폼
		} else if(command.equals("/BoardForm.do")) {
			forward = new ActionForward();
			// setRedirect를 false로 설정하여 리다이렉트 방식이 아니라 디스패처 방식으로 포워딩
			forward.setRedirect(false);
			forward.setPath("./board/board_write.jsp");
		
		
		// 글 목록
		} else if(command.equals("/BoardListAction.do")) {
			try {
				action = new BoardListAction();
				// Action 객체가 글 목록 처리를 수행하고, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		// 상세 페이지
		} else if(command.equals("/BoardDetailAction.do")) {
			try {
				action = new BoardDetailAction();
				// Action 객체가 상세페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		// 댓글 폼
		} else if(command.equals("/BoardReplyForm.do")) {
			try {
				action = new BoardReplyForm();
				// Action 객체가 댓글 폼 페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		// 댓글 작성 
		} else if(command.equals("/BoardReply.do")) {
			try {
				action = new BoardReply();
				// Action 객체가 댓글 폼 페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// 수정 폼 
		} else if(command.equals("/BoardModifyForm.do")) {
			try {
				action = new BoardModifyForm();
				// Action 객체가 댓글 폼 페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// 글 수정 
		} else if(command.equals("/BoardModify.do")) {
			try {
				action = new BoardModify();
				// Action 객체가 댓글 폼 페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// 글 삭제 폼 (DB연동하지 않기에, 서비스클래스로 이동할 필요X)
		} else if(command.equals("/BoardDeleteForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);		// dispatcher방식으로 포워딩(param으로 값을 받기 위함)
			// 글 삭제를 위한 페이지 경로
			forward.setPath("./board/board_delete.jsp");
		
			
			
		// 글 삭제
		} else if(command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
				// Action 객체가 삭제 페이지 실행, 그 결과를 ActionForward 객체에 설정
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {
				// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else {
				// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
	
	} // doProcess() end
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		// 공통 작업을 처리하는 doProcess()메소드 호출
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		// 공통 작업을 처리하는 doProcess()메소드 호출
		doProcess(request, response);
	}

}
