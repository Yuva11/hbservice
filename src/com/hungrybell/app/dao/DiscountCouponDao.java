package com.hungrybell.app.dao;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DiscountCoupon;

public interface DiscountCouponDao {
	
	public DiscountCoupon getCheckDiscountCodeForMerchant(String  coupanCode,long merchantbranch_id);
	public void increamentUsageValue(long usage,long id);
	public DiscountCoupon getCheckDiscountCode(String  coupanCode);
	public DiscountCoupon getCheckDiscountCodeType(String  coupanCode);
	public DiscountCoupon getCheckDiscountCodeLimited(String  coupanCode);
	public DiscountCoupon getCheckDiscountCodeUnLimited(String  coupanCode);
	
	
	

	
	
	
	

}
