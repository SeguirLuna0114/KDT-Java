package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JoinController {
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	/* @ModelAttribute : 가입 양식에서 넘어온 값을 DTO객체를 생성해서
	 * 					 값을 받을 때 사용되는 어노테이션
	 * */
	@RequestMapping("/join")
	public String join(@ModelAttribute Member member, Model model) {
		System.out.println("ID: " + member.getId());
		
		model.addAttribute("member", member);
		return "joinResult";
	}
}