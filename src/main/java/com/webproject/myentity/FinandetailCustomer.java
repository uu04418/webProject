package com.webproject.myentity;

import com.webproject.entity.Finandetail;

public class FinandetailCustomer extends Finandetail {
	
	private String categoryname;
	
	private Long fatherid;
	
	
	private String buildingid ;
	
	
	private  String payexpertname ;
	
	private String buildingname ;
	
	private String housename ;
	
	private Integer type;
	
	


	public String getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid;
	}

	public String getPayexpertname() {
		return payexpertname;
	}

	public void setPayexpertname(String payexpertname) {
		this.payexpertname = payexpertname;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public Long getFatherid() {
		return fatherid;
	}

	public void setFatherid(Long fatherid) {
		this.fatherid = fatherid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	

}
