package com.hungrybell.app.vo.request;

import javax.persistence.Column;

public class CustomerVO {

	private CutomerActionReqVO body;

	private Long user_id;
	
	
	
	
    public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


public CutomerActionReqVO getBody() {
		return body;
	}

	public void setBody(CutomerActionReqVO body) {
		this.body = body;
	}

	

}
