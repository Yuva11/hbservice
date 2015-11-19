package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealDeliveryType;
import com.hungrybell.app.model.DealUserLike;

public interface DealDeliveryTypeDao {

	public List<DealDeliveryType>  getAllDeliveryTypesForDealIdList(List<Long> dealids);
	public List<DealDeliveryType>  getAllDeliveryTypesForDealIdList(Long dealid);

}
