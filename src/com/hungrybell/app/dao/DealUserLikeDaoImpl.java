package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;


@Repository("dealUserLikeDao")
public class DealUserLikeDaoImpl implements DealUserLikeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DealUserLike> getAllDealsLikedByUser(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealUserLike.class);
		criteria.add(Restrictions.eq("user_id", userId));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
	}

	public DealUserLike saveUserLike(Long userId, String dealTag, Long dealId) {
		DealUserLike dealUserLike = new DealUserLike();
		dealUserLike.setUser_id(userId);
		dealUserLike.setDeal_id(dealId);
		dealUserLike.setDeal_tag(dealTag);
		sessionFactory.getCurrentSession().save(dealUserLike);
		return dealUserLike;
	}

}
