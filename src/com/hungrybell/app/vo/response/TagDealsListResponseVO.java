package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class TagDealsListResponseVO implements Serializable{
	private String status="success";
	private TagListDealsPageVO result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TagListDealsPageVO getResult() {
		return result;
	}
	public void setResult(TagListDealsPageVO result) {
		this.result = result;
	}
	
	

}
