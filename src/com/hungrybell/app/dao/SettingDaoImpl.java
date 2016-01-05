package com.hungrybell.app.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Roles;
import com.hungrybell.app.model.Setting;

@Repository("SettingDao")
public class SettingDaoImpl implements SettingDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Setting getDeails() {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Setting.class);
			if (!criteria.list().isEmpty()) {
				return (Setting) criteria.list().get(0);
			} else {
				return null;
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return null;
	}

}
