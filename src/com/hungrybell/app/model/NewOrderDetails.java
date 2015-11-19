package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="neworderdetails")

public class NewOrderDetails implements Serializable{
	
	@Id
	private Long id;

	
	@Column(name="delivery_address")
	private String delivery_address;

	@Column(name="landmark")
	private String landmark;

	@Column(name="order_type")
	private String order_type;

	@Column(name="order_quantity")
	private long order_quantity;

	@Column(name="order_amount")
	private double order_amount;

	@Column(name="deal_id")
	private long deal_id;

	@Column(name="order_date_time")
	private String order_date_time;

	@Column(name="delivery_status")
	private String delivery_status;

	@Column(name="order_status")
	private String order_status;

	@Column(name="user_id")
	private long user_id;

	@Column(name="merchantbranch_id")
	private long merchantbranch_id;

	@Column(name="order_id")
	private String order_id;

	@Column(name="discount_method")
	private String discount_method;

	@Column(name="discount_amount")
	private double discount_amount;

	@Column(name="coupan_code")
	private String coupan_code;

	@Column(name="delivery_ship_id")
	private String delivery_ship_id;
	
	
	@Column(name="delivery_agent_name")
	private String delivery_agent_name;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "latitude")
	private Double latitude;
	
	
	@Column(name="delivery_boy_name")
	private String delivery_boy_name;
	
	@Column(name="delivery_boy_mob_no")
	private String delivery_boy_mob_no;
	
	
	
	
	
	public String getDelivery_boy_name() {
		return delivery_boy_name;
	}


	public void setDelivery_boy_name(String delivery_boy_name) {
		this.delivery_boy_name = delivery_boy_name;
	}


	public String getDelivery_boy_mob_no() {
		return delivery_boy_mob_no;
	}


	public void setDelivery_boy_mob_no(String delivery_boy_mob_no) {
		this.delivery_boy_mob_no = delivery_boy_mob_no;
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDelivery_address() {
		return delivery_address;
	}


	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
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


	public long getOrder_quantity() {
		return order_quantity;
	}


	public void setOrder_quantity(long order_quantity) {
		this.order_quantity = order_quantity;
	}


	public double getOrder_amount() {
		return order_amount;
	}


	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}


	public long getDeal_id() {
		return deal_id;
	}


	public void setDeal_id(long deal_id) {
		this.deal_id = deal_id;
	}


	public String getOrder_date_time() {
		return order_date_time;
	}


	public void setOrder_date_time(String order_date_time) {
		this.order_date_time = order_date_time;
	}


	public String getDelivery_status() {
		return delivery_status;
	}


	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}


	public String getOrder_status() {
		return order_status;
	}


	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public long getMerchantbranch_id() {
		return merchantbranch_id;
	}


	public void setMerchantbranch_id(long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getDiscount_method() {
		return discount_method;
	}


	public void setDiscount_method(String discount_method) {
		this.discount_method = discount_method;
	}


	public double getDiscount_amount() {
		return discount_amount;
	}


	public void setDiscount_amount(double discount_amount) {
		this.discount_amount = discount_amount;
	}


	public String getCoupan_code() {
		return coupan_code;
	}


	public void setCoupan_code(String coupan_code) {
		this.coupan_code = coupan_code;
	}


	public String getDelivery_ship_id() {
		return delivery_ship_id;
	}


	public void setDelivery_ship_id(String delivery_ship_id) {
		this.delivery_ship_id = delivery_ship_id;
	}


	public String getDelivery_agent_name() {
		return delivery_agent_name;
	}


	public void setDelivery_agent_name(String delivery_agent_name) {
		this.delivery_agent_name = delivery_agent_name;
	}
	
	
	
	
	


}
