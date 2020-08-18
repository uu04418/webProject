package com.webproject.service;

import com.webproject.entity.Loginuser;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

import weixin.popular.bean.user.User;

public interface UserService {

	PageResult list(Loginuser search, int page, int rows);

	Loginuser findOne(String id);

	Result add(Loginuser user);

	Result update(Loginuser user);

	Result deleteOne(String id);

	Loginuser getUserByAcctoken(String acctoken);

}
