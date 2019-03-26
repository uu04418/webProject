package com.webproject.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webproject.entity.Financial;
import com.webproject.entity.Finandetail;
import com.webproject.entity.Loginuser;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.service.FinancialService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

@RestController
@RequestMapping("/financial")
public class FinancialController {
	
	@Autowired
	private FinancialService financialService;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/belogin/searchList")
	public PageResult searchList(int page ,int rows ,@RequestBody Financial financial) {
		return financialService.findPage(financial, page, rows);
		
	}
	
	
	@RequestMapping("/belogin/add")
	public Result add(@RequestBody Financial financial) {
		return financialService.add(financial);
		
	}
	
	
	@RequestMapping("/belogin/deleteDetail")
	public Result deleteDetail(Long id) {
		return financialService.deleteDetail(id);
		
	}
	
	
	@RequestMapping("/belogin/findOne")
	public Financial findOne(Long id) {
		return financialService.findOne(id);
		
	}
	
	@RequestMapping("/belogin/update")
	public Result update( @RequestBody Financial financial) {
		return financialService.update(financial);
		
	}
	
	
	@RequestMapping("/belogin/detailList")
	public PageResult detailList( @RequestBody FinandetailCustomer search 
			,int page ,int rows ) {
		
		return financialService.detailList(search , page ,rows);
		
	}
	
	@RequestMapping("/belogin/addDetail")
	public Result add(@RequestBody Finandetail financial) {
		if (CheckDataUtil.checkNotEmpty(financial)) {
			if(CheckDataUtil.checkisEmpty(financial.getState())) {
				financial.setState(1);
			}
		}
		return financialService.add(financial);
		
	}
	
	@RequestMapping("/belogin/updateDetail")
	public Result updateDetail(@RequestBody Finandetail financial) {
		if (CheckDataUtil.checkNotEmpty(financial)) {
			if(CheckDataUtil.checkisEmpty(financial.getState())) {
				financial.setState(1);
			}
		}
		return financialService.update(financial);
		
	}
	
	
	@RequestMapping("/belogin/oneDetail")
	public Finandetail oneDetail(Long id  ) {
		return financialService.oneDetail(id);
		
	}
	
	
	@RequestMapping("/belogin/updateDetailDelete")
	public Result updateDetailDelete( Long [] ids  ) {
		return financialService.updateDetailDelete(ids);
		
	}
	
	
	@RequestMapping("/belogin/searchCharByNeay")
	public List<FinandetailCustomer> searchCharByNeay( Long userid , String dateString  ) {
		return financialService.searchCharByNeay(userid,dateString);
		
	}
	
	
	
	
	
	
	

}
