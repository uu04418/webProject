package com.webproject.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Loginuser;
import com.webproject.service.LoginService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.Result;
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
	
	@RequestMapping("/logout")
	@ResponseBody
	public Result logout() {
		request.getSession().removeAttribute("loginUser");
		return  new Result(true ,"退出成");
	}
	
	@RequestMapping("/showPage/{attr}")
	public String showPage (@PathVariable String attr) {
		System.out.println(attr);
		return "admin/" + "login";
	};
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Result updateUser (@RequestBody Loginuser user) {
		if (CheckDataUtil.checkisEmpty(user.getPassword())) {
			user.setPassword(null);
		}
		return loginService.updateUser(user);
	};
	
	
	
	
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultMap dologin (@RequestBody Loginuser loginUser) {
		
		if ( CheckDataUtil.checkisEmpty(loginUser)
				&&CheckDataUtil.checkisEmpty(loginUser.getUsername())
				&& CheckDataUtil.checkisEmpty(loginUser.getPassword())) {
			return ResultMap.build(400, "请输入账号和密码");
		}
		
		String username = loginUser.getUsername().replace(" ", "");
		String password = loginUser.getPassword();
		Loginuser loginuser = loginService.checkUser(username , password);
		if (CheckDataUtil.checkNotEmpty(loginuser)) {
			
			// 如果用户不正常
			if (CheckDataUtil.checkNotEqual(loginuser.getState(), 0)) {
				return ResultMap.build(400, "登录失败,账号禁用");
			}
			// 密码不对
			password = IDUtils.getprivatePassword(password);
			if (CheckDataUtil.checkNotEqual(loginuser.getPassword(), password)) {
				return ResultMap.build(400, "登录失败,密码错误");
			}
			return ResultMap.build(200, "登录成功" , loginuser);
		} else {
			return ResultMap.build(400, "登录失败,密码错误");
		}
		
	};
	
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultMap register (@RequestBody Loginuser user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (CheckDataUtil.checkisEmpty(username)
				&& CheckDataUtil.checkisEmpty(password)) {
			return ResultMap.build(400, "请输入账号和密码");
		}
		username = username.replace(" ", "");
		
		return loginService.register(username,password);
		
	};
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/login/getUserMessage")
	public Result getUserMessage (String userid) {
		return loginService.getUserMessage(userid);
	};
}
