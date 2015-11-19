package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

public class CheckDiscountCodeResponseVO {

	private String status = "failure";

	private String coupon_code;

	private String error;

	private String percentage;

	private String max_value;

	private String start_date;

	private String end_date;

	private String city;

	private long merchantbranch_id;

	private double min_order_value;
	private long usage;
	private long max_usage;
	
	
	
	 


	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getMax_value() {
		return max_value;
	}

	public void setMax_value(String max_value) {
		this.max_value = max_value;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getMerchantbranch_id() {
		return merchantbranch_id;
	}

	public void setMerchantbranch_id(long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}

	public double getMin_order_value() {
		return min_order_value;
	}

	public void setMin_order_value(double min_order_value) {
		this.min_order_value = min_order_value;
	}

	public long getUsage() {
		return usage;
	}

	public void setUsage(long usage) {
		this.usage = usage;
	}

	public long getMax_usage() {
		return max_usage;
	}

	public void setMax_usage(long max_usage) {
		this.max_usage = max_usage;
	}
	
	

}
