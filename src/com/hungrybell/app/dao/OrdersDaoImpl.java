package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.DealOrders;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.User;


@Repository("ordersDao")
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrders(String orderid, long dealid, long quantitiy,
			float amount, String deal_name, String merchant_name) {

		DealOrders dealOrder = new DealOrders();
		dealOrder.setOrder_id(orderid);
		dealOrder.setDeal_id(dealid);
		dealOrder.setQuantity(quantitiy);
		dealOrder.setAmount(amount);
		dealOrder.setDeal_name(deal_name);
		dealOrder.setMerchant_name(merchant_name);
		sessionFactory.getCurrentSession().saveOrUpdate(dealOrder);
		// TODO Auto-generated method stub

	}

	public void saveOrder(String orderid, long dealid, long quantitiy,
			float amount) {

		DealOrders dealOrder = new DealOrders();
		dealOrder.setOrder_id(orderid);
		dealOrder.setDeal_id(dealid);
		dealOrder.setQuantity(quantitiy);
		dealOrder.setAmount(amount);
		sessionFactory.getCurrentSession().saveOrUpdate(dealOrder);
		// TODO Auto-generated method stub

	}

	public List<DealOrders> getOrder(String orderid) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(DealOrders.class);
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

	public List<DealOrders> getAllOrdersIdForDealName(String orderid) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(DealOrders.class);
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
	

public int getDealOrderedCount(long dealId)
{
	try {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DealOrders.class);
	    criteria.add(Restrictions.eq("deal_id",dealId));
	    criteria.add(Restrictions.eq("deleted",0));
	    int totalOrderCount=0;
		if (!criteria.list().isEmpty()) {
			List<DealOrders> dealOrders=criteria.list();
			for (DealOrders dealOrder:dealOrders) {
				totalOrderCount+=dealOrder.getQuantity();
			}
			return totalOrderCount;	
		}
	} catch (Exception el) {
		el.printStackTrace();
	}
	return 0;
}



}
