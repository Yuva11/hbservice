package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class ChangeLocationRequestVO implements Serializable{
	
	ChangeLocationReqVO body;

	public ChangeLocationReqVO getBody() {
		return body;
	}

	public void setBody(ChangeLocationReqVO body) {
		this.body = body;
	}

	
}
