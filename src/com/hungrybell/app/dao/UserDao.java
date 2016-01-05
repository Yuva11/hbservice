package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.DealOrders;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.User;

public interface UserDao {
	
	public User saveUser(String device_id,String email,String branchId);
	public void addUser(Long id,String first_name,String email,String mobile_number,String address,long cust_id, User user);

	public User getUserByDevice(String deviceId);
	public User getUserByEmail(String email);
	
	public List<User>  loginMerchant(String username,String password);
	
	public List<User> getUser(long user_id);
	public User getUserByCustid(long cust_id) throws Exception;
	
	public User getUserDetails(Long  user_id);
	public void resetPassword(String user_email,String confirm_pass);
	public User checkAdminLoginPanel(String email,String pass);
	
	public List<User> getOperationMangUserDataDetails(long role_id);
	public void updateEmail(long userId,String email);
	public void updateDevice(long userId,String deviceId);
	
	
	


}
