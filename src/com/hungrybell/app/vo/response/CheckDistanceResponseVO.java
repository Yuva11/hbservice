package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class CheckDistanceResponseVO implements Serializable {
	private String status;

	private String[] destination_addresses;

	private String[] origin_addresses;

	private Rows[] rows;
	private String deliveryCharge;
	private int free_delivery_minimum_order_value;
	private String type;
	private String value;
	private String message;
	private Double maximumDiscountValue;
	private Double minimumOrderValue;
	private String userName;
	private String userMob;
	private String userEmail;
	
	
	
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getFree_delivery_minimum_order_value() {
		return free_delivery_minimum_order_value;
	}

	public void setFree_delivery_minimum_order_value(
			int free_delivery_minimum_order_value) {
		this.free_delivery_minimum_order_value = free_delivery_minimum_order_value;
	}

	public Double getMinimumOrderValue() {
		return minimumOrderValue;
	}

	public void setMinimumOrderValue(Double minimumOrderValue) {
		this.minimumOrderValue = minimumOrderValue;
	}

	public Double getMaximumDiscountValue() {
		return maximumDiscountValue;
	}

	public void setMaximumDiscountValue(Double maximumDiscountValue) {
		this.maximumDiscountValue = maximumDiscountValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getDestination_addresses() {
		return destination_addresses;
	}

	public void setDestination_addresses(String[] destination_addresses) {
		this.destination_addresses = destination_addresses;
	}

	public String[] getOrigin_addresses() {
		return origin_addresses;
	}

	public void setOrigin_addresses(String[] origin_addresses) {
		this.origin_addresses = origin_addresses;
	}

	public Rows[] getRows() {
		return rows;
	}

	public void setRows(Rows[] rows) {
		this.rows = rows;
	}

	public String getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "ClassPojo [status = " + status + ", destination_addresses = "
				+ destination_addresses + ", origin_addresses = "
				+ origin_addresses + ", rows = " + rows + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
