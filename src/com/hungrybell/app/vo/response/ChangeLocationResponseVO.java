package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.List;

public class ChangeLocationResponseVO implements Serializable {

	private String status = "success";

	private List<LocationVO> changeLocation;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LocationVO> getChangeLocation() {
		return changeLocation;
	}

	public void setChangeLocation(List<LocationVO> changeLocation) {
		this.changeLocation = changeLocation;
	}

}
