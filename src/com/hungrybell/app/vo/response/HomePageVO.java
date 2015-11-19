package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.List;

public class HomePageVO implements Serializable {
	
	private String total_food_items="10";
	private String location="Bangalore";
	private List<TagVO> trending;
	private List<TagVO> recomended;
	private List<TagVO> favourites;
	
	public String getTotal_food_items() {
		return total_food_items;
	}
	public void setTotal_food_items(String total_food_items) {
		this.total_food_items = total_food_items;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<TagVO> getTrending() {
		return trending;
	}
	public void setTrending(List<TagVO> trending) {
		this.trending = trending;
	}
	public List<TagVO> getRecomended() {
		return recomended;
	}
	public void setRecomended(List<TagVO> recomended) {
		this.recomended = recomended;
	}
	public List<TagVO> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<TagVO> favourites) {
		this.favourites = favourites;
	}
	

}
