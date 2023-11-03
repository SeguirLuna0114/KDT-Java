package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	@RequestMapping("/addr")
	public String addr(@RequestParam("name") String name,
					   @RequestParam("addr") String addr,
					   Model model) {
		System.out.println("name : "+ name);		
		System.out.println("addr : "+ addr);		
		
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}

	/* @ModelAttribute 어노테이션
	 * : 가입 양식에서 넘어오는 값들을 DTO객체를 생성해서 저장시켜주는 어노테이션
	 * */
	@RequestMapping("/addr2")
	public String addr2(@ModelAttribute Person p, Model model) {
		System.out.println("이름 : " + p.getName());
		System.out.println("주소 : " + p.getAddr());
		
		model.addAttribute("person", p);
		return "addr2";
	}
}