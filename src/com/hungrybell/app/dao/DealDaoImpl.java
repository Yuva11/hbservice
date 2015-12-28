package com.hungrybell.app.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.NewOrderDetails;

@Repository("dealDao")
public class DealDaoImpl implements DealDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Deal> getAllDealsForBranchIds(List<Long> branchIds) {
		// trending
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", branchIds));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
			criteria.add(Restrictions.isNotNull("tag"));

			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return null;
	}
	public List<Deal> getAllDealsForBranchIdsRecommended(List<Long> branchIds) {
		// trending
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", branchIds));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
			criteria.add(Restrictions.eq("can_buy", "YES").ignoreCase());
			criteria.add(Restrictions.eq("recommended", "YES").ignoreCase());
			criteria.add(Restrictions.isNotNull("tag"));
		

			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return null;
	}
	

	Deal deal = new Deal();

	// count home page data
	public List<Deal> getAllDealsForLocation(List<Long> locationIds) {
		try {
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", locationIds));
			criteria.add(Restrictions.isNotNull("tag"));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));

			// criteria.add(Restrictions.le("end_date",getDateFromSystem.getDateFromSystem()));
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception el) {

		}
		return null;
	}

	public List<Deal> getAllDealsForLocation2() {
		try {
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.isNotNull("tag"));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));

			// criteria.add(Restrictions.le("end_date",getDateFromSystem.getDateFromSystem()));
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception el) {

		}
		return null;
	}

	// recommeded
	public List<Deal> getAllRecommendedDealsForLocation(List<Long> locationIds) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", locationIds));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
			criteria.add(Restrictions.eq("can_buy", "YES").ignoreCase());
			criteria.add(Restrictions.eq("recommended", "YES").ignoreCase());
			criteria.setMaxResults(12);
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

	// tagListapi(http://testservice.hungrybells.in:9091/HBAppService//tagListDealsjson.do)
	public List<Deal> getAllDealsForBranchIdsAndTag(List<Long> branchIds,
			String tagName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Deal.class);
		criteria.add(Restrictions.in("merchantbranch_id", branchIds));
		criteria.add(Restrictions.isNotNull("tag"));
		criteria.add(Restrictions.eq("status", "PUBLISHED"));
		criteria.add(Restrictions.like("tag", tagName, MatchMode.ANYWHERE));
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	}

	public List<Deal> getAllDealsForBranchIdsAndTagAddToCart(Long branchIds) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.eq("merchantbranch_id", branchIds));
			criteria.add(Restrictions.isNotNull("tag"));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
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

	// search
	// api(http://testservice.hungrybells.in:9091/HBAppService//searchjson.do)
	public List<Deal> getAllDealsForBranchIdsAndSearchString(List<Long> branchIds, String searchString) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Deal.class);
		criteria.add(Restrictions.in("merchantbranch_id", branchIds));
		criteria.add(Restrictions.isNotNull("tag"));
		criteria.add(Restrictions.eq("status", "PUBLISHED"));
		// search for some string value like pizza, biryani
		String searchString1 = searchString.trim();
		Criterion crit1 = null;
		Criterion crit2 = null;
		Criterion crit3 = null;
		Criterion crit4 = null;
		if (null != searchString1) {
			crit1 = Restrictions.like("name", searchString1, MatchMode.ANYWHERE);
			crit2 = Restrictions.like("detail_text", searchString1,MatchMode.ANYWHERE);
			crit3 = Restrictions.like("tag", searchString1, MatchMode.ANYWHERE);
			crit4 = Restrictions.like("details", searchString1,MatchMode.ANYWHERE);
		}
		criteria.add(Restrictions.or(crit1, crit2, crit3, crit4));
		// Return all foods(Show all) from deal list
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	}
	
	public List<Deal> getAllDealsForBranchIdsAndMultipleSearchString(List<Long> branchIds, String searchString) {
		boolean temp=false;
		if(searchString!=null && !searchString.isEmpty())
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Deal.class);
		criteria.add(Restrictions.in("merchantbranch_id", branchIds));
		criteria.add(Restrictions.isNotNull("tag"));
		criteria.add(Restrictions.eq("status", "PUBLISHED"));
		// search for some string value like pizza, biryani
		//String searchString1 = searchString.trim();
		Criterion crit1 = null;
		Criterion crit2 = null;
		Criterion crit3 = null;
		Criterion crit4 = null;
		String[] dealNames=searchString.split(",");
		for (int i=0;i<dealNames.length;i++) {
			dealNames[i]=dealNames[i].trim();
		}
		if (searchString!=null){
			crit1 = Restrictions.in("name", dealNames);
			crit2 = Restrictions.in("detail_text", dealNames);
			crit3 = Restrictions.in("tag", dealNames);
			crit4 = Restrictions.in("details", dealNames);
		}
		criteria.add(Restrictions.or(crit1, crit2, crit3, crit4));
		// Return all foods(Show all) from deal list
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(Deal.class);
			criteria1.add(Restrictions.in("merchantbranch_id", branchIds));
			criteria1.add(Restrictions.isNotNull("tag"));
			criteria1.add(Restrictions.eq("status", "PUBLISHED"));
			// search for some string value like pizza, biryani
			String searchString1 = searchString.trim();
			Criterion crit5 = null;
			Criterion crit6 = null;
			Criterion crit7 = null;
			Criterion crit8 = null;
			if (null != searchString1) {
				crit5 = Restrictions.like("name", searchString1, MatchMode.ANYWHERE);
				crit6 = Restrictions.like("detail_text", searchString1,MatchMode.ANYWHERE);
				crit7 = Restrictions.like("tag", searchString1, MatchMode.ANYWHERE);
				crit8 = Restrictions.like("details", searchString1,MatchMode.ANYWHERE);
			}
			criteria1.add(Restrictions.or(crit5, crit6, crit7, crit8));
			// Return all foods(Show all) from deal list
			if (!criteria1.list().isEmpty()) {
				return criteria1.list();
			} else {
				return null;
			}
		}
		} else
		{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", branchIds));
			criteria.add(Restrictions.isNotNull("tag"));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
			// search for some string value like pizza, biryani
			String searchString1 = searchString.trim();
			Criterion crit1 = null;
			Criterion crit2 = null;
			Criterion crit3 = null;
			Criterion crit4 = null;
			if (null != searchString1) {
				crit1 = Restrictions.like("name", searchString1, MatchMode.ANYWHERE);
				crit2 = Restrictions.like("detail_text", searchString1,MatchMode.ANYWHERE);
				crit3 = Restrictions.like("tag", searchString1, MatchMode.ANYWHERE);
				crit4 = Restrictions.like("details", searchString1,MatchMode.ANYWHERE);
			}
			criteria.add(Restrictions.or(crit1, crit2, crit3, crit4));
			// Return all foods(Show all) from deal list
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		}
	}

	public List<Deal> getNearestAllDealsForBranchIdsAndTag(
			List<Long> branchIds, String tagName) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Deal.class);
			criteria.add(Restrictions.in("merchantbranch_id", branchIds));
			criteria.add(Restrictions.isNotNull("tag"));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
			criteria.add(Restrictions.like("tag", tagName.trim(), MatchMode.ANYWHERE));
			if (!criteria.list().isEmpty() && criteria.list().size() > 0) {
				return criteria.list();
			} else 
			{
				return null;
			}
		} catch (Exception ek) {

		}
		return null;
	}

	public List<Deal> getNearestAllDealsForBranchIds(List<Long> branchIds) // trending
																			// logic
	{
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Deal.class);
		criteria.add(Restrictions.in("merchantbranch_id", branchIds));
		criteria.add(Restrictions.isNotNull("tag"));
		criteria.add(Restrictions.eq("status", "PUBLISHED"));
		criteria.setMaxResults(12);
		// criteria.add(Restrictions.le("end_date",getDateFromSystem.getDateFromSystem()));
		if (!criteria.list().isEmpty() && criteria.list().size() > 0) {
			return criteria.list();
		} else {
			return null;
		}
	}

	public Deal getDealForDealId(Long dealId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Deal.class);
		criteria.add(Restrictions.eq("id", dealId));
		return (Deal) criteria.uniqueResult();

	}

	public Deal getMerchantBranchForDealAddTocart(List<Long> dealId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Deal.class);
		criteria.add(Restrictions.eq("id", dealId));
		if (!criteria.list().isEmpty()) {
			return (Deal) criteria.list().get(0);
		} else {
			return null;
		}
	}

	public List<Deal> getAllDeals() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Deal.class);
		criteria.add(Restrictions.isNotNull("tag"));
	    criteria.add(Restrictions.eq("status", "PUBLISHED"));
		if (!criteria.list().isEmpty() && criteria.list().size() > 0) {
			return criteria.list();
		} else {
			return null;
		}
	}

	public Deal updateDealUserActionForDealId(Long dealId, String action) {
		Deal deal = getDealForDealId(dealId);
		if (action.equalsIgnoreCase("view")) {
			deal.setDealview_count(deal.getDealview_count() + 1);
		}
		if (action.equalsIgnoreCase("like")) {
			deal.setDeallike_count(deal.getDeallike_count() + 1);
		}
		if (action.equalsIgnoreCase("share")) {
			deal.setDealshare_count(deal.getDealshare_count() + 1);
		}
		sessionFactory.getCurrentSession().save(deal);
		return deal;

	}

	public List<Deal> getMerchantBranchIdsForDealIdAddToCart(Long dealid) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.eq("location_id", dealid));
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
	
	public List<Deal> getDealName(Long deal_id) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.eq("id", deal_id));
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
	public List<Deal> getAllTagForUser(Long deal_id) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Deal.class);
			criteria.add(Restrictions.eq("id", deal_id));
			criteria.add(Restrictions.eq("status", "PUBLISHED"));
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
	
	
	
	public void editMerchantPrice(String merchant_id, String deal_id,String deal_price) 
	{
		double dealprice=Double.parseDouble(deal_price);
		long id=Long.parseLong(deal_id);
		Deal orderDetail = new Deal();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Deal set deal_price='" +dealprice+ "' where id='" + id + "'");
		query.executeUpdate();

    
	}
	
	
	
}
