package com.webproject.myentity;

import com.webproject.entity.Payexpert;

public class PayexpertCustomer extends Payexpert{
	
	private String housename; 
	
	private String buildingname;

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	
	

}
