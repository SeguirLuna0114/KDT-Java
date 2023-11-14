package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


// @RestController
// 1. spring4부터 지원
// 2. @RestController ~ @Controller + @ResponseBody
// 3. DTO객체, List를 json으로 변환해주는 역할을 수행함
@RestController
public class HelloController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot";
	}
}
