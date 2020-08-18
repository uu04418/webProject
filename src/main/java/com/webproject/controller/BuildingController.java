package com.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Building;
import com.webproject.entity.Financial;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.service.BuildingService;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Controller
@RequestMapping("/building")
@ResponseBody
public class BuildingController {
	
	@Autowired
	BuildingService buildingService; 

	@RequestMapping("/add")
	public Result add(@RequestBody Building building) {
		return buildingService.add(building);

	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody Building building) {
		return buildingService.update(building);

	}
	
	@RequestMapping("/findOne")
	public Building findOne(String id) {
		return buildingService.findOne(id);
	}
	
	@RequestMapping("/list")
	public PageResult detailList(@RequestBody Building search, int page, int rows) {
		return buildingService.list(search, page, rows);

	}
	
	@RequestMapping("/searchHouseByBuildingId")
	public PageResult searchHouseByBuildingId( String id) {
		return buildingService.searchHouseByBuildingId(id);

	}
}
