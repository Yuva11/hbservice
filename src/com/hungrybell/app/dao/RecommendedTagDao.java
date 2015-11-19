package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.RecommendedTag;
import com.hungrybell.app.model.TrendingTag;

public interface RecommendedTagDao 

{
	public void addRecommendedTag(String LlocationName,String TagName);
	public void allDeleteRecomTag();
	public List<RecommendedTag> getAllTagRecom(String locationName);

}
