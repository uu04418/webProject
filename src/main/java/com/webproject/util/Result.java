package com.webproject.util;

import java.util.List;

public class Result {

	private boolean success;

	private String message;
	
	private Object data;
	
	


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
