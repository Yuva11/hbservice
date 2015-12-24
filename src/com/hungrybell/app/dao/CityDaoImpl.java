package com.hungrybell.app.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.City;
import com.hungrybell.app.model.DiscountCoupon;

@Repository("cityDao")
public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public long getCityId(String cityName) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(City.class);
			criteria.add(Restrictions.eq("name", cityName));
			if (!criteria.list().isEmpty()) {
				City city = (City) criteria.list().get(0);
				return city.getId();
			}
		} catch (Exception ek) {
			ek.printStackTrace();

		}
		return 0;
	}

}
