package com.care.root.login.controller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.care.root.common.session.MemberSessionName;
import com.care.root.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService ls;
	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("member/login")
	public String login(@RequestParam("id") String id,@RequestParam("pw") String pw,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,
			@RequestParam(value="autoLogin",required = false) String autoLogin) throws Exception {	
		System.out.println(id);System.out.println(pw);
		if(ls.login(id,pw)==1) {			
			session.setAttribute(MemberSessionName.LOGIN, id);//기본적인 세션 생성
			if(autoLogin!=null) {
				int limitTime=60*60*24*90;//90일 동안 유지
				Cookie loginCookie=new Cookie("loginCookie",session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(limitTime);
				response.addCookie(loginCookie);
				
				Calendar cal=Calendar.getInstance();
				cal.setTime(new java.util.Date());
				
				cal.add(Calendar.MONTH,3);
				
				Date limitDate=new Date(cal.getTimeInMillis());
				ls.keepLogin(session.getId(), limitDate, id);
			}
			return "redirect:/main";
		}
		else {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//String str="";
		//str+="<script>";
		//str+="alert('아이디 또는 비밀번호가 잘못되었습니다')";
		//str+="</script>";
		out.print("<script>alert('"+"아이디 또는 비밀번호가 잘못되었습니다"+"');</script>");
		out.flush();
		return "member/login";
		}
	}
	@GetMapping("member/logout")
	public String logout(HttpSession session, HttpServletResponse response,
			@CookieValue(value="loginCookie", required = false) Cookie loginCookie) {
		if(session.getAttribute(MemberSessionName.LOGIN)!=null) {
			if(loginCookie!=null) {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			
			System.out.println(loginCookie);
			ls.keepLogin("nan", new Date(System.currentTimeMillis()),
							(String)session.getAttribute(MemberSessionName.LOGIN));
		}
		session.invalidate();
	}
	return "redirect:/main";
}
	}
