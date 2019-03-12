package com.collaborationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
		userDetails=(UserDetails)context.getBean("userDetails");
		userDetailsService=(UserDetailsService)context.getBean("userDetailsService");
	
	}

	@Ignore
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
		userDetails.setUserName("tom12");
		
		userDetailsService.insertOrUpdateUserDetails(userDetails);
	}
	
	@Ignore
	@Test
	public void getUserDetailsByEmailTest()
	{
		userDetails=userDetailsService.getUserDetailsByEmail("tom12@gmail.com");
		System.out.println(""+userDetails.getFirstName()+""+userDetails.getLastName()+""+userDetails.getEmail()+""+userDetails.getMobile()+""+userDetails.getAddress()+""+userDetails.getPassword()+""+userDetails.getRole()+""+userDetails.getUserName());
	}
	
	@Ignore
	@Test
	public void loginTest()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		userDetails.setOnlineStatus(true);
		userDetailsService.insertOrUpdateUserDetails(userDetails);
		
	}
	
	@Ignore
	@Test
	public void updateUserDetails()
	{
		userDetails.setFirstName("Tommy");
		userDetails.setLastName("Ryderr");
		userDetails.setEmail("tom12@gmail.com");
		userDetails.setAddress("New Address of Tom Ryder");
		userDetails.setMobile(987987908);
		userDetails.setOnlineStatus(true);
		userDetails.setRole("ROLE_USER");
		userDetails.setPassword("tomspassword");
		userDetails.setUserName("tom12");
		
		userDetailsService.insertOrUpdateUserDetails(userDetails);
		
	}

	@Ignore
	@Test
	public void getUserDetailsByUserNameTest()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		System.out.println("\n"+userDetails.getFirstName()+"\n"+userDetails.getLastName()+"\n"+userDetails.getEmail()+"\n"+userDetails.getMobile()+"\n"+userDetails.getAddress()+"\n"+userDetails.getPassword()+"\n"+userDetails.getRole()+"\n"+userDetails.getUserName());
	}
	
	@After
	public void tearDown(){
		context.close();
	}


}
