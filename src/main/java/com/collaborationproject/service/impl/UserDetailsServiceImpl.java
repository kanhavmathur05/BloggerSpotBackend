package com.collaborationproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborationproject.dao.UserDetailsDAO;
import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Override
	public void insertOrUpdateUserDetails(UserDetails userDetails) {
		userDetailsDAO.insertOrUpdateUserDetails(userDetails);
	}

	@Override
	public UserDetails getUserDetails(String userName) {
		UserDetails userDetails=userDetailsDAO.getUserDetails(userName);
		if(userDetails!=null)
		{
			return userDetails;
		}
		else
		{
			return null;
		}
	}

	@Override
	public UserDetails getUserDetailsByEmail(String email) {
		UserDetails userDetails=userDetailsDAO.getUserDetailsByEmail(email);
		if(userDetails!=null)
		{
			return userDetails;
		}
		else
		{
			return null;
		}
	}

	@Override
	public UserDetails login(UserDetails userDetails) {
		UserDetails userDetail=userDetailsDAO.login(userDetails);
		if(userDetail!=null)
		{
			return userDetail;
		}
		else
		{
			return null;
		}
	}

}
