package com.care.root.mail;

import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("sendmail2")
	public void sendSipleMail2(HttpServletRequest request,
						HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>메일 전송 되었습니다</h1>");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href='https://naver.com'>");
		sb.append("<img src='https://www.google.co.kr/search?q=%EB%9D%BC%EC%9D%B4%EC%96%B8&sxsrf=ALeKk02kLicbfxxs3LO7KAokc6AyjtJ-7g:1621498614516&tbm=isch&source=iu&ictx=1&fir=0UUAR_znlEG4pM%252C2wg_bGyiwl1LmM%252C_&vet=1&usg=AI4_-kR05t_xrBRx705IlE1g3t6gUiQL2A&sa=X&ved=2ahUKEwig3K-H6dfwAhVGA4gKHSf_DAEQ9QF6BAgQEAE#imgrc=0UUAR_znlEG4pM' whdith='150px' height='150px'>");
		sb.append("</a></body></html>");
		
		String str = sb.toString();
		ms.sendMail("dahlia115@naver.com","(제목)테스트 메일",str);//받는 사용자 이메일
	}
	@GetMapping("auth-form")
	public String authForm() {
		return "authentication";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:http://www.naver.com"; 
	}
	@GetMapping("auth_check")
	public String auth_check(@RequestParam String userid,
							@RequestParam String userkey, HttpSession session) {
		String sessionKey = (String)session.getAttribute(userid);
		if(sessionKey != null) {
			if(sessionKey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		
		return "redirect:auth-form";
	}
}












