package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.model.User;

public interface NewOrderDetailsDao 
{
	public List<NewOrderDetails> merchantOrders(Long merchantBranchId);
	public List<NewOrderDetails> myOrders(Long user_id);
	
    public NewOrderDetails getCheckDiscountCodeForUser(String  coupanCode,long user_id);

    public List<NewOrderDetails> getIniciatedTxnidID();
    
    
    public NewOrderDetails getUserIdFormNeworderDetails(String order_id_ship);
    
    public List<NewOrderDetails> getAllOrdersId(String userid);
    
    public List<NewOrderDetails> getUserOrderCount(long user_id);
	public NewOrderDetails getLastOrderAddress(Long userId);
    
    
    

	
	
}
