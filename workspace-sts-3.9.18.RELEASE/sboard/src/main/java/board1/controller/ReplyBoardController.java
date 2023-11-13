package board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board1.model.Board;
import board1.model.ReplyBoard;
import board1.service.BoardService;
import board1.service.ReplyBoardService;

@Controller
public class ReplyBoardController {
	// @Autowired 어노테이션을 사용하여 객체 주입
	@Autowired
	private ReplyBoardService rbs;
	@Autowired
	private BoardService bs;

	// 댓글 목록 조회 - slist
	@RequestMapping("/slist/num/{num}")
	public String slist(@PathVariable int num, Model model) {
		Board board = bs.select(num);
		// num에 해당하는 게시글을 조회하고, 댓글 목록을 가져옴
		List<ReplyBoard> slist = rbs.list(num);
		
		// 조회된 게시글과 댓글 목록을 모델에 추가하여 "slist" 뷰로 전달
		model.addAttribute("slist", slist);
		model.addAttribute("board", board);
		return "slist";
	}

	// 댓글 등록 - sInsert
	@RequestMapping("/sInsert")
	public String sInsert(ReplyBoard rb, Model model) {
		rbs.insert(rb);
		return "redirect:slist/num/" + rb.getBno();
	}

	// 댓글 삭제 - repDelete
	@RequestMapping("/repDelete")
	public String delete(ReplyBoard rb, Model model) {
		rbs.delete(rb.getRno());
		return "redirect:slist/num/" + rb.getBno();
	}

	// 댓글 수정 - repUpdate
	@RequestMapping("/repUpdate")
	public String repUpdate(ReplyBoard rb, Model model) {
		rbs.update(rb);
		// 수정된 댓글이 속한 게시글의 댓글 목록을 보여주는 페이지로 리다이렉트
		return "redirect:slist/num/" + rb.getBno();
	}
}