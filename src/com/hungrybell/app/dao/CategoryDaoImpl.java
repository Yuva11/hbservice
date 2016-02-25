package com.hungrybell.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.model.Category;

@Repository(value="categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	
@Autowired
SessionFactory sessionFactory=null;
	@Override
	public Category getCategory(long categoryId) {
		
	Criteria criteria =sessionFactory.getCurrentSession().createCriteria(Category.class);
	criteria.add(Restrictions.eq("id", categoryId));
	if(criteria.list()!=null)
	{
		return (Category) criteria.uniqueResult();	
	}
	else
	{
		return null;
	}
	}

}
