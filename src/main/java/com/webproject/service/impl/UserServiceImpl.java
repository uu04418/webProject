package com.webproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfinal.log.Log;
import com.webproject.entity.Loginuser;
import com.webproject.entity.LoginuserExample;
import com.webproject.mapper.LoginuserMapper;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.UserService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	LoginuserMapper loginuserMapper;

	@Override
	public PageResult list(Loginuser search, int page, int rows) {
		int infoCount = userCustomerMapper.userlistCount(search);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<Loginuser> buildings = userCustomerMapper.userlist(search, pagequery);
		return new PageResult(Long.valueOf(infoCount) ,buildings);
	}

	@Override
	public Loginuser findOne(String id) {
		// TODO Auto-generated method stub
		return userCustomerMapper.findOneUser(id);
	}

	public Result add(Loginuser user) {
		if (CheckDataUtil.checkisEmpty(user.getTelephone())
				|| CheckDataUtil.checkisEmpty(user.getPassword())) {
			return new Result(false, "输入电话号码/密码");
		} 
		//校验电话号码
		boolean isPhone = checkPhone(user);
		if (isPhone) {
			return new Result(false, "电话号码重复添加");
		}
		
		String lastUserid = userCustomerMapper.getNextUserId();
		user.setAvatar("http://www.genealogy.zzw777.com/155325446644464.png");
		user.setLastgoin(new Date());
		user.setUserid(lastUserid);
		user.setRegistime(new Date());
		user.setAcctoken(IDUtils.geneAcctoken());
		user.setPassword(IDUtils.getprivatePassword(user.getPassword()));
		user.setState(0);
		loginuserMapper.insertSelective(user);
		return new Result(true, "添加成功");
	}

	private boolean checkPhone(Loginuser user) {
		LoginuserExample example = new LoginuserExample();
		LoginuserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(user.getTelephone());
		if (CheckDataUtil.checkNotEmpty(user.getUserid())) {
			criteria.andUseridNotEqualTo(user.getUserid());
		}
		List<Loginuser> selectByExample = loginuserMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(selectByExample)) {
			return false ;
		}
		return true;
	}

	@Override
	public Result update(Loginuser user) {
		if (CheckDataUtil.checkisEmpty(user.getTelephone())) {
			return new Result(false, "输入电话号码");
		} 
		//校验电话号码
		boolean isPhone = checkPhone(user);
		if (isPhone) {
			return new Result(false, "电话号码重复添加");
		}
		
		if (CheckDataUtil.checkisEmpty(user.getPassword())) {
			user.setPassword(null);
		} else {
			user.setPassword(IDUtils.getprivatePassword(user.getPassword()));
		}
		
		user.setAcctoken(IDUtils.geneAcctoken());
		loginuserMapper.updateByPrimaryKeySelective(user);
		return new Result(true, "编辑成功");
	}

	@Override
	public Result deleteOne(String id) {
		loginuserMapper.deleteByPrimaryKey(id);
		return new Result(true, "删除成功");
	}

	@Override
	public Loginuser getUserByAcctoken(String acctoken) {
		if (CheckDataUtil.checkisEmpty(acctoken))
			return null ;
		return userCustomerMapper.getUserByAcctoken(acctoken);
	}

}
