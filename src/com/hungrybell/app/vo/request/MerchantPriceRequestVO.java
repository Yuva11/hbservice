package com.hungrybell.app.vo.request;

public class MerchantPriceRequestVO {
	
	String merchant_id;
	String deal_id;
	String deal_price;
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}
	public String getDeal_price() {
		return deal_price;
	}
	public void setDeal_price(String deal_price) {
		this.deal_price = deal_price;
	}
	
	

}
