package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardReply implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardReply");
		
		// post방식으로 전송되는 한글 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// hidden객체로 전달된 변수 값 설정
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		String page = request.getParameter("page");
		
		// DTO객체 생성
		BoardBean board = new BoardBean();
		// 전달된 변수 값을 DTO객체에 저장
		board.setBoard_num(board_num);
		board.setBoard_re_ref(board_re_ref);
		board.setBoard_re_lev(board_re_lev);
		board.setBoard_re_seq(board_re_seq);
		
		// 사용자가 입력한 정보를 DTO객체에 저장
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		// DB연동
		BoardDAO dao = BoardDAO.getInstance();
		// 댓글 작성 메소드 실행
		int result = dao.boardReply(board);
		if(result == 1) {
			System.out.println("댓글 작성 성공");
		}
		
		
		// 포워딩 처리
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);	// url주소가 바뀌어서 출력
		forward.setPath("./BoardListAction.do?page="+page);
		return forward;
	}

}
