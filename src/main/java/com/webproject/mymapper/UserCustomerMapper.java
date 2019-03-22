package com.webproject.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webproject.entity.Loginuser;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.util.PageQuery;

public interface UserCustomerMapper {
	
	Loginuser searchUserByUserNameOrTelephone(String username);
	
	List<FinandetailCustomer> SearchFinandetail( @Param("search") FinandetailCustomer search ,
			 @Param("pagequery")	PageQuery pagequery);
	
	int SearchFinandetailCount(@Param("search") FinandetailCustomer search );
    
}