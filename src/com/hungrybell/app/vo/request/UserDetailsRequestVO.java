package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class UserDetailsRequestVO implements Serializable{

	String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
