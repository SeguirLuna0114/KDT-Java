package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDetailAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		// DB연동을 위한 DAO객체 호출
		BoardDAO dao = BoardDAO.getInstance();
		// 조회수 1증가시키는 메소드 실행
		dao.readcountUpdate(board_num);
		// 상세정보를 구해오는 메소드 실행
		BoardBean board = dao.getDetail(board_num);
		System.out.println("상세정보: " + board);
		
		
		ActionForward forward = new ActionForward();
		
		return forward;
	}

}
