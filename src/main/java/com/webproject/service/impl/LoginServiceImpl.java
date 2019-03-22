package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Loginuser;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.LoginService;
import com.webproject.util.CheckDataUtil;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserCustomerMapper userCustomerMapper;
	@Override
	public Loginuser checkUser(String username, String password) {
		
		// 根据电话号码和username查询
		Loginuser user = userCustomerMapper.searchUserByUserNameOrTelephone(username);
		
		if (CheckDataUtil.checkNotEmpty(user)) {
			
		}
		
		return user;
	}

}
