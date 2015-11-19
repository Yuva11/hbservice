package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class DealUserActionRequestVO implements Serializable {
	
	private DealActionReqVO body;

	public DealActionReqVO getBody() {
		return body;
	}

	public void setBody(DealActionReqVO body) {
		this.body = body;
	}

}
