package com.webproject.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.webproject.entity.Financial;
import com.webproject.entity.FinancialExample;
import com.webproject.entity.Finandetail;
import com.webproject.entity.Loginuser;
import com.webproject.mapper.FinancialMapper;
import com.webproject.mapper.FinandetailMapper;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.FinancialService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.DateUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Service
public class FinancialServiceImpl implements FinancialService {
	
	@Autowired
	private FinancialMapper financialMapper;
	@Autowired
	private UserCustomerMapper userCustomerMapper;
	@Autowired
	private FinandetailMapper  finandetailMapper; 
	@Autowired
	private HttpServletRequest request;

	@Override
	public PageResult findPage(Financial financial, int pageNum, int pageSize) {
		FinancialExample example=new FinancialExample();
		FinancialExample.Criteria criteria = example.createCriteria();
		if(CheckDataUtil.checkNotEmpty(financial)){
			if (CheckDataUtil.checkNotEmpty(financial.getType())) {
				criteria.andTypeEqualTo(financial.getType());
			}
			if (CheckDataUtil.checkNotEmpty(financial.getFatherid())) {
				criteria.andFatheridEqualTo(financial.getFatherid());
			}
		}
		criteria.andTypeGreaterThanOrEqualTo(1);
		example.setOrderByClause("type");
		PageHelper.startPage(pageNum, pageSize);
		Page<Financial> page= (Page<Financial>)financialMapper.selectByExample(example);		
		return new PageResult(page.getTotal() ,page.getResult());
	}

	// 添加方法
	public Result add(Financial financial) {
		if (CheckDataUtil.checkisEmpty(financial)
				|| CheckDataUtil.checkisEmpty(financial.getCategoryname())
				|| CheckDataUtil.checkisEmpty(financial.getFatherid())
				|| CheckDataUtil.checkisEmpty(financial.getType()))
			return new Result(false, "输入必须的数据");
		String financialid = userCustomerMapper.getNextFinancialid();
		financial.setFinancialid(financialid);
		financialMapper.insertSelective(financial);
		return new Result(false, "插入成功");
	}

	@Override
	public Financial findOne(String id) {
		return financialMapper.selectByPrimaryKey(id);
	}

	@Override
	public Result update(Financial financial) {
		// TODO Auto-generated method stub
		financialMapper.updateByPrimaryKeySelective(financial);
		return new Result(true, "编辑成功");
	}

	@Override
	public PageResult detailList(FinandetailCustomer search, int page, int rows) {
		int infoCount = userCustomerMapper.SearchFinandetailCount(search);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<FinandetailCustomer> searchFinandetail = userCustomerMapper.SearchFinandetail(search, pagequery);
		return new PageResult(Long.valueOf(infoCount) ,searchFinandetail);
	}

	@Override
	public Result add(Finandetail financial) {
			finandetailMapper.insertSelective(financial);
			return new Result(true, "新增成功");
		
	}
	
	@Override
	public Result update(Finandetail financial) {
			finandetailMapper.updateByPrimaryKeySelective(financial);
			return new Result(true, "编辑成功");
		
	}

	@Override
	public Finandetail oneDetail(String finandetailid) {
		// TODO Auto-generated method stub
		return  finandetailMapper.selectByPrimaryKey(finandetailid);
	}

	@Override
	public Result updateDetailDelete(String[] ids) {
		
		try {
			for (int i = 0;i<ids.length;i++) {
				Finandetail update = new Finandetail();
				update.setFinandetailid(ids[i]);
				update.setState(1);
				finandetailMapper.updateByPrimaryKeySelective(update);
			}
			return new Result(true,"成功");
		} catch (Exception e) {
			return new Result(true,"失败");
		}
	}

	@Override
	public Result deleteDetail(String id) {
		// TODO Auto-generated method stub
		finandetailMapper.deleteByPrimaryKey(id);
		return null;
	}

	@Override
	public List<FinandetailCustomer> searchCharByNeay(Long userid, String dateString) {
		// TODO Auto-generated method stub
		Date date = DateUtil.strToDate(dateString+"01月01日");
		return userCustomerMapper.searchCharByNeay(userid ,date);
	}

	@Override
	public List<FinandetailCustomer> searchCharByNeayAndMonth(Long userid, String year, String month) {
		// TODO Auto-generated method stub
		Date date = DateUtil.strToDate(year+ month+"01日");
		return userCustomerMapper.searchCharByNeayAndMonth(userid ,date);
	}


}
