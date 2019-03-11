package com.collaborationproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborationproject.dao.ProfilePictureDAO;
import com.collaborationproject.model.ProfilePicture;

@Transactional
@Repository
public class ProfilePictureDAOImpl implements ProfilePictureDAO{

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(profilePicture);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public ProfilePicture getProfilePicture(String userName) {
		ProfilePicture profilePicture;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(ProfilePicture.class);
			cr.add(Restrictions.eq("userName", userName));
			profilePicture=(ProfilePicture) cr.uniqueResult();
			return profilePicture;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

}
