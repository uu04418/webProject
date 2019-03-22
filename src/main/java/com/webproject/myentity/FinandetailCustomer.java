package com.webproject.myentity;

import com.webproject.entity.Finandetail;

public class FinandetailCustomer extends Finandetail {
	
	private String categoryname;
	
	private Long fatherid;
	
	private String formDate;

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
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
