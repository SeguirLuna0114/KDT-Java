package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Action 인터페이스 상속받음
public class MemberInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 현재 클래스명이 출력되는 것으로 중간 확인
		System.out.println("MemberInsert");
		
		// ActionForward 객체를 생성
		ActionForward forward = new ActionForward();
		
		
		return forward;
	}

}
