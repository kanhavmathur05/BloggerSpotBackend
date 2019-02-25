package com.collaborationproject.dao;

import com.collaborationproject.model.UserDetails;

public interface UserDetailsDAO {
	public void insertOrUpdateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(String username);
	public UserDetails getUserDetailsByEmail(String email);
	public UserDetails login(UserDetails userDetails);
}
