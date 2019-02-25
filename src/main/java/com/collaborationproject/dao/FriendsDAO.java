package com.collaborationproject.dao;

import java.util.List;

import com.collaborationproject.model.Friends;
import com.collaborationproject.model.UserDetails;

public interface FriendsDAO {
	List<UserDetails> getSuggestedFriends(String username);
	void addOrUpdateFriend(Friends friend);
	public List<UserDetails> getFriendRequests(String username);
	public List<UserDetails> getFriendsList(String username);
	public Friends getFriend(String toId,String fromId);
	public List<UserDetails> getSentRequests(String username);
}