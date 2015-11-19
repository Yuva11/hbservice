package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;
import com.hungrybell.app.model.DealUserShare;

public interface DealUserSharedDao {

	public List<DealUserShare> getAllDealsFavouriteByUser(Long userId);
	public DealUserShare saveUserFavourite(Long userId,String dealTag,Long dealId);

}
