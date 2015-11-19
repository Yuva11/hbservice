package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealUserLike;
import com.hungrybell.app.model.DealUserView;

public interface DealUserViewDao {

	public List<DealUserView> getAllDealsViewedByUser(Long userId);
	public DealUserView saveUserView(Long userId,String dealTag,Long dealId);

}
