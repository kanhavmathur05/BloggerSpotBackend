package com.collaborationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.UserDetailsService;

public class UserDetailsTestCase {

	UserDetailsService userDetailsService;
	AnnotationConfigApplicationContext context;
	UserDetails userDetails;
	
	@Before
	public void setUp(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collaborationproject");
		context.refresh();
		userDetails = (UserDetails)context.getBean("userDetails");
		userDetailsService=(UserDetailsService)context.getBean("userDetailsService");
	
	}
	
	@Test
	public void insertOrUpdateUserDetails()
	{
		int result;
		userDetails.setFirstName("Tom");
		userDetails.setLastName("Ryder");
		userDetails.setEmail("tom12@gmail.com");
		userDetails.setAddress("Address of Tom Ryder");
		userDetails.setMobile(987987908);
		userDetails.setOnlineStatus(false);
		userDetails.setRole("ROLE_USER");
		userDetails.setPassword("tompassword");
		userDetails.setUsername("tom12");
		
		userDetailsService.insertOrUpdateUserDetails(userDetails);
	}
	
	
	@After
	public void tearDown(){
		context.close();
	}


}
