package com.webproject.service.impl;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jfinal.upload.UploadFile;
import com.webproject.entity.Loginuser;
import com.webproject.entity.Montherchartpanel;
import com.webproject.entity.MontherchartpanelExample;
import com.webproject.entity.Mychartpanel;
import com.webproject.entity.MychartpanelExample;
import com.webproject.mapper.MontherchartpanelMapper;
import com.webproject.mapper.MychartpanelMapper;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.ChartPanelService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.DateUtil;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.UploadUtil;

@Service
public class ChartPanelServiceImpl implements ChartPanelService{
	
	@Autowired
	private MychartpanelMapper mychartpanelMapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MontherchartpanelMapper montherchartpanelMapper;
	@Autowired
	private UserCustomerMapper userCustomerMapper;

	@Override
	public void createMyChartPanel(Long userid, String returnPath ,String yearString) {
		
		MychartpanelExample example = new MychartpanelExample();
		MychartpanelExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andYearstringEqualTo(yearString);
		List<Mychartpanel> list = mychartpanelMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list)) {
			// 这里做更新操作
			Mychartpanel mychartpanel = list.get(0);
			
			/// 删除原始图片
			String olrName = mychartpanel.getCharturl();
			UploadUtil.deleteimage(olrName);
			
			mychartpanel.setCharturl(returnPath);
			mychartpanel.setUpdatetime(new Date());
			mychartpanelMapper.updateByPrimaryKeySelective(mychartpanel);
		} else {
			Mychartpanel mychartpanel = new Mychartpanel();
			mychartpanel.setCharturl(returnPath);
			mychartpanel.setUserid(userid);
			mychartpanel.setYearstring(yearString);
			mychartpanel.setUpdatetime(new Date());
			mychartpanelMapper.insertSelective(mychartpanel);
			
		}
		
	}

	@Override
	public PageResult charList(Mychartpanel search, int page, int rows) {
		MychartpanelExample example=new MychartpanelExample();
		MychartpanelExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(search.getUserid());
		example.setOrderByClause("updatetime desc");
		PageHelper.startPage(page, rows);
		Page<Mychartpanel> result= (Page<Mychartpanel>)mychartpanelMapper.selectByExample(example);		
		List<Mychartpanel> list =  result.getResult();
		for (Mychartpanel panel : list) {
			String fromDate = DateUtil.DateToStr("yyyy-MM-dd HH:mm", panel.getUpdatetime()) ;
			panel.setFromDate(fromDate);
		}
		
		return new PageResult(result.getTotal() ,result.getResult());
	}

	@Override
	public void createMyMonthPanel(Long userid, String returnPath, String year, String month) {
		MontherchartpanelExample example = new MontherchartpanelExample();
		MontherchartpanelExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andMonthEqualTo(month);
		criteria.andYearEqualTo(year);
		List<Montherchartpanel> list = montherchartpanelMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list)) {
			// 这里做更新操作
			Montherchartpanel mychartpanel = list.get(0);
			
			String orname = mychartpanel.getPanelurl();
			/// 删除七牛云图片
			UploadUtil.deleteimage(orname);
			
			mychartpanel.setPanelurl(returnPath);
			mychartpanel.setUpdatetime(new Date());
			montherchartpanelMapper.updateByPrimaryKeySelective(mychartpanel);
		} else {
			Montherchartpanel mychartpanel = new Montherchartpanel();
			mychartpanel.setPanelurl(returnPath);
			mychartpanel.setMonth(month);
			mychartpanel.setYear(year);
			mychartpanel.setUserid(userid);
			mychartpanel.setUpdatetime(new Date());
			montherchartpanelMapper.insertSelective(mychartpanel);
			
		}
		
	}

	@Override
	public PageResult monthChartlist(Montherchartpanel search, int page, int rows) {
		int infoCount = userCustomerMapper.monthChartlistCount(search.getUserid());
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<Montherchartpanel> list = userCustomerMapper.monthChartlist(search.getUserid() , pagequery  );
		
		if (CheckDataUtil.checkNotEmpty(list)) {
			for (Montherchartpanel month : list) {
				String fromDate = DateUtil.DateToStr("yyyy-MM-dd HH:mm", month.getUpdatetime()) ;
				month.setFromDate(fromDate);
			}
		}
		return new PageResult( Long.valueOf(infoCount) ,list);
	}

	

}
