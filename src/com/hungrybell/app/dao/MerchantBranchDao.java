package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.User;

public interface MerchantBranchDao {

	public List<MerchantBranch> getMerchantBranchIdsForLocationId(Long locationId);
	public MerchantBranch getMerchantDetailForMerchantBranchId(Long merchantBranchId);
	public List<MerchantBranch> getMerchantBranchForNearestLocationList();
	public MerchantBranch	getAllMerchantBranch(Long merchantbranchid);
	
	public  List<MerchantBranch>	getMerchantName(Long merchantbranchid);

	public  void editMerchantPassword(String username,String newPassword);

	public List<MerchantBranch>  loginMerchant(String username,String password);
	
	public  MerchantBranch	getCheckDiscountCodeForMerchant(String merchantbranchid);
	
	
	
	
	
}
