package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.KitchenCoupon;

public interface KitchenCouponDao {
	
	public List<KitchenCoupon> getAllMerchantbranch_id_from_kichenCoupon(long  coupan_id);
	

}
