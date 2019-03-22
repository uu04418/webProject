package com.webproject.util;

import java.util.List;

public class PageResult {
	
	private static final long serialVersionUID = -2597677752658737714L;


	private long total;
	
	
	private List rows;
	

	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	

	public PageResult() {
		super();
	}



	public long getTotal() {
		return total;
	}



	public void setTotal(long total) {
		this.total = total;
	}



	public List getRows() {
		return rows;
	}



	public void setRows(List rows) {
		this.rows = rows;
	}
	
	


}
