package com.hungrybell.app.vo.request;

public class SearchPageReqVOACT {
	
	String latitude;
	String longitude;
	Long merchantbranch_id;
	String user_id;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    public Long getMerchantbranch_id() {
		return merchantbranch_id;
	}
	public void setMerchantbranch_id(Long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	


}
