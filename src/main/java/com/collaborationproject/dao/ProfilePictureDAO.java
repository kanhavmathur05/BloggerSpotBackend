package com.collaborationproject.dao;

import com.collaborationproject.model.ProfilePicture;

public interface ProfilePictureDAO {
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
