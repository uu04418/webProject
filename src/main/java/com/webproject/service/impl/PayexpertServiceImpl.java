package com.webproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Payexpert;
import com.webproject.mapper.PayexpertMapper;
import com.webproject.myentity.HouseCustomer;
import com.webproject.myentity.PayexpertCustomer;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.PayexpertService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Service
public class PayexpertServiceImpl implements PayexpertService{
	
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	PayexpertMapper payexpertMapper;

	public Result add(Payexpert payexpert) {
		if (CheckDataUtil.checkisEmpty(payexpert.getRealmonery())) {
			return new Result(false, "输入实收");
		}
		if(CheckDataUtil.checkisEmpty(payexpert.getStart_time()) 
				|| CheckDataUtil.checkisEmpty(payexpert.getEnd_time())) {
			return new Result(false, "输入租约日期");
		}
		if (CheckDataUtil.checkisEmpty(payexpert.getHouseid())) {
			return new Result(false, "选择房间");
		}
		
		List<Payexpert> payexperts = userCustomerMapper.getMonthPayexpert(payexpert);
		
		if (CheckDataUtil.checkNotEmpty(payexperts)) {
			return new Result(false, "本月租约已经存在");
		}
		
		String payexpertid = userCustomerMapper.getNextPayexpertid();
		
		// 获取最大的分期编号
		String lastNumber = userCustomerMapper.getLastPayNumber(payexpert.getHouseid());
		lastNumber = IDUtils.formatLastNumber(lastNumber);
		payexpert.setPayexpertname(lastNumber);
		payexpert.setPayexpertid(payexpertid);
		payexpertMapper.insertSelective(payexpert);
		return new Result(false, "创建成功");
	}

	@Override
	public PageResult list(Payexpert search, int page, int rows) {
		int infoCount = userCustomerMapper.payexportlistCount(search);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<PayexpertCustomer> buildings = userCustomerMapper.payexportlist(search, pagequery);
		return new PageResult(Long.valueOf(infoCount) ,buildings);
	}

	@Override
	public Result deleteOne(String id) {
		// TODO Auto-generated method stub
		payexpertMapper.deleteByPrimaryKey(id);
		return new Result(true, "删除成功");
	}

}
