package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;

public class UpdateMember implements Action{

	// 인터페이스의 경우, 메소드 오버라이딩 필요
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateMember");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDAO dao= MemberDAO.getInstance();
		
		// 1명의 상세정보 구하는 메소드 호출
		MemberDTO member = dao.getMember(id);
		System.out.println("수정 폼 : "+member);
		
		// hobby="공부-게임-등산-"; -> h[0]="공부", h[1]="게임"
		String hobby = member.getHobby();
		String[] h = hobby.split("-");
		
		// request 공유 설정 -> 공유되는name값.필드명
		request.setAttribute("member", member);
		request.setAttribute("h", h);
		
		/** request객체로 공유한 경우에는, dispatcher방식으로 포워딩을 해야
		  	view 페이지에서 공유한 값에 접근할 수 있다. */
		ActionForward forward = new ActionForward();
		// setRedirect를 false로 설정하여 리다이렉트 방식이 아니라 디스패처 방식으로 포워딩
		forward.setRedirect(false); // dispatcher방식으로 포워딩
		forward.setPath("./member/updateform.jsp");
		
		return forward;
	}
	
}
