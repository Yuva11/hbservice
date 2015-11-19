package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Roles;
import com.hungrybell.app.model.User;

@Repository("rolesDao")
public class RolesDaoImpl implements RolesDao {
	@Autowired
	private SessionFactory sessionFactory;

	
	public Roles getOperationMangUserData(){
		try
		{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Roles.class);
		criteria.add(Restrictions.eq("rolename", "Operations Management"));
			if(!criteria.list().isEmpty()){
			return (Roles)criteria.list().get(0);
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
