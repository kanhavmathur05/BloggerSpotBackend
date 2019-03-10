package com.collaborationproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborationproject.dao.FriendsDAO;
import com.collaborationproject.model.Friends;
import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	FriendsDAO friendsDAO;
	
	@Override
	public List<UserDetails> getSuggestedFriends(String userName) {
		List<UserDetails> suggestedFriends=friendsDAO.getSuggestedFriends(userName);
		if(suggestedFriends!=null)
		{
			return suggestedFriends;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void addOrUpdateFriend(Friends friend) {
		friendsDAO.addOrUpdateFriend(friend);
	}

	@Override
	public List<UserDetails> getFriendRequests(String userName) {
		List<UserDetails> friendRequests=friendsDAO.getFriendRequests(userName);
		if(friendRequests!=null)
		{
			return friendRequests;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<UserDetails> getFriendsList(String userName) {
		List<UserDetails> friendsList=friendsDAO.getFriendsList(userName);
		if(friendsList!=null)
		{
			return friendsList;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Friends getFriend(String toId, String fromId) {
		Friends friend=friendsDAO.getFriend(toId, fromId);
		if(friend!=null)
		{
			return friend;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<UserDetails> getSentRequests(String userName) {
		List<UserDetails> sentRequests=friendsDAO.getSentRequests(userName);
		if(sentRequests!=null)
		{
			return sentRequests;
		}
		else
		{
			return null;
		}
	}

}
