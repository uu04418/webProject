package com.webproject.mymapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webproject.entity.Loginuser;
import com.webproject.entity.Montherchartpanel;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.util.PageQuery;

public interface UserCustomerMapper {
	
	Loginuser searchUserByUserNameOrTelephone(String username);
	
	List<FinandetailCustomer> SearchFinandetail( @Param("search") FinandetailCustomer search ,
			 @Param("pagequery")	PageQuery pagequery);
	
	int SearchFinandetailCount(@Param("search") FinandetailCustomer search );

	Loginuser checkUser(@Param("userid")String userid,
			@Param("username")String username, @Param("telephone") String telephone);

	List<FinandetailCustomer> searchCharByNeay(@Param("userid")Long userid,
			@Param ("date")Date date);

	List<FinandetailCustomer> searchCharByNeayAndMonth( @Param("userid") Long userid, 
			@Param ("date") 	Date date);

	List<Montherchartpanel> monthChartlist(@Param("userid")Long userid, 
			@Param("pagequery")PageQuery pagequery);

	int monthChartlistCount(@Param ("userid")Long userid);

	String getNextUserId();
    
}