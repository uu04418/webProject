package com.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Building;
import com.webproject.entity.House;
import com.webproject.entity.Loginuser;
import com.webproject.service.UserService;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@RequestMapping(("/user"))
@ResponseBody
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/list")
	public PageResult detailList(@RequestBody Loginuser search, int page, int rows) {
		return userService.list(search, page, rows);
	}
	
	@RequestMapping("/deleteOne")
	public Result deleteOne( String id ) {
		return userService.deleteOne(id);
	}
	
	
	@RequestMapping("/findOne")
	public Loginuser findOne(String id) {
		return userService.findOne(id);
	}
	
	@RequestMapping("/add")
	public Result add(@RequestBody Loginuser user) {
		return userService.add(user);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody Loginuser user) {
		return userService.update(user);
	}

}
