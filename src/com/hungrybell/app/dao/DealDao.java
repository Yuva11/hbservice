package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.NewOrderDetails;

public interface DealDao {

	public List<Deal> getAllDealsForBranchIds(List<Long> locationIds);
	public List<Deal> getAllDealsForBranchIdsRecommended(List<Long> locationIds);
	
	public List<Deal> getNearestAllDealsForBranchIds(List<Long> locationIds);
	public List<Deal> getAllDealsForLocation(List<Long> locationIds);
	public List<Deal> getAllDealsForBranchIdsAndTag(List<Long> branchIds,String tagName);
	public List<Deal> getAllDealsForBranchIdsAndSearchString(List<Long> branchIds,String searchString);
	public List<Deal> getAllRecommendedDealsForLocation(List<Long> locationIds);
	public Deal getDealForDealId(Long dealId);
	public Deal updateDealUserActionForDealId(Long dealId,String action);
	public List<Deal> getNearestAllDealsForBranchIdsAndTag(
			List<Long> branchIds, String tagName);
	public List<Deal> getAllDeals();
	
	public List<Deal> getAllDealsForBranchIdsAndTagAddToCart(Long branchIds);
	
	public Deal getMerchantBranchForDealAddTocart(List<Long> dealid);
	
	
	public List<Deal> getMerchantBranchIdsForDealIdAddToCart(Long dealid);
	
	public List<Deal> getAllDealsForLocation2();
	
	public List<Deal> getDealName(Long deal_id);
	
	

	public void editMerchantPrice(String merchant_id, String deal_id,String deal_price);
	
	public List<Deal> getAllTagForUser(Long deal_id);
	
	
	



	
	
	

}
