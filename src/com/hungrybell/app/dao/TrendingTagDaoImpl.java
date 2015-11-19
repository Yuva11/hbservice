package com.hungrybell.app.dao;

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
import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.TrendingTag;
import com.mysql.jdbc.ResultSetMetaData;

@Repository("TrendingTagDao")
public class TrendingTagDaoImpl implements TrendingTagDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void allDeleteTrendingTag() {
		TrendingTag tendingtag = new TrendingTag();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from TrendingTag");
		query.executeUpdate();

	}

	public void addTrendingTag(String locationName, String tagName) {
		TrendingTag tendingtag = new TrendingTag();
		tendingtag.setLocation_name(locationName);
		tendingtag.setTagName_of_location(tagName);
		sessionFactory.getCurrentSession().save(tendingtag);

	}

	public List<TrendingTag> getAllTag(String locationName) {
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				TrendingTag.class);
		criteria.add(Restrictions.eq("location_name", locationName));
        criteria.setMaxResults(12);
        

		if (!criteria.list().isEmpty() && criteria.list().size() > 0) {
			return criteria.list();
		} else {
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
