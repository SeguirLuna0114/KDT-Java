package board1.controller;

// 게시판 기능을 담당하는 클래스
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board1.model.Board;
import board1.service.BoardService;
import board1.service.PagingPgm;

@Controller	// Spring MVC Controller로 선언
public class BoardController {
	@Autowired	// Autowired를 이용한 BoardService 인스턴스 주입
	private BoardService bs;

	@RequestMapping("/list")
	public String initList() {
		return "redirect:list/pageNum/1";
	}

	/*
	 * @RequestMapping(
	 * "/list/pageNum/{pageNum}/search/{search}/keyword/{keyword}") public
	 * String search2(@PathVariable String pageNum,
	 * 
	 * @PathVariable String search, @PathVariable String keyword, Model model) {
	 * Board board = new Board(); board.setSearch(search);
	 * board.setKeyword(keyword); model.addAttribute("board", board); return
	 * "forward:list/pageNum/1"; }
	 */
	@RequestMapping("/list/pageNum/{pageNum}")
	public String list(@PathVariable String pageNum, Board board, Model model) {
						/* @PathVariable 어노테이션
						 * : URL 패턴에서 변수를 추출하는 데 사용
						 * - 메서드 매개변수에 @PathVariable 어노테이션을 사용
						 * 	=> 해당 매개변수는 URL의 일부를 {변수}로 사용(동적인 URL)
						 * - {}로 둘러싼 부분 = 경로 변수
						 *  => Spring은 이 부분을 추출하여 해당 변수에 할당
						 * */
		
		final int rowPerPage = 10;
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		// int total = bs.getTotal();
		int total = bs.getTotal(board); // 검색
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		PagingPgm pp = new PagingPgm(total, rowPerPage, currentPage);
		board.setStartRow(startRow);
		board.setEndRow(endRow);
		// List<Board> list = bs.list(startRow, endRow);
		int no = total - startRow + 1;
		List<Board> list = bs.list(board);
		model.addAttribute("list", list);
		model.addAttribute("no", no);
		model.addAttribute("pp", pp);
		// 검색
		model.addAttribute("search", board.getSearch());
		model.addAttribute("keyword", board.getKeyword());
		return "list";
	}

// 게시판의 CRUD (생성, 읽기, 수정, 삭제) 기능을 담당
	
	@RequestMapping("/insertForm")
	public String initInsert() {
		return "redirect:insertForm/nm/null/pageNum/1";
	}

	@RequestMapping("/insertForm/nm/{nm}/pageNum/{pageNum}")
	public String insertForm(@PathVariable String nm, @PathVariable String pageNum, Model model) {
		if (nm.equals("null"))
			nm = null;
		int num = 0, ref = 0, re_level = 0, re_step = 0;
		if (nm != null) {
			num = Integer.parseInt(nm);
			Board board = bs.select(num);
			ref = board.getRef();
			re_level = board.getRe_level();
			re_step = board.getRe_step();
		}
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("re_level", re_level);
		model.addAttribute("re_step", re_step);
		model.addAttribute("pageNum", pageNum);
		return "insertForm";
	}

	// insert - 새로운 게시글을 추가
	@RequestMapping("/insert")
	public String insert(Board board, Model model, HttpServletRequest request) {
		int num = board.getNum();
		int number = bs.getMaxNum();
		if (num != 0) {			// 답변글
			// 답변글인 경우, bs.updateRe(board)를 호출하여 답변글의 순서를 조절
			bs.updateRe(board);
			board.setRe_level(board.getRe_level() + 1);
			board.setRe_step(board.getRe_step() + 1);
		} else					// 원문
			board.setRef(number);
		board.setNum(number);
		String ip = request.getRemoteAddr();
		board.setIp(ip);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		return "insert";
	}

	// 특정 게시글을 조회하고, 조회수를 증가시킴
	@RequestMapping("/view/num/{num}/pageNum/{pageNum}")
	public String view(@PathVariable int num, @PathVariable String pageNum, Model model) {
		bs.selectUpdate(num);
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "view";
	}

	// 특정 게시글을 수정하기 위한 폼을 보여줌
	@RequestMapping("/updateForm/num/{num}/pageNum/{pageNum}")
	public String updateForm(@PathVariable int num, @PathVariable String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "updateForm";
	}

	@RequestMapping("/update/pageNum/{pageNum}")
	public String update(Board board, @PathVariable String pageNum, Model model) {
		int result = bs.update(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "update";
	}

	// 특정 게시글을 삭제하기 전에 삭제 확인을 위한 폼을 보여줌
	@RequestMapping("/deleteForm/num/{num}/pageNum/{pageNum}")
	public String deleteForm(@PathVariable int num, @PathVariable String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "deleteForm";
	}

	// 특정 게시글을 삭제
	@RequestMapping("/delete")
	public String delete(int num, String pageNum, Model model) {
		int result = bs.delete(num);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "delete";
	}
}