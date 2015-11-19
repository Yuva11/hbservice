package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class SearchPagePageRequestVO implements Serializable{
	
	SearchPageReqVO body;

	public SearchPageReqVO getBody() {
		return body;
	}

	public void setBody(SearchPageReqVO body) {
		this.body = body;
	}

}
