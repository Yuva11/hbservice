package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.List;

public class TagListDealsPageVO implements Serializable {
	
	private String total_food_items="10";
	private List<DealVO> deals;
	
	
	
	
	
	public List<DealVO> getDeals() {
		return deals;
	}
	public void setDeals(List<DealVO> deals) {
		this.deals = deals;
	}
	
	
	public String getTotal_food_items() {
		return total_food_items;
	}
	public void setTotal_food_items(String total_food_items) {
		this.total_food_items = total_food_items;
	}
	
	
	
	

}
