package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;


@Repository("dealUserFavouritesDao")
public class DealUserFavouritesDaoImpl implements DealUserFavouritesDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DealUserFavourites> getAllDealsFavouriteByUser(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealUserFavourites.class);
		criteria.add(Restrictions.eq("user_id", userId));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
		
	}

	public DealUserFavourites saveUserFavourite(Long userId, String dealTag,
			Long dealId) {
		DealUserFavourites dealUserFavourites = new DealUserFavourites();
		dealUserFavourites.setUser_id(userId);
		dealUserFavourites.setDeal_id(dealId);
		dealUserFavourites.setDeal_tag(dealTag);
		sessionFactory.getCurrentSession().save(dealUserFavourites);
		return dealUserFavourites;
	}

	
}
