package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.FeedBack;
import com.hungrybell.app.vo.request.PayUmoneyBean;

public interface FeedBackDao {
	

	public void addFeedback(String order_id,String user_id,String rating,String feedback,String timestamp) ;



}
