package com.webproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Building;
import com.webproject.entity.House;
import com.webproject.entity.HouseExample;
import com.webproject.mapper.HouseMapper;
import com.webproject.myentity.HouseCustomer;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.HouseService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	

	@Override
	public Result add(House house) {
		if (CheckDataUtil.checkisEmpty(house.getBuildingid())) {
			return new Result(false, "选择楼栋");
		}
		if (CheckDataUtil.checkisEmpty(house.getName())) {
			return new Result(false, "选择房号");
		}
		boolean isHouseNumber = checkNumber(house);
		if (isHouseNumber) {
			return new Result(false, "房号重复");
		}
		houseMapper.insertSelective(house);
		return new Result(false, "添加成功");
	}


	private boolean checkNumber(House house) {
		HouseExample example = new HouseExample();
		HouseExample.Criteria criteria = example.createCriteria();
		criteria.andBuildingidEqualTo(house.getBuildingid());
		criteria.andNameEqualTo(house.getName());
		if (CheckDataUtil.checkNotEmpty(house.getHouseid())) {
			criteria.andHouseidNotEqualTo(house.getHouseid()) ;
		}
		
		List<House> selectByExample = houseMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(selectByExample)) {
			return false ;
		}
		return true ;
	}


	@Override
	public PageResult list(House house, int page, int rows) {
		int infoCount = userCustomerMapper.houselistCount(house);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<HouseCustomer> buildings = userCustomerMapper.houselist(house, pagequery);
		return new PageResult(Long.valueOf(infoCount) ,buildings);
	}


	@Override
	public House findOne(String id) {
		
		return houseMapper.selectByPrimaryKey(id);
		
	}


	@Override
	public Result update(House house) {
		if (CheckDataUtil.checkisEmpty(house.getBuildingid())) {
			return new Result(false, "选择楼栋");
		}
		if (CheckDataUtil.checkisEmpty(house.getName())) {
			return new Result(false, "选择房号");
		}
		boolean isHouseNumber = checkNumber(house);
		if (isHouseNumber) {
			return new Result(false, "房号重复");
		}
		
		houseMapper.updateByPrimaryKeySelective(house);
		
		return new Result(true, "更新成功");	}

}
