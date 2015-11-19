package com.hungrybell.app.vo.request;

public class Orders {
	

    private long amount;

    private Long quantity;

    private Long deal_id;
    
    private String deal_name;
    
    private String  merchant_name;

	
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Long deal_id) {
		this.deal_id = deal_id;
	}

	public String getDeal_name() {
		return deal_name;
	}

	public void setDeal_name(String deal_name) {
		this.deal_name = deal_name;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	
	
	
    
}
