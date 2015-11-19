package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class CheckDiscountCodeRequestVO implements Serializable {

	String coupanCode;
	int merchantbranch_id;
	double total_order_value;
	private long user_id;
	
	
	
	
	

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getCoupanCode() {
		return coupanCode;
	}

	public void setCoupanCode(String coupanCode) {
		this.coupanCode = coupanCode;
	}

	public int getMerchantbranch_id() {
		return merchantbranch_id;
	}

	public void setMerchantbranch_id(int merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}

	public double getTotal_order_value() {
		return total_order_value;
	}

	public void setTotal_order_value(double total_order_value) {
		this.total_order_value = total_order_value;
	}

}
