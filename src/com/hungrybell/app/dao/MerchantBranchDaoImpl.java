package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.User;

@Repository("merchantBranchDao")
public class MerchantBranchDaoImpl implements MerchantBranchDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<MerchantBranch> getMerchantBranchIdsForLocationId(Long locationId) {
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
		criteria.add(Restrictions.eq("location_id", locationId));
		//criteria.add(Restrictions.eq("status", "ACTIVE"));
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
		}catch(Exception ek)
		{
			ek.printStackTrace();
		}
		return null;
		
	}
	
	public MerchantBranch getMerchantDetailForMerchantBranchId(Long merchantBranchId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
		criteria.add(Restrictions.eq("id", merchantBranchId));
			Object obj=criteria.uniqueResult();
			if(obj != null){
				return (MerchantBranch)obj;
			}
				else
					return null;
				
			}
		
	public List<MerchantBranch> getMerchantBranchForNearestLocationList() {
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
		//criteria.add(Restrictions.eq("status", "ACTIVE"));
		
		if(!criteria.list().isEmpty()){
			return criteria.list();
		}else{
			return null;	
		}
		}catch(Exception e)
		{
			
		}return null;
	}
	
	public MerchantBranch getAllMerchantBranch(Long merchantbranch_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
		criteria.add(Restrictions.eq("id", merchantbranch_id));
		Object obj=criteria.uniqueResult();
		if(obj != null ){
			return (MerchantBranch)obj;
		}
			else
				return null;
			
		}
	
	public List<MerchantBranch> getMerchantName(Long merchantbranchid) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(MerchantBranch.class);
			criteria.add(Restrictions.eq("id", merchantbranchid));
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
	
	
	public void editMerchantPassword(String username,String newPassword) 
	{
		try
		{
			
		
	    MerchantBranch orderDetail = new MerchantBranch();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update MerchantBranch set m_password='" +newPassword+ "' where e_mail='" + username
				+ "'");
		query.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    
	}
	
	public List<MerchantBranch> loginMerchant(String username, String password) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
			criteria.add(Restrictions.eq("e_mail", username));
			criteria.add(Restrictions.eq("m_password", password));
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
	
	public MerchantBranch getCheckDiscountCodeForMerchant(String merchantbranch_id){
		try
		{
		long merchanrbranchid=Long.parseLong(merchantbranch_id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MerchantBranch.class);
		criteria.add(Restrictions.eq("id", merchanrbranchid));
		if(!criteria.list().isEmpty()){
			return (MerchantBranch)criteria.list().get(0);
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


}
