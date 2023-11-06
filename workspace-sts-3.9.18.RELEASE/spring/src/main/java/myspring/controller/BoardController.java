package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myspring.model.Board;
import myspring.service.BoardService;

// 컨트롤러 어노테이션 => 컨트롤러 기능 수행 가능
@Controller
public class BoardController {
	
	// Autowired어노테이션 : (서비스 빈 객체 없이도)서비스 객체 주입
	@Autowired
	private BoardService service;
	
	// 글 작성 폼
	@RequestMapping("boardform.do")
	public String boardform() {
		return "board/boardform";
	}
	
	
	// 글 작성
	@RequestMapping("boardwrite.do")
	public String boardwrite(@ModelAttribute Board board,
							 Model model) {
		int result = service.insert(board);
		if(result == 1) {
			System.out.println("글 작성 성공!");
		}
		
		model.addAttribute("result", result);
		
		return "board/insertresult";
	}
	
	
	// 글 목록
	@RequestMapping("boardlist.do")
	public String boardlist(@RequestParam(value ="page", defaultValue ="1") int page,
							Model model) {
//		int page = 1;	// defaultValue ="1"을 설정했기에 코드 작성 필요X
		int limit = 10;
		
		// page = 1, startRow=1, endRow=10
		// page = 1, startRow=11, endRow=20
		int startRow = (page-1)*limit + 1;
		int endRow =  page * limit;

		int listcount = service.getCount();
		System.out.println("listcount: " + listcount);
		
		List<Board> boardList = service.getBoardList(page);
		System.out.println("boardList: " + boardList);
		
		// 홈페이지
		int pageCount = listcount/limit + ((listcount % 10 == 0) ? 0 : 1);
		
		int startPage = ((page-1)/10) *limit + 1;
		int endPage =  startPage + 10 -1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/boardlist";
	}

}
