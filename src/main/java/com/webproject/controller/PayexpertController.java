package com.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Building;
import com.webproject.entity.House;
import com.webproject.entity.Payexpert;
import com.webproject.service.PayexpertService;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@RequestMapping("/payexpert")
@ResponseBody
@Controller
public class PayexpertController {
	
	@Autowired
	PayexpertService payexpertService;
	
	@RequestMapping("/add")
	public Result add(@RequestBody Payexpert payexpert) {
		return payexpertService.add(payexpert);
	}
	
	@RequestMapping("/deleteOne")
	public Result deleteOne( String id ) {
		return payexpertService.deleteOne(id);
	}
	
	@RequestMapping("/list")
	public PageResult detailList(@RequestBody Payexpert search, int page, int rows) {
		return payexpertService.list(search, page, rows);

	}

}
