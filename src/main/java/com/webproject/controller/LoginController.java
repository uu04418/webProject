package com.webproject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Loginuser;
import com.webproject.service.LoginService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.ResultMap;

@Controller
public class LoginController {
	
	@Autowired
	private HttpServletRequest request; 
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String showLogin() {
		return "admin/" +   "login";
	}
	
	@RequestMapping("/showPage/{attr}")
	public String showPage (@PathVariable String attr) {
		System.out.println(attr);
		return "admin/" + "login";
	};
	
	
	
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultMap dologin (String username , String password) {
		
		Loginuser loginuser = loginService.checkUser(username , password);
		if (CheckDataUtil.checkNotEmpty(loginuser)) {
			
			// 如果用户不正常
			if (CheckDataUtil.checkNotEqual(loginuser.getState(), 0)) {
				return ResultMap.build(400, "登录失败,账号禁用");
			}
			// 密码不对
			if (CheckDataUtil.checkNotEqual(loginuser.getPassword(), password)) {
				return ResultMap.build(400, "登录失败,密码错误");
			}
			
			System.out.println("登录成功 " + username + "-" + password);
			request.getSession().setAttribute("loginUser", loginuser);
			return ResultMap.build(200, "登录成功" );
		} else {
			return ResultMap.build(400, "登录失败,密码错误");
		}
		
	};
	
	@ResponseBody
	@RequestMapping("/login/userMessage")
	public Map<String,Object> loginName (String username , String password) {
		Map<String, Object> map = new HashMap<>();
		Object loginUser = request.getSession().getAttribute("loginUser");
		map.put("loginUser", loginUser);
		return map;
	};
}
