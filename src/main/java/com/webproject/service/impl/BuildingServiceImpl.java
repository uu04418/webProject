package com.webproject.service.impl;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Building;
import com.webproject.entity.BuildingExample;
import com.webproject.mapper.BuildingMapper;
import com.webproject.myentity.BuildingCustomer;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.myentity.HouseCustomer;
import com.webproject.mymapper.UserCustomerMapper;
import com.webproject.service.BuildingService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.PageQuery;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	BuildingMapper buildingMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	

	@Override
	public Result add(Building building) {
		
		if (CheckDataUtil.checkisEmpty(building.getName())) {
			return new Result(true, "输入楼栋名称");
		}
		boolean isBuilding = checkBuilding(building);
		if (isBuilding) {
			return new Result(true, "该楼栋已经存在");
		}
		
		String id = userCustomerMapper.getNextBuildingId();
		building.setId(id);
		buildingMapper.insertSelective(building);
		return new Result(true, "插入成功");
	}

	private boolean checkBuilding(Building building) {
		BuildingExample example = new BuildingExample();
		BuildingExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(building.getName());
		if (CheckDataUtil.checkNotEmpty(building.getId())) {
			criteria.andIdNotEqualTo(building.getId());
		}
		List<Building> selectByExample = buildingMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(selectByExample)) {
			return false ;
		}
		return true;
	}

	@Override
	public PageResult list(Building search, int page, int rows) {
		int infoCount = userCustomerMapper.buildinglistCount(search);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, rows, page);
		List<BuildingCustomer> buildings = userCustomerMapper.buildinglist(search, pagequery);
		return new PageResult(Long.valueOf(infoCount) ,buildings);
	}

	@Override
	public Building findOne(String id) {
		// TODO Auto-generated method stub
		return buildingMapper.selectByPrimaryKey(id);
	}

	@Override
	public Result update(Building building) {
		// TODO Auto-generated method stub
		buildingMapper.updateByPrimaryKeySelective(building);
		return new Result(true, "编辑成功");
	}

	@Override
	public PageResult searchHouseByBuildingId(String id) {
		List<HouseCustomer> houseCustomers=  userCustomerMapper.searchHouseByBuildingId(id);
		return new PageResult(1L, houseCustomers);
	}

}
