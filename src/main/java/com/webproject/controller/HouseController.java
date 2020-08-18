package com.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Building;
import com.webproject.entity.House;
import com.webproject.myentity.HouseCustomer;
import com.webproject.service.HouseService;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@Controller
@RequestMapping("/house")
@ResponseBody
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@RequestMapping("/add")
	public Result add(@RequestBody House house) {
		return houseService.add(house);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody House house) {
		return houseService.update(house);
	}
	
	@RequestMapping("/list")
	public PageResult detailList(@RequestBody House house, int page, int rows) {
		return houseService.list(house, page, rows);

	}
	
	@RequestMapping("/findOne")
	public House findOne(String id) {
		return houseService.findOne(id);

	}
}
