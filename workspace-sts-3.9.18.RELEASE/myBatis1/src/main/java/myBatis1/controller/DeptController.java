package myBatis1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myBatis1.model.Dept;
import myBatis1.service.DeptService;

@Controller	// 클래스 선언시 사용. Spring MVC 컨트롤러 클래스임을 나타냄
public class DeptController {
	@Autowired	// DeptService 빈을 주입하기 위해 @Autowired 어노테이션 사용
	private DeptService ds;

/* 각 컨트롤러 메소드에 URL매핑
   @RequestMapping 어노테이션을 사용하여 각 메서드를 특정 URL과 연결
   컨트롤러 메서드에서 Model 객체를 매개변수로 받아서 사용 => 뷰로 데이터 전달
*/
	// 부서 목록
	@RequestMapping("deptList.do")
	public String list(Model model) {
		// 부서 목록 조회
		List<Dept> list = ds.list();
		// 조회 결과를 모델에 추가
		model.addAttribute("list", list);
		// "deptList" 뷰로 이동(deptList.jsp)
		return "deptList";
	}

	//부서 정보 조회
	@RequestMapping("deptView.do")
	public String deptView(@RequestParam("deptno") int deptno,
						   Model model) {
		// 특정 부서의 정보를 조회
		Dept dept = ds.select(deptno);
		// 해당 부서 정보를 모델에 추가
		model.addAttribute("dept", dept);
		// deptView" 뷰로 이동
		return "deptView";
	}

	// 수정 폼
	@RequestMapping("deptUpdateForm.do")
	public String deptUpdateForm(int deptno, Model model) {
		// 부서 정보를 수정하기 위한 폼을 표시
		Dept dept = ds.select(deptno);
		// 수정할 부서 정보를 모델에 추가
		model.addAttribute("dept", dept);
		// "deptUpdateForm" 뷰로 이동
		return "deptUpdateForm";
	}

	// 수정
	@RequestMapping("deptUpdate.do")
	public String deptUpdate(@ModelAttribute Dept dept,
							 Model model) {
		// 부서 정보를 수정
		int result = ds.update(dept);
		// 결과를 모델에 추가
		model.addAttribute("result", result);
		// "deptUpdate" 뷰로 이동
		return "deptUpdate";
	}

	@RequestMapping("deptDelete.do")
	public String deptDelete(int deptno, Model model) {
		// 부서 정보를 삭제
		int result = ds.delete(deptno);
		// 결과를 모델에 추가
		model.addAttribute("result", result);
		// "deptDelete" 뷰로 이동
		return "deptDelete";
	}
}