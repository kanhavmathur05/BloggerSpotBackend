package com.collaborationproject.service;

import com.collaborationproject.model.UserDetails;

public interface UserDetailsService {
	public void insertOrUpdateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(String userName);
	public UserDetails getUserDetailsByEmail(String email);
	public UserDetails login(UserDetails userDetails);
}
