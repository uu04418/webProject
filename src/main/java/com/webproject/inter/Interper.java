package com.webproject.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.entity.Loginuser;
import com.webproject.service.UserService;

import weixin.popular.bean.user.User;

public class Interper implements HandlerInterceptor {
	
	@Autowired
	UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 用户访问的url
		String currentUrl = request.getRequestURI();
		System.out.println("请求路劲===" + currentUrl);
		String  acctoken = (String)request.getHeader("Authorization");
		System.out.println("请求TOKEN==="+acctoken);
		Loginuser user = userService.getUserByAcctoken(acctoken);
		return true ;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		
		
	}

}
