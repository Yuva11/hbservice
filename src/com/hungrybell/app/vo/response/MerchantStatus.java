package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class MerchantStatus implements Serializable{
	
	String status;
	
	Map merchantdetails;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map getMerchantdetails() {
		return merchantdetails;
	}

	public void setMerchantdetails(Map merchantdetails) {
		this.merchantdetails = merchantdetails;
	}


	
	
	

}
