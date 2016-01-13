package com.hungrybell.app.dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.FeedBack;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.Setting;
import com.hungrybell.app.model.User;
import com.hungrybell.app.vo.request.Orders;

@Repository("NewOrderDetailsDao")
public class NewOrderDetailsDaoImpl implements NewOrderDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<NewOrderDetails> merchantOrders(Long merchantBranchId)
	
	{
		GetDateFromSystem getDateFromSystem=new GetDateFromSystem();
		
	                Calendar startDate = Calendar.getInstance();
	                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
				     startDate.set(Calendar.HOUR_OF_DAY, 0);
	                startDate.set(Calendar.MINUTE, 0);
	                startDate.set(Calendar.SECOND, 0);
	                startDate.add(Calendar.DATE, -7);
	                String lastWeak=dateFormat.format(startDate.getTime());
				    
	           
					
					
					System.out.println("Date 1= "+ lastWeak);
					
					Calendar today=Calendar.getInstance();
					today.add(Calendar.DATE, 0);
					 today.set(Calendar.HOUR_OF_DAY, 23);
	                today.set(Calendar.MINUTE, 59);
	                today.set(Calendar.SECOND, 59);
	                String enddate=dateFormat.format(today.getTime());
				
					System.out.println("Date 2= "+enddate);
	    try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
			criteria.add(Restrictions.eq("merchantbranch_id", merchantBranchId));
		    criteria.add(Restrictions.between("order_date_time", lastWeak, enddate+""));
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return null;

	}
	
	
	public NewOrderDetails getCheckDiscountCodeForUser(String coupanCode,long user_id){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
		criteria.add(Restrictions.eq("coupan_code", coupanCode).ignoreCase());
		criteria.add(Restrictions.eq("user_id", user_id));
		criteria.add(Restrictions.eq("order_status","Confirmed"));
		if(!criteria.list().isEmpty()){
			return (NewOrderDetails)criteria.list().get(0);
		}else{
			return null;	
		}
		}
		catch(Exception ek)
		{
			ek.printStackTrace();
			
		}
		return null;
	}
	
	
	
public List<NewOrderDetails> myOrders(Long user_id)
{
		   try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
			criteria.add(Restrictions.eq("user_id", user_id));
			criteria.addOrder(org.hibernate.criterion.Order.desc("order_date_time"));
		    criteria.setMaxResults(7);
		    
		    if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return null;

	}

public List<NewOrderDetails> getIniciatedTxnidID()
{
	try {
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();

        Calendar yesterdayMidnight = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	     yesterdayMidnight.set(Calendar.HOUR_OF_DAY, 0);
        yesterdayMidnight.set(Calendar.MINUTE, 0);
        yesterdayMidnight.set(Calendar.SECOND, 0);
        String startTime=dateFormat.format(yesterdayMidnight.getTime());
		Calendar todayMidnight=Calendar.getInstance();
	    todayMidnight.set(Calendar.HOUR_OF_DAY, 23);
        todayMidnight.set(Calendar.MINUTE, 59);
        todayMidnight.set(Calendar.SECOND, 59);
        String endTime=dateFormat.format(todayMidnight.getTime());
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
	    criteria.add(Restrictions.between("order_date_time", startTime, endTime+""));
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	} catch (Exception el) {
	}
	return null;
}

public NewOrderDetails getUserIdFormNeworderDetails(String order_id_ship){
	try
	{
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
	criteria.add(Restrictions.eq("delivery_ship_id", order_id_ship));
	if(!criteria.list().isEmpty()){
		return (NewOrderDetails)criteria.list().get(0);
	}else{
		return null;	
	}
	}
	catch(Exception ek)
	{
		ek.printStackTrace();
		
	}
	return null;
}
	

public List<NewOrderDetails> getAllOrdersId(String user_id)
{
	try {
	
		Long user_id1=Long.parseLong(user_id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
	    criteria.add(Restrictions.eq("user_id",user_id1));
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	} catch (Exception el) {
	}
	return null;
}


public List<NewOrderDetails> getUserOrderCount(long user_id)
{
	try {
	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewOrderDetails.class);
	    criteria.add(Restrictions.eq("user_id",user_id));
	    criteria.add(Restrictions.eq("order_status","Confirmed"));
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	} catch (Exception el) {
	}
	return null;
}

	public NewOrderDetails getLastOrderAddress(Long userId) {
		List <NewOrderDetails> orders=myOrders(userId);
		if(orders!=null && orders.size()>0)
			return orders.get(orders.size()-1);
		return null;
	}	
}
