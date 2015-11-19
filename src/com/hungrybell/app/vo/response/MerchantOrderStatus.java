package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MerchantOrderStatus implements Serializable{
	
    String status;
	
	private List<Merchantorderdetails> merchantorderdetails;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Merchantorderdetails> getMerchantorderdetails() {
		return merchantorderdetails;
	}

	public void setMerchantorderdetails(
			List<Merchantorderdetails> merchantorderdetails) {
		this.merchantorderdetails = merchantorderdetails;
	}




	

}
