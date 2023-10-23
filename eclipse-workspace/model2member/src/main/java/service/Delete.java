package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;

public class Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		// out객체 생성
		PrintWriter out = response.getWriter();
		// session 객체 생성
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// DB연동을 위해 DAO객체 호출
		MemberDAO dao = MemberDAO.getInstance();
		
		// 1명의 상세정보 구하기
		MemberDTO db = dao.getMember(id);
		
		// 비번 비교
		if(db.getPasswd().equals(passwd)) {
			// 비번 일치하는 경우, delete SQL문 실행
			int result = dao.delete(id);
			if(result == 1) {
				System.out.println("회원탈퇴 성공"); 
			}
			
			// 세션 삭제
			session.invalidate();
		} else {
			// 비번 불일치 시
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.')");
			out.println("history.go(-1);");
			out.println("</script>");
			
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/loginform.jsp");
		
		return forward;
	}

}
