package com.collaborationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborationproject.model.Friends;
import com.collaborationproject.service.FriendsService;

public class FriendsTest {
	AnnotationConfigApplicationContext context;
	Friends friends;
	FriendsService friendsService;
	
	@Before
	public void setUp(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaborationproject");
		friends=(Friends) context.getBean("friends");
		friendsService=(FriendsService) context.getBean("friendsService");
		context.refresh();
	}

	
	
	@After
	public void tearDown(){
		context.close();
	}
}
