package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;

public interface DealUserFavouritesDao {

	public List<DealUserFavourites> getAllDealsFavouriteByUser(Long userId);
	public DealUserFavourites saveUserFavourite(Long userId,String dealTag,Long dealId);

}
