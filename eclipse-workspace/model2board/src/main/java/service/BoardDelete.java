package service;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete");
		
		request.setCharacterEncoding("utf-8");
		
		// 출력을 위한 out객체 생성
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");	

		String path = request.getRealPath("boardupload");
		System.out.println("path: " + path);
		
		// 비번 비교를 위해 변수 값 할당
		String board_pass = request.getParameter("board_pass");
		
		// DB연동
		BoardDAO dao = BoardDAO.getInstance();
		// 기존 DB에 저장된 게시판 상세정보 구해옴  
		BoardBean db = dao.getDetail(board_num);
		
		// 비번 비교 - 사용자가 입력한 비번과 DB에 저장된 비번을 비교
		if(db.getBoard_pass().equals(board_pass)) {
			// 비번이 일치할 경우, delete SQL문 실행
			int result = dao.delete(board_num);
			if(result == 1) {
				System.out.println("글 삭제 성공");
			}
			
			// 첨부파일이 있는 경우에 첨부파일 삭제
			if(db.getBoard_file() != null) {
				
				File file = new File(path);
				file.mkdir();
				
				// boardupload디렉토리의 모든 첨부파일 구하기
				File[] f = file.listFiles();
				for(int i=0; i<f.length; i++) {
					if(f[i].getName().equals(db.getBoard_file())) {
						// 첨부파일 삭제
						f[i].delete();
					}
				}
			}
			
			response.sendRedirect("./board/delete.jsp?page="+page);
			
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
