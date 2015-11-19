package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.TrendingTag;

public interface TrendingTagDao 
{
	public void addTrendingTag(String LlocationName,String TagName);
	public void allDeleteTrendingTag();
	public List<TrendingTag> getAllTag(String locationName);
	

}
