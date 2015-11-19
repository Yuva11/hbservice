package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.OrderDetail;

@Repository("merchantDao")
public class MerchantDaoImpl implements MerchantDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Merchant getMerchantDetailForMerchantId(Long merchantId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Merchant.class);
		criteria.add(Restrictions.eq("id", merchantId));
		criteria.add(Restrictions.isNotNull("name"));
		Object obj = criteria.uniqueResult();
		if (obj != null) {
			return (Merchant) obj;
		} else
			return null;

	}

	/*
	 * public List<Merchant> getMerchantIdsForLocationId(Long locationId) {
	 * Criteria criteria =
	 * sessionFactory.getCurrentSession().createCriteria(Merchant.class);
	 * criteria.add(Restrictions.eq("location_id", locationId));
	 * if(!criteria.list().isEmpty()&&criteria.list().size()>0){ return
	 * criteria.list(); }else{ return null; } }
	 * 
	 * 
	 * public List<Merchant> getMerchantBranchIdsForLocationId(Long locationId)
	 * { Criteria criteria =
	 * sessionFactory.getCurrentSession().createCriteria(Merchant.class);
	 * criteria.add(Restrictions.eq("category_id", locationId));
	 * if(!criteria.list().isEmpty()&&criteria.list().size()>0){ return
	 * criteria.list(); }else{ return null; } }
	 */
	
	
}
