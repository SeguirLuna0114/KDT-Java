package com.ch.hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController 어노테이션
	1. spring4 부터 지원
	2. @RestController = @Controller + @ResponseBody
	3. DTO객체를 JSON형태로 변환해주는 역할 수행
*/
@RestController
public class SampleController {
	@RequestMapping("/sample")
//	@ResponseBody
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		return sv;
	}

	@RequestMapping("/list")
	public List<SampleVo> list() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		for (int i = 1; i <= 10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			list.add(sv);
		}
		return list;
	}
}