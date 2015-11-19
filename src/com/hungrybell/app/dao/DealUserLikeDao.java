package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealUserLike;

public interface DealUserLikeDao {

	public List<DealUserLike> getAllDealsLikedByUser(Long userId);
	public DealUserLike saveUserLike(Long userId,String dealTag,Long dealId);

}
