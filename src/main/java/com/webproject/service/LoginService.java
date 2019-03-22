package com.webproject.service;

import com.webproject.entity.Loginuser;
import com.webproject.util.Result;

public interface LoginService {
	
	/**校验登录用户信息**/
	Loginuser checkUser(String username, String password);

	Result updateUser(Loginuser user);

}
