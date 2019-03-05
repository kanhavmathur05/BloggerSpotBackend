package com.collaborationproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.collaborationproject.dao.UserDetailsDAO;
import com.collaborationproject.model.UserDetails;

@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertOrUpdateUserDetails(UserDetails userDetails) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public UserDetails getUserDetails(String userName) {
		UserDetails userDetails;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("userName", userName));
			userDetails=(UserDetails) cr.uniqueResult();
			return userDetails;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public UserDetails getUserDetailsByEmail(String email) {
		UserDetails userDetails;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("email", email));
			userDetails=(UserDetails) cr.uniqueResult();
			return userDetails;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public UserDetails login(UserDetails userDetails) {
		return null;
	}

}
