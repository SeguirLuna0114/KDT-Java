package controller;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailTest {

	@RequestMapping("/send.do")
	public String send(Model model) {

		Random random = new Random();
		int a = random.nextInt(100);	// 0~99 사이 난수

		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "giduck23@naver.com";	// 본인 이메일주소 입력
		String hostSMTPpwd = "00000000"; 			// 본인 네이버 비밀번호 입력

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "giduck23@naver.com";	// 보내는 사람의 이메일주소
		String fromName = "친절한 홍길동씨";			// 제목
		String subject = "Overflow인증메일입니다.";		// 내용

		// 받는 사람 E-Mail 주소
		String mail = "giduck23@gmail.com";

		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);		// SMTP 포트번호

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg("<p align = 'center'>Overflow에 오신것을 환영합니다.</p><br>" 
							 + "<div align='center'> 인증번호 : " + a + "</div>");
			// 메일 전송
			email.send();
		} catch (Exception e) {
			System.out.println(e);
		}		
		model.addAttribute("result", "good~!!\n 등록된 E-Mail 확인");

		// result.jsp파일로 이동
		return "result";
	}
}
