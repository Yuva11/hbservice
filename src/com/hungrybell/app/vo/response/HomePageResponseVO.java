package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class HomePageResponseVO implements Serializable{
	private String status="success";
	private HomePageVO result;
	private Long user_id;
	private String device_id;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public HomePageVO getResult() {
		return result;
	}
	public void setResult(HomePageVO result) {
		this.result = result;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	} 
	
	
	

}
