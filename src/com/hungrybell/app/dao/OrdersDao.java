package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.DealOrders;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.OrderDetail;

public interface OrdersDao 
{
	public void saveOrders(String orderid,long dealid,long quantitiy,float amount,String deal_name,String merchant_name);
	public void saveOrder(String orderid,long dealid,long quantitiy,float amount);
	public List<DealOrders> getOrder(String  order_id);
	public List<DealOrders> getAllOrdersIdForDealName(String   order_id);
	
	
	
}
