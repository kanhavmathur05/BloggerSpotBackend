package com.collaborationproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborationproject.dao.ProfilePictureDAO;
import com.collaborationproject.model.ProfilePicture;
import com.collaborationproject.service.ProfilePictureService;

@Service(value="profilePictureService")
public class ProfilePictureServiceImpl implements ProfilePictureService{

	@Autowired
	ProfilePictureDAO profilePictureDAO;
	
	@Override
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture) {
		profilePictureDAO.insertOrUpdateProfilePicture(profilePicture);
	}

	@Override
	public ProfilePicture getProfilePicture(String userName) {
		ProfilePicture profilePicture=profilePictureDAO.getProfilePicture(userName);
		if(profilePicture!=null)
		{
			return profilePicture;
		}
		else
		{
			return null;
		}
	}

}
