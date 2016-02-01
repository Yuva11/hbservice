package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.FeedBack;


@Repository("FeedBackDao")
public class FeedBackDaoImpl implements FeedBackDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void addFeedback(String order_id, String user_id, String rating1,
			String rating2, String rating3,
			String rating4,String feedback) 
	{

		FeedBack feedBack=new FeedBack();
		feedBack.setOrder_id(order_id);
		feedBack.setUser_id(user_id);
		feedBack.setRating1(rating1);
		feedBack.setFeedback(feedback);
		feedBack.setRating2(rating2);
		feedBack.setRating3(rating3);
		feedBack.setRating4(rating4);
		sessionFactory.getCurrentSession().saveOrUpdate(feedBack);

	}


}
