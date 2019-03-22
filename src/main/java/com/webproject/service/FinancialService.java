package com.webproject.service;

import com.webproject.entity.Financial;
import com.webproject.entity.Finandetail;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

public interface FinancialService {
	
	public PageResult findPage(Financial financial, int pageNum, int pageSize) ;

	public Result add(Financial financial);

	public Financial findOne(Long id);

	public Result update(Financial financial);

	public PageResult detailList(FinandetailCustomer search, int page, int rows);

	public Result add(Finandetail financial);

	public Result update(Finandetail financial);

}
