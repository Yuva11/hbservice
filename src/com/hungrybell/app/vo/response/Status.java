package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class Status implements Serializable{
	private int code;
	private String message;
	private String orderid;
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	

}
