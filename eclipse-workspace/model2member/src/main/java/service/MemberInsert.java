package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;

// Action 인터페이스 상속받음
public class MemberInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 현재 클래스명이 출력되는 것으로 중간 확인
		System.out.println("MemberInsert");
		
		request.setCharacterEncoding("utf-8");
		
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setMailid(request.getParameter("mailid"));
		member.setDomain(request.getParameter("domain"));
		member.setTel1(request.getParameter("tel1"));
		member.setTel2(request.getParameter("tel2"));
		member.setTel3(request.getParameter("tel3"));
		member.setPhone1(request.getParameter("phone1"));
		member.setPhone2(request.getParameter("phone2"));
		member.setPhone3(request.getParameter("phone3"));
		member.setPost(request.getParameter("post"));
		member.setAddress(request.getParameter("address"));
		member.setGender(request.getParameter("gender"));
		
		String[] hobby = request.getParameterValues("hobby");
		String h = "";			// h = "공부-게임-";
		for(String h1 :  hobby) {
			h += h1 + "-";
		}
		member.setHobby(h);
		member.setIntro(request.getParameter("intro"));
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insert(member);	// insert SQL문 실행
		if(result == 1) System.out.println("회원가입 성공");		
		
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.println("<script>");
			out.println("location.href='./member/result.jsp'");
			out.println("</script>");
			out.close();
		}		
		
		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
//		forward.setPath("./member/loginform.jsp"); //포워딩 파일명
//		
//		return forward;
		
		return null;
	}

}
