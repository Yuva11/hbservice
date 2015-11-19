package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealUserFavourites;
import com.hungrybell.app.model.DealUserLike;
import com.hungrybell.app.model.DealUserView;

@Repository("dealUserViewDao")
public class DealUserViewDaoImpl implements DealUserViewDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DealUserView> getAllDealsViewedByUser(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealUserView.class);
		criteria.add(Restrictions.eq("user_id", userId));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
	}

	public DealUserView saveUserView(Long userId,String dealTag,Long dealId) {
		DealUserView dealUserView = new DealUserView();
		dealUserView.setUser_id(userId);
		dealUserView.setDeal_id(dealId);
		dealUserView.setDeal_tag(dealTag);
		sessionFactory.getCurrentSession().save(dealUserView);
		return dealUserView;
	}

}
