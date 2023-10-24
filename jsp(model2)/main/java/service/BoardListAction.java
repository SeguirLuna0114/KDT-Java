package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardListAction");
		
		/** 페이지 변수 설정
		 *  1. page : 현재 페이지 번호 - 1페이지 기본값
		 *  2. limit : 한 페이지에 출력할 데이터 갯수 - 10 기본값
		 */
		int page = 1;	// 현재 페이지 번호
		int limit = 10;	// 한 페이지에 출력할 데이터 갯수
		
		// request로 받은 page변수 값이 null이 아니면, 정수로 변환
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// DB연동을 위해 DAO객체 생성
		BoardDAO dao = BoardDAO.getInstance();
		
		/** 페이지 변수 설정
		 * 3. listcount : 총 데이터 개수  */
		int listcount = dao.getCount();
		System.out.println("listcount: " + listcount);
		
		/** 페이지 "파생" 변수 설정 - 목록을 구해오는 변수
		 * 1. startRow : 해당 페이지의 첫번째 데이터 번호
		 * 2. endRow : 해당 페이지의 마지막 데이터 번호
		 */
		int startRow = (page - 1) * limit +1;
		int endRow = page * limit;
		
		// 페이지 목록 10개 구하기
		List<BoardBean> boardList = dao.getList(startRow, endRow);
		System.out.println("boardList: " + boardList);
		
		/** 페이지 "파생" 변수 설정
		 * 3. pageCount : 총 페이지 수 - 총 데이터 개수가 10의배수인지 아닌지에 따른 계산 필요
		 */
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		
		
		/** 페이지 "파생" 변수 설정 - 각 블럭의 페이지 번호
		 * 4. startPage : 각 블럭의 시작 페이지 번호(1, 11, 21, 31, ...)
		 * 5. endPage : 각 블럭의 마지막 페이지 번호(10, 20, 30, ...)
		 */
		int startPage = ((page - 1) / 10) * limit + 1;
		int endPage = startPage + 10 - 1;
		
		/* 존재하지 않는 페이지가 표시되지 않게 설정
		 * - 블럭의 마지막 페이지 번호가 총 페이지수를 넘어가지 않게 설정
		*/
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		
		/* 파생변수 공유 설정
		 * - 기본 자료형 => EL ${}로 받음
		 * - DTO객체 => EL ${공유되는name값.필드명}
		 * - List객체 => <c:forEach>태그로 반복문 활용
		 */
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		// ActionForward클래스 객체 생성
		ActionForward forward = new ActionForward();
		/** dispatcher방식으로 포워딩
		 * request객체로 공유한 경우에는, dispatcher방식으로 포워딩 되어야
		 * view 페이지에서 공유한 값에 접근할 수 있음
		 */
		forward.setRedirect(false);		// dispatcher방식으로 포워딩
		forward.setPath("./board/board_list.jsp");
		
		return forward;
	}

}
