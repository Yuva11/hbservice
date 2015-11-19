package com.hungrybell.app.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.MerchantBranch;
@Repository("DiscountCouponDao")
public class DiscountCouponDaoImpl implements DiscountCouponDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public DiscountCoupon getCheckDiscountCodeForMerchant(String coupanCode,long merchantbranch_id){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DiscountCoupon.class);
		criteria.add(Restrictions.eq("coupon_code", coupanCode).ignoreCase());
		criteria.add(Restrictions.eq("merchantbranch_id", merchantbranch_id));
		if(!criteria.list().isEmpty()){
			return (DiscountCoupon)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}
	
	public DiscountCoupon getCheckDiscountCode(String coupanCode){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DiscountCoupon.class);
		criteria.add(Restrictions.eq("coupon_code", coupanCode).ignoreCase());
		if(!criteria.list().isEmpty()){
			return (DiscountCoupon)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}


	public DiscountCoupon getCheckDiscountCodeType(String coupanCode){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DiscountCoupon.class);
		criteria.add(Restrictions.eq("coupon_code", coupanCode).ignoreCase());
		if(!criteria.list().isEmpty()){
			return (DiscountCoupon)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}

	public DiscountCoupon getCheckDiscountCodeLimited(String coupanCode){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DiscountCoupon.class);
		criteria.add(Restrictions.eq("coupon_code", coupanCode).ignoreCase());
		if(!criteria.list().isEmpty()){
			return (DiscountCoupon)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}

	public DiscountCoupon getCheckDiscountCodeUnLimited(String coupanCode){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DiscountCoupon.class);
		criteria.add(Restrictions.eq("coupon_code", coupanCode).ignoreCase());
		if(!criteria.list().isEmpty()){
			return (DiscountCoupon)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}

	
	
	
	
	public void increamentUsageValue(long usage,long id) 
	{		
		long usage_increment=usage+1;
		DiscountCoupon orderDetail = new DiscountCoupon();
		System.out.println("usage_increment = "+usage_increment+" id = "+id);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update DiscountCoupon set usages="+usage_increment+" where id='"+id+"'");
		query.executeUpdate();    
	}
	
}
