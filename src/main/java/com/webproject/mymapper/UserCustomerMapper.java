package com.webproject.mymapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webproject.entity.Building;
import com.webproject.entity.House;
import com.webproject.entity.Loginuser;
import com.webproject.entity.Montherchartpanel;
import com.webproject.entity.Payexpert;
import com.webproject.myentity.BuildingCustomer;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.myentity.HouseCustomer;
import com.webproject.myentity.PayexpertCustomer;
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

	

	int buildinglistCount(@Param("search")Building search);
	List<BuildingCustomer> buildinglist(@Param("search")Building search,
			@Param("pagequery") PageQuery pagequery);

	int houselistCount(@Param("search")House house);
	List<HouseCustomer> houselist(@Param("search") House house,
			@Param("pagequery") PageQuery pagequery);

	int userlistCount(@Param("search") Loginuser search);
	List<Loginuser> userlist(@Param("search") Loginuser search, 
			@Param("pagequery") PageQuery pagequery);

	Loginuser findOneUser(String id);

	List<HouseCustomer> searchHouseByBuildingId(String id);

	List<Payexpert> getMonthPayexpert(Payexpert payexpert);

	String getLastPayNumber(String houseid);

	int payexportlistCount(@Param("search")Payexpert search);
	List<PayexpertCustomer> payexportlist(@Param("search")Payexpert search, 
			@Param("pagequery") PageQuery pagequery);

	String getNextBuildingId();
	
	String getNextHouseId();
	
	String getNextUserId();
	
	String getNextPayexpertid();
	
	String getNextFinandetailid();
	
	String getNextFinancialid();

	Loginuser getUserByAcctoken(String acctoken);
    
}