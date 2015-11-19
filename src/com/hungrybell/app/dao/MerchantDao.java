package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.MerchantBranch;

public interface MerchantDao {
	
	//public List<Merchant> getMerchantIdsForLocationId(Long locationId);
	public Merchant getMerchantDetailForMerchantId(Long merchantBranchId);
	//public List<Merchant> getMerchantBranchIdsForLocationId(Long locationId);


}
