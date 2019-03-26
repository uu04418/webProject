package com.webproject.myentity;

public class CharModel {
	
	private String month ;
	
	private String type ;
	
	private double total;

	
	
	
	public CharModel(String month, String type, double total) {
		super();
		this.month = month;
		this.type = type;
		this.total = total;
	}

	public CharModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
