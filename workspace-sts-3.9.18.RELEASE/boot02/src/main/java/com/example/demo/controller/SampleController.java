package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Member;

@Controller
public class SampleController {

	@RequestMapping("main")
	public String main() {
		// prefix(/WEB-INF/views/)와 suffix(.jsp)를 제외한 값을 입력
		return "main";
	}
	
	@RequestMapping("send")
	public String send(Member member, Model model) {
		System.out.println("id: "+member.getId());
		System.out.println("passwd: "+member.getPasswd());
		
		// model객체의 DTO클래스(member)
		model.addAttribute("member", member);
		
		return "result";
	}
}
