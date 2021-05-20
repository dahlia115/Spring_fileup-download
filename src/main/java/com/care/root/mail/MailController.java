package com.care.root.mail;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {
	@Autowired
	MailService ms;
	@GetMapping("sendmail")
	public void sendSipleMail(HttpServletRequest request,
						HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>메일 전송 되었습니다</h1>");
		
		ms.sendMail("dahlia115@naver.com","(제목)테스트 메일","(내용)안녕하세요");//받는 사용자 이메일
	}
}
