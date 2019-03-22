package com.webproject.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Loginuser;
import com.webproject.mapper.LoginuserMapper;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.LoginService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.Result;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserCustomerMapper userCustomerMapper;
	@Autowired
	private LoginuserMapper loginuserMapper;
	@Autowired
	private HttpServletRequest request;
	@Override
	public Loginuser checkUser(String username, String password) {
		
		// 根据电话号码和username查询
		Loginuser user = userCustomerMapper.searchUserByUserNameOrTelephone(username);
		
		if (CheckDataUtil.checkNotEmpty(user)) {
			
		}
		
		return user;
	}
	@Override
	public Result updateUser(Loginuser user) {
		Object loginUser = request.getSession().getAttribute("loginUser");
		if (CheckDataUtil.checkisEmpty(loginUser)) {
			return new Result(false, "登录超时");
		}
		Loginuser searchUser = (Loginuser)loginUser; 
		
		if (CheckDataUtil.checkNotEmpty(user.getPassword())
				&& CheckDataUtil.checkNotEmpty(user.getNewword())) {
			if (CheckDataUtil.checkNotEqual(searchUser.getPassword(), user.getPassword())) {
				return new Result(false, "原始密码错误");
			}
			String newWord = IDUtils.getprivatePassword(user.getNewword());
			user.setPassword(newWord);
		}
	
		if (CheckDataUtil.checkisEmpty(user.getTelephone())
				|| CheckDataUtil.checkisEmpty(user.getUsername())) {
			return new Result(false, "检查输入的手机或者登录名");
		}
		user.setTelephone(user.getTelephone().replace(" ", ""));
		user.setUsername(user.getUsername().replace(" ", ""));
		
		Loginuser checkUser = userCustomerMapper.checkUser(user.getUserid() ,user.getUsername(),user.getTelephone());
		
		if (CheckDataUtil.checkNotEmpty(checkUser)) {
			return new Result(false,"用户名或者手机占用");
		}
		
		try {
			 loginuserMapper.updateByPrimaryKeySelective(user);
			 return new Result(true, "编辑成功");
		} catch (Exception e) {
			// TODO: handle exception、
			return new Result(false,"手机号或者登录账号重复");
		}
		
	}

}
