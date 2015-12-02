package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class FavTagVo implements Serializable{
	String deal_id;
	String tag_name;
	
	public String getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	
	

}
