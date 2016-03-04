package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Category;

public interface CategoryDao {
	public Category getCategory(long categoryId);
	
	public Category getCategoryId(String categoryName);
	
	
}
