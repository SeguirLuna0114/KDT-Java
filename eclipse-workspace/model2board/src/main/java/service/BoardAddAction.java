package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import model.BoardBean;

public class BoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardAddAction");
		
		String path = request.getRealPath("boardupload");
		System.out.println("path: " + path);
		
		// 첨부파일의 크기 제어
		int size = 1024 * 1024;		// 1MB 설정
		
		// 첨부파일의 경우 MultipartRequest클래스로 객체를 생성하면서 파일 업로드 수행
		MultipartRequest multi = 
				new MultipartRequest(request,	
									 path,		// 업로드 디렉토리
									 size,		// 업로드 파일 크기(1MB)
									 "utf-8",	// 한글 인코딩 설정
									 new DefaultFileRenamePolicy());	// 파일 중복문제 해결
		
		// DTO객체 생성 => request로 전달된 변수를 받음
		BoardBean board = new BoardBean();
		board.setBoard_name(multi.getParameter("board_name"));
		board.setBoard_pass(multi.getParameter("board_pass"));
		board.setBoard_subject(multi.getParameter("board_subject"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setBoard_file(multi.getParameter("board_file"));
		
		// DB연동을 위해 DAO객체 호출
		BoardDAO dao = BoardDAO.getInstance();
		// 글 작성 메소드(insert) 호출
		int result = dao.insert(board);
		if(result == 1) {
			System.out.println("글 작성 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		// 글 작성 후, "목록을 가져오는 action클래스호출"
		forward.setPath("./BoardListAction.do");
		
		return forward;
	}
	
	

}
