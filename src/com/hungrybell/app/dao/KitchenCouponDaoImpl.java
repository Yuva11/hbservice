package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.KitchenCoupon;

@Repository("kitchenCouponDao")
public class KitchenCouponDaoImpl implements KitchenCouponDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<KitchenCoupon> getAllMerchantbranch_id_from_kichenCoupon(long  coupan_id) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(KitchenCoupon.class);
			criteria.add(Restrictions.eq("coupon_id", coupan_id));
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception e) {
		}

		return null;
	}
}
