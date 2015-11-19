package com.hungrybell.app.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DeliveryType;


@Repository("deliveryTypeDao")
public class DeliveryTypeDaoImpl implements DeliveryTypeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	public DeliveryType getDeliveryTypeForDeliveryTypeId(Long delId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DeliveryType.class);
		criteria.add(Restrictions.eq("id", delId));
		Object object =criteria.uniqueResult();
		if(object != null){
			
			return (DeliveryType)object;
		}
		return null; 
	}

	public DeliveryType getDeliveryTypeForDeliveryTypeId2(Long delId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DeliveryType.class);
		criteria.add(Restrictions.eq("id", delId));
		Object object =criteria.uniqueResult();
		if(object != null){
			
			return (DeliveryType)object;
		}
		return null; 
	}

	

}
