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
	
	

	public void addFeedback(String order_id, String user_id, String rating,	String feedback, String timestamp) 
	{

		FeedBack feedBack=new FeedBack();
		
		feedBack.setOrder_id(order_id);
		feedBack.setUser_id(user_id);
        feedBack.setRating(rating);
        feedBack.setFeedback(feedback);
       feedBack.setTimestamp(timestamp);
       
       sessionFactory.getCurrentSession().saveOrUpdate(feedBack);
	
	}



	
	
	

	

}
