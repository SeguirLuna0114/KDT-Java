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
		
		
		// 글 내용 줄바꿈 기능
		String content = board.getBoard_content().replace("\n", "<br>");
		
		// 공유 설정(상세정보 처리 시, 필요한 값 request 공유 설정)
		request.setAttribute("board", board);
		request.setAttribute("content", content);
		request.setAttribute("page", page);
		
		// 포워딩 설정
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 	// dispatcher방식으로 포워딩
		forward.setPath("./board/board_view.jsp");	// 상세정보 페이지로 이동
		
		return forward;
	}

}
