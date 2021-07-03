package com.care.root.common.Interceptor;
//세션이 있어야하는 class
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.common.session.MemberSessionName;
import com.care.root.login.dto.LoginDTO;
import com.care.root.login.service.LoginService;

public class Interceptor1 extends HandlerInterceptorAdapter implements MemberSessionName{
	
	@Autowired LoginService ls;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Cookie loginCookie=WebUtils.getCookie(request, "loginCookie");
		if(loginCookie!=null){//자동로그인 존재
			System.out.println(loginCookie);
			System.out.println("interceptor1");
			LoginDTO dto=ls.getUserSessionId(loginCookie.getValue());
			if(dto!=null) {
				request.getSession().setAttribute(LOGIN, dto.getId());
			}
			return true;
		}		
		else {
			if(request.getSession().getAttribute(LOGIN)!=null) {//세션 존재
				return true;
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"+
				"location.href='/root/member/login'"+
				"</script>");
				return false;
			}
		}
	}
	
}
