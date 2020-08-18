package com.webproject.service;

import java.util.List;

import com.webproject.entity.Loginuser;
import com.webproject.util.Result;
import com.webproject.util.ResultMap;

public interface LoginService {
	
	/**校验登录用户信息**/
	Loginuser checkUser(String username, String password);

	Result updateUser(Loginuser user);

	ResultMap register(String username, String password);

	List<Loginuser> findAllUser();

	Result getUserMessage(String userid);

}
