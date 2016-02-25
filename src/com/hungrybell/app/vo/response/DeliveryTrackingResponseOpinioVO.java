package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class DeliveryTrackingResponseOpinioVO implements Serializable {

	
	private String pilot_name;
	private String pilot_phone;
	private String pilot_latitude;
	private String pilot_longitude;
	private String state;
	private String order_code;
	private String time;
	public String getPilot_name() {
		return pilot_name;
	}
	public void setPilot_name(String pilot_name) {
		this.pilot_name = pilot_name;
	}
	public String getPilot_phone() {
		return pilot_phone;
	}
	public void setPilot_phone(String pilot_phone) {
		this.pilot_phone = pilot_phone;
	}
	public String getPilot_latitude() {
		return pilot_latitude;
	}
	public void setPilot_latitude(String pilot_latitude) {
		this.pilot_latitude = pilot_latitude;
	}
	public String getPilot_longitude() {
		return pilot_longitude;
	}
	public void setPilot_longitude(String pilot_longitude) {
		this.pilot_longitude = pilot_longitude;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


}
