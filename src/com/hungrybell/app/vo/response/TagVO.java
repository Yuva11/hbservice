package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class TagVO implements Serializable {
	String tag_id;
	String tag_name;
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

}
