package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealDeliveryType;
import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;


@Repository("dealDeliveryTypeDao")
public class DealDeliveryTypeDaoImpl implements DealDeliveryTypeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DealDeliveryType>  getAllDeliveryTypesForDealIdList(List<Long> dealids) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealDeliveryType.class);
		criteria.add(Restrictions.in("dealid", dealids));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
	}

	public List<DealDeliveryType>  getAllDeliveryTypesForDealIdList(Long dealid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealDeliveryType.class);
		criteria.add(Restrictions.eq("dealid", dealid));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
	}
	

}
