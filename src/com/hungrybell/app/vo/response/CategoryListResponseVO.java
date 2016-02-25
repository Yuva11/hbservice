package com.hungrybell.app.vo.response;

import java.util.List;

import com.hungrybell.app.model.Category;

public class CategoryListResponseVO {
	
	List<Category> categoryList;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	
}
