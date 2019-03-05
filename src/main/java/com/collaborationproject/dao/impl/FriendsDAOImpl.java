package com.collaborationproject.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.collaborationproject.dao.FriendsDAO;
import com.collaborationproject.model.Friends;
import com.collaborationproject.model.UserDetails;

@Transactional
public class FriendsDAOImpl implements FriendsDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<UserDetails> getSuggestedFriends(String userName) {
		List<UserDetails> suggestedFriends;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("userName", userName));
			suggestedFriends=cr.list();
			return suggestedFriends;
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		return null;
		}
	}

	@Override
	public void addOrUpdateFriend(Friends friend) {
		
	}

	@Override
	public List<UserDetails> getFriendRequests(String userName) {
		return null;
	}

	@Override
	public List<UserDetails> getFriendsList(String userName) {
		return null;
	}

	@Override
	public Friends getFriend(String toId, String fromId) {
		return null;
	}

	@Override
	public List<UserDetails> getSentRequests(String userName) {
		return null;
	}
}
