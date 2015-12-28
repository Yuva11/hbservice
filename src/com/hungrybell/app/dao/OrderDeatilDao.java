
package com.hungrybell.app.dao;

import java.sql.Timestamp;
import java.util.List;

import com.hungrybell.app.model.FeedBack;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.User;




public interface OrderDeatilDao {
	
	public void addOrderDetail(Double longitude,Double  latitude,String address,String landmark,String order_type,Long order_quantity,Double order_amount,Long deal_id,String delivery_status,String status,Long cust_id,String mobile_number,String first_name,String orderidcreate,Long merchant_branch_id);
	public void addOrderDetailAddTOCart(Double longitude,Double  latitude,String address,String landmark,String order_type,Long order_quantity,Double order_amount,Long deal_id,String delivery_status,String status,Long cust_id,String mobile_number,String first_name,String orderidcreate,Long merchant_branch_id,String discount_method,double discount_amount,String coupon_code);

	
	public void updateFeedback(String order_id);
	public OrderDetail getLastOrder(Long user_id) ;
	public List<OrderDetail> sendTeamSmsEmailOrder(String order_id);
	
	public void updateDeliveryTracking(String shipment_id,String townrush_shipment_id,String status,String name,String mobileno);
	
	
	public void updateDeliveryTrackingRaodRunnr(String order_id,String status,String driver_name,String driver_number);
	
	
	/*
	public List<Customer> listEmployeess();
	
	public Customer getEmployee(int empid);
	
	public List<Customer> getEmployeeByName(String empName);
	
	public void deleteEmployee(Customer employee);
*/
}

