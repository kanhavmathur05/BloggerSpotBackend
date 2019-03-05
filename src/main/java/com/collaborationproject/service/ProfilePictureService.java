package com.collaborationproject.service;

import com.collaborationproject.model.ProfilePicture;

public interface ProfilePictureService {
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
