package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardModify");
		
		// 한글 인코딩
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		// 출력을 위한 out객체 생성
		PrintWriter out = response.getWriter();

		// hidden객체로 전달된 변수 설정
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		// 비번 비교를 위해 변수 값 할당
		String board_pass = request.getParameter("board_pass");
		
		
		// DTO객체 생성 -> 수정 할 데이터 저장
		BoardBean board = new BoardBean();
		board.setBoard_num(board_num);
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		// DB연동
		BoardDAO dao = BoardDAO.getInstance();
		// 기존 DB에 저장된 게시판 상세정보 구해옴  
		BoardBean db = dao.getDetail(board_num);
		
		// 비번 비교 - 사용자가 입력한 비번과 DB에 저장된 비번을 비교
		if(db.getBoard_pass().equals(board_pass)) {
			// 비번이 일치할 경우, update SQL문 실행
			int result = dao.update(board);
			if(result == 1) {
				System.out.println("글 수정 성공");
			}
			
			out.println("<script>");
			out.println("location.href='./board/update.jsp?page=" + page +"'");
			// update.jsp파일 내에서 글 수정 성공을 출력
			out.println("</script>");
			out.close();
			
			// 아래 코드가 실행되지 않게 null 리턴
			return null;
			
		} else {
			// 비번 불일치 시
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			// 아래 코드가 실행되지 않게 null 리턴
			return null;
		}
	
		
/*		
		// 포워딩 설정
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		// 목록페이지로 이동하게 설정
		forward.setPath("./BoardListAction.do?page="+page);
		return forward;
*/		
	}
}
