
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
import com.hungrybell.app.model.RecommendedTag;
import com.hungrybell.app.model.TrendingTag;
import com.mysql.jdbc.ResultSetMetaData;

@Repository("RecommendedTagDao")
public class RecommendedTagDaoImpl implements RecommendedTagDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void allDeleteRecomTag() {
		RecommendedTag recomtag = new RecommendedTag();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from RecommendedTag");
		query.executeUpdate();

	}

	public void addRecommendedTag(String locationName, String tagName) {
		RecommendedTag recomtag = new RecommendedTag();
		recomtag.setLocation_name(locationName);
		recomtag.setTagName_of_location(tagName);
		sessionFactory.getCurrentSession().save(recomtag);

	}

	public List<RecommendedTag> getAllTagRecom(String locationName) {
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RecommendedTag.class);
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

