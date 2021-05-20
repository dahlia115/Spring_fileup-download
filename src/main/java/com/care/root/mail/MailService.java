package com.care.root.mail;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired JavaMailSender mailSender;
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper me = new MimeMessageHelper(message,true,"UTF-8");
			me.setSubject(subject);//제목
			me.setTo(to);//보내는 곳
			me.setText(body, true);//내용 (true로 해야 html문법으로 넘어간다
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void auth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = "test123";
		String userkey = rand();
		session.setAttribute(userid, userkey);
		String body="<h2>안녕하세요</h2>"
				+"<a href='http://localhost:8085/root/auth_check?"
				+"userid="+userid+"&userkey="+userkey+"'>인증하기</a>";
		sendMail("dahlia115@naver.com", "인증(제목)", body);
	}
	public String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75)+48;//랜덤한 수(0~74)에 +48 ((48~122)아스키 코드값 숫자 ~ 소문자 z
			if((num >= 48 && num <=57) || (num >= 65 && num <=90) || (num >= 97 && num <= 122)) {
				
				str += (char)num;
				
			}
		}
		return str;
	}
}









