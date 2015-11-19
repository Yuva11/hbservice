package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class TagDealsListResponseVOAddToCart implements Serializable {

	private String status = "success";
	private TagListDealsPageVOATC result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TagListDealsPageVOATC getResult() {
		return result;
	}

	public void setResult(TagListDealsPageVOATC result) {
		this.result = result;
	}

}
