package com.hungrybell.app.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealUserLike;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.RepeatDiscount;

@Repository("repeatDiscountDao")
public class RepeatDiscountDaoImpl implements RepeatDiscountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public RepeatDiscount getRepeatDiscount(int orderNumber) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RepeatDiscount.class);
		criteria.add(Restrictions.eq("order_number", orderNumber));
		//criteria.add(Restrictions.eq("id", dealId));
		if (!criteria.list().isEmpty()) {
			return (RepeatDiscount) criteria.uniqueResult();
		} else {
			return null;
		}
}
	
	public boolean getCheckExistsUser(int orderNumber) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RepeatDiscount.class);
		criteria.add(Restrictions.eq("order_number", orderNumber));
		if (!criteria.list().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
}
