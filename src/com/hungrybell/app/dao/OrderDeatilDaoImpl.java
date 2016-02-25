package com.hungrybell.app.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.OrderDetail;

@Repository("OrderDeatilDao")
public class OrderDeatilDaoImpl implements OrderDeatilDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrderDetail(Double longitude, Double latitude,
			String address, String landmark, String order_type,
			Long order_quantity, Double order_amount, Long deal_id,
			String delivery_status, String status, Long cust_id,
			String mobile_number, String first_name, String orderidcreate,
			Long merchant_branch_id) {
		OrderDetail orderDetail = new OrderDetail();
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
		// System.ot.println();
		orderDetail.setLongitude(longitude);
		orderDetail.setLatitude(latitude);
		orderDetail.setDelivery_address(address);
		orderDetail.setLandmark(landmark);
		orderDetail.setOrder_type(order_type);
		orderDetail.setOrder_quantity(order_quantity);
		orderDetail.setOrder_amount(order_amount);
		orderDetail.setDeal_id(deal_id);
		orderDetail.setOrder_date_time(getDateFromSystem.getDateFromSystem());
		orderDetail.setDelivery_status("NOT DELIVERED");
		orderDetail.setOrder_status("Received");
		orderDetail.setUser_id(cust_id);
		orderDetail.setMerchantbranch_id(merchant_branch_id);
		orderDetail.setOrder_id(orderidcreate);

		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);

	}

	public void addOrderDetailAddTOCart(Double longitude, Double latitude,
			String address, String landmark, String order_type,
			Long order_quantity, Double order_amount, Long deal_id,
			String delivery_status, String status, Long cust_id,
			String mobile_number, String first_name, String orderidcreate,
			Long merchant_branch_id, String discount_method,
			double discount_amount, String coupon_code,String delivery_date,String delivery_time) {
		OrderDetail orderDetail = new OrderDetail();
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
		// System.ot.println();
		orderDetail.setLongitude(longitude);
		orderDetail.setLatitude(latitude);
		orderDetail.setDelivery_address(address);
		orderDetail.setLandmark(landmark);
		orderDetail.setOrder_type(order_type);
		orderDetail.setOrder_quantity(order_quantity);
		orderDetail.setOrder_amount(order_amount);
		orderDetail.setDeal_id(deal_id);
		orderDetail.setDelivery_status("Received");
		orderDetail.setOrder_status("Received");
		orderDetail.setUser_id(cust_id);
		orderDetail.setMerchantbranch_id(merchant_branch_id);
		orderDetail.setOrder_id(orderidcreate);
		orderDetail.setDiscount_method(discount_method);
		orderDetail.setDiscount_amount(discount_amount);
		orderDetail.setCoupan_code(coupon_code);
		orderDetail.setFeedback_received("false");
		orderDetail.setOrder_date_time(getDateFromSystem.getDateFromSystem());
		
		if(delivery_date==null || delivery_date.isEmpty()){
			orderDetail.setDelivery_time(getDateFromSystem.getDateFromSystem());
		}else{
			String dateAndTime = "" + delivery_date +" "+ delivery_time;
			Date date = null;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				date = df.parse(dateAndTime);
				orderDetail.setDelivery_time(date);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
		}
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);

	}

	public void updateFeedback(String order_id) {
		OrderDetail orderDetail = new OrderDetail();
		String i = "true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("update OrderDetail set feedback_received='" + i
						+ "' where order_id='" + order_id + "'");
		query.executeUpdate();

	}

	public OrderDetail getLastOrder(Long user_id) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(OrderDetail.class);
			criteria.add(Restrictions.eq("user_id", user_id));
			//criteria.add(Restrictions.eq("feedback_received", "false"));
			criteria.add(Restrictions.eq("order_status", "Confirmed"));
			criteria.addOrder(org.hibernate.criterion.Order.desc("order_date_time"));
			if (!criteria.list().isEmpty()) {
				return (OrderDetail) criteria.list().get(0);
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();

		}
		return null;
	}

	public List<OrderDetail> sendTeamSmsEmailOrder(String orderid) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(OrderDetail.class);
			criteria.add(Restrictions.eq("order_id", orderid));
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

	public void updateDeliveryTracking(String shipment_id,
			String townrush_shipment_id, String status, String name,
			String mobileno) {
		NewOrderDetails orderDetail = new NewOrderDetails();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("update NewOrderDetails set delivery_status='"
						+ status + "',delivery_boy_name='" + name
						+ "',delivery_boy_mob_no='" + mobileno
						+ "' where order_id='" + shipment_id + "'");
		query.executeUpdate();

	}
	
	
	public void updateDeliveryTrackingRaodRunnr(String order_id,String status,String driver_name,String driver_number) {
		NewOrderDetails orderDetail = new NewOrderDetails();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update NewOrderDetails set delivery_status='"+ status + "',delivery_boy_name='"+driver_name+"',delivery_boy_mob_no='"+driver_number+"' where delivery_ship_id='" + order_id + "'");
		query.executeUpdate();

	}
	
	/*
	 * public OrderDetail sendTeamSmsEmail(String orderid) { Criteria criteria =
	 * sessionFactory.getCurrentSession().createCriteria(OrderDetail.class);
	 * criteria.add(Restrictions.eq("order_id", orderid)); return (OrderDetail)
	 * criteria.uniqueResult();
	 * 
	 * }
	 */

}
