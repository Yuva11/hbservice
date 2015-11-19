package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;
import com.hungrybell.app.model.DealUserShare;


@Repository("dealUserSharedDao")
public class DealUserSharedDaoImpl implements DealUserSharedDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DealUserShare> getAllDealsFavouriteByUser(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealUserShare.class);
		criteria.add(Restrictions.eq("user_id", userId));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
		
	}

	public DealUserShare saveUserFavourite(Long userId, String dealTag,
			Long dealId) {
		DealUserShare aealUserShare = new DealUserShare();
		aealUserShare.setUser_id(userId);
		aealUserShare.setDeal_id(dealId);
		aealUserShare.setDeal_tag(dealTag);
		sessionFactory.getCurrentSession().save(aealUserShare);
		return aealUserShare;
	}

	
}
