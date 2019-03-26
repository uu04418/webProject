package com.webproject.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Loginuser;
import com.webproject.mapper.LoginuserMapper;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.LoginService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.DateUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.Result;
import com.webproject.util.ResultMap;

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
			user.setLastgoin(new Date());
			loginuserMapper.updateByPrimaryKey(user);
		}
		return user;
	}
	@Override
	public Result updateUser(Loginuser user) {
		Loginuser searchUser = loginuserMapper.selectByPrimaryKey(user.getUserid());
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
	@Override
	public ResultMap register(String username, String password) {
		// 根据电话号码和username查询
		Loginuser user = userCustomerMapper.searchUserByUserNameOrTelephone(username);
		if (CheckDataUtil.checkNotEmpty(user)) {
			return ResultMap.build(400, "该账号已经存在");
		}
		user = new Loginuser();
		user.setAvatar("http://www.genealogy.zzw777.com/155325446644464.png");
		user.setLastgoin(new Date());
		user.setPassword(IDUtils.getprivatePassword(password));
		user.setState(0);
		user.setType(2);
		user.setTelephone("");
		user.setRegistime(new Date());
		String userid = userCustomerMapper.getNextUserId();
		user.setUsername(username);
		user.setUserid(userid);
	    loginuserMapper.insertSelective(user);
		String fromDate = DateUtil.DateToStr("yyyy-MM-dd HH:mm", new Date()) ;
		user.setFromDate(fromDate);
		request.getSession().setAttribute("loginUser", user);
		return ResultMap.build(200, "注册成功,即将前往首页");
	}
	@Override
	public List<Loginuser> findAllUser() {
		// TODO Auto-generated method stub
		return loginuserMapper.selectByExample(null);
	}
	@Override
	public Result getUserMessage(Long userid) {
		if (CheckDataUtil.checkisEmpty(userid)) {
			return new Result(false, "登录超时");
		}
		
		Loginuser user = loginuserMapper.selectByPrimaryKey(userid+"");
		String fromDate = DateUtil.DateToStr("yyyy-MM-dd HH:mm", user.getLastgoin()) ;
		user.setFromDate(fromDate);
		if (CheckDataUtil.checkisEmpty(user)) {
			return new Result(false, "登录超时");
		}
		Result result = new  Result(true, "登录成功");
		result.setData(user);
		return result ; 
	}

}
