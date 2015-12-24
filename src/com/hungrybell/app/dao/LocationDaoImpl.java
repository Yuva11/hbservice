package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Location;

@Repository("locationDao")
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Location getLocation(String locationName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Location.class);
		criteria.add(Restrictions.eq("name", locationName));
		if (!criteria.list().isEmpty()) {
			return (Location) criteria.list().get(0);
		} else {
			return null;
		}
	}

	public List<Location> getChangeLocationList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Location.class);
		if (!criteria.list().isEmpty()) {
			return criteria.list();
		} else {
			return null;
		}
	}

	public Location getAllLocationList(Long locationid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Location.class);
		criteria.add(Restrictions.eq("id", locationid));
		Object obj = criteria.uniqueResult();
		if (obj != null) {
			return (Location) obj;
		} else
			return null;

	}

	public List<Location> getAllLocationLists() {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Location.class);
			if (!criteria.list().isEmpty() && criteria.list().size() > 0) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();

		}
		return null;
	}

	public void saveNewLocation(Double latitude, Double longitude,
			String locationName, long cityId) {
		Location location = new Location();
		location.setLatitude(""+latitude);
		location.setLongitude(""+longitude);
		location.setName(locationName);
		location.setCity_id(cityId);
		location.setUser(1L);
		sessionFactory.getCurrentSession().saveOrUpdate(location);
	}
	
	public boolean locationExists(long cityId, String location_name1){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Location.class);
		criteria.add(Restrictions.eq("city_id", cityId));
		criteria.add(Restrictions.eq("name", location_name1));
		Object obj = criteria.uniqueResult();
		if (obj != null) {
			return true;
		} else
			return false;
	}

}
