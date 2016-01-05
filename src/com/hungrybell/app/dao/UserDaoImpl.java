package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealOrders;
import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User saveUser(String device_id, String email,String branchId) {
		User user = new User();
		user.setDelete_status(0);
		user.setDevice_id(device_id);
		user.setEmail(email);
		user.setBranch_id(branchId);
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	public User checkUser(String device_id, String email) {
		if (device_id == null) {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			Object obj = criteria.uniqueResult();
			if (obj != null) {
				return (User) obj;
			} else
				return null;

		} else {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("device_id", device_id));
			Object obj = criteria.uniqueResult();
			if (obj != null) {
				return (User) obj;
			} else
				return null;

		}
	}

	//Get user by deviceId
	public User getUserByDevice(String deviceId) {
		if (deviceId != null && !deviceId.isEmpty()) {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("device_id", deviceId));
			Object obj = criteria.uniqueResult();
			return (User) obj;			
		}
		return null;
	}
	
	//Get user by email
	public User getUserByEmail(String email) {
		if (email != null && !email.isEmpty()) {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			List userList=criteria.list();
			if(userList.size()>0){
				Object obj = userList.get(0);
				return (User) obj;		
			}
		}
		return null;
	}


	// Add user/

	public void addUser(Long id, String first_name, String email,
			String mobile_number, String address, long cust_id, User user) {
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();

		try {
			if (user != null) {
				System.out.println(cust_id);
				user.setEmail(email);
				user.setUsername("" + getDateFromSystem.getDateFromSystem());
				user.setFirst_name(first_name);
				user.setMobile_number(mobile_number);
				System.out.println("kkkkkkkkkkkkk");
				sessionFactory.getCurrentSession().saveOrUpdate(user);
				System.out.println("kkkkkkkkkkkkk");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return customer;
	}

	public List<User> getUser(long user_id) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", user_id));
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
	
	
	
	
	
	
	

	public User getUserByCustid(long custId) {
		User user = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", custId));
			if (!criteria.list().isEmpty()) {
				user = (User) criteria.list().get(0);
			}
		} catch (Exception ek) {
			ek.printStackTrace();
			user = null;
		}
		return user;
	}

	public List<User> loginMerchant(String username, String password) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("first_name", username));
			criteria.add(Restrictions.eq("first_name", password));
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

	public User getUserDetails(Long user_id) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", user_id));
			if (!criteria.list().isEmpty()) {
				return (User) criteria.list().get(0);
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();

		}
		return null;
	}

	/*
	 * public List<User> loginMerchant(String email, String password) {
	 * 
	 * Merchant merchant=new Merchant(); Session session =
	 * sessionFactory.getCurrentSession(); //SQLQuery query =
	 * session.createSQLQuery("");
	 * 
	 * 
	 * Query query = session.createQuery(
	 * "SELECT m.id  FROM group_user gu JOIN users_merchant um ON gu.id=um.user_id JOIN merchant m ON um.merchant_id=m.id WHERE email_id='"
	 * +email+"'"); // MIN_VALUE gives hint to JDBC driver to stream results
	 * query.setFetchSize(Integer.MIN_VALUE); ScrollableResults results =
	 * query.scroll(ScrollMode.FORWARD_ONLY); // iterate over results if
	 * (results.next()) { merchant = (Merchant) results.get(0); // process row
	 * then release reference // you may need to flush() as well
	 * System.out.println("------yy------"+merchant.getName()); }
	 * results.close();
	 * 
	 * return null;
	 * 
	 * }
	 */

	public void resetPassword(String user_email, String confirm_pass) {
		User user = new User();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update User set new_password_hash='"
				+ confirm_pass + "' where username='" + user_email + "'");
		query.executeUpdate();

	}
	public User checkAdminLoginPanel(String email,String pass){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username",email));
		criteria.add(Restrictions.eq("new_password_hash", pass));
		if(!criteria.list().isEmpty()){
			return (User)criteria.list().get(0);
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
	
	public List<User> getOperationMangUserDataDetails(long role_id) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("role_id", role_id));
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
	
	public void updateEmail(long userId,String email) {
		User user = getUserById(userId);
		user.setDelete_status(0);
		user.setEmail(email);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void updateDevice(long userId,String deviceId) {
		User user = getUserById(userId);
		user.setDelete_status(0);
		user.setDevice_id(deviceId);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	
	public User getUserById(long userId) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", userId));
			return (User)criteria.uniqueResult();
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return null;
	}

	

}
