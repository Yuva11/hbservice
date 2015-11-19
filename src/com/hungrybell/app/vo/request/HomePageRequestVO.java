package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class HomePageRequestVO implements Serializable{
	
	HomePageReqVO body;

	public HomePageReqVO getBody() {
		return body;
	}

	public void setBody(HomePageReqVO body) {
		this.body = body;
	}

}
