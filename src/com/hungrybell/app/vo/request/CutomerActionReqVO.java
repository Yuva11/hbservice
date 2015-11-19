package com.hungrybell.app.vo.request;

import java.sql.Timestamp;

public class CutomerActionReqVO {

	private Long id;
	private String first_name;
	private String username_email;
	private String mobile_number;
	private String address;
	private long user_id;
	private Double longitude;
	private Double latitude;
	private String landmark;
	private String order_type;
	private Long order_quantity;
	private Double order_amount;
	private Long deal_id;
	private String delivery_status;
	private String status;
	private Long cust_id;

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public Long getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Long order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}

	public Long getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Long deal_id) {
		this.deal_id = deal_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getUsername_email() {
		return username_email;
	}

	public void setUsername_email(String username_email) {
		this.username_email = username_email;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
