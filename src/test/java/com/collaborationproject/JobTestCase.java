package com.collaborationproject;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborationproject.model.ApplyForJob;
import com.collaborationproject.model.Job;
import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.JobService;
import com.collaborationproject.service.UserDetailsService;

public class JobTestCase {

	AnnotationConfigApplicationContext context;
	Job job;
	UserDetails userDetails;
	UserDetailsService userDetailsService;
	ApplyForJob applyForJob;
	JobService jobService;
	
	@Before
	public void setUp(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaborationproject");
		context.refresh();
		job=(Job) context.getBean("job");
		userDetails=(UserDetails) context.getBean("userDetails");
		userDetailsService=(UserDetailsService) context.getBean("userDetailsService");
		applyForJob=(ApplyForJob) context.getBean("applyForJob");
		jobService=(JobService) context.getBean("jobService");
	}

	@Ignore
	@Test
	public void addJobTest()
	{
		job.setCompanyName("Apple");
		job.setContact(90802344);
		job.setExperience(8);
		job.setJobDescription("This is another Job Description!");
		job.setJobTitle("Se.Software Developer");
		job.setLocation("Bangalore");
		job.setPostedOn(new Date());
		job.setSalary(323234);
		job.setVacancies(5);
		job.setSkillsRequired("Java,Angular,Spring,Hibernate,Objective-C");
		
		jobService.insertOrUpdateJob(job);
	}
	@Ignore
	@Test
	public void updateJobTest()
	{
		job.setId(7);
		job.setCompanyName("Apple Inc.");
		job.setContact(90802344);
		job.setExperience(9);
		job.setJobDescription("This is the Job Description!");
		job.setJobTitle("Se.Software Dev.");
		job.setLocation("Bangalore");
		job.setPostedOn(new Date());
		job.setSalary(423234);
		job.setVacancies(4);
		job.setSkillsRequired("Java,Angular6,Spring,Hibernate,Objective-C");
		
		jobService.insertOrUpdateJob(job);
	}
	
	@Ignore
	@Test
	public void deleteJobTest()
	{
		job=jobService.getJobById(7);
		jobService.deleteJob(job);
	}
	
	@Ignore
	@Test
	public void getJobByIdTest()
	{
		job=jobService.getJobById(6);
		System.out.println(""+job.getCompanyName());
		System.out.println(""+job.getId());
		System.out.println(""+job.getJobTitle());
		System.out.println(""+job.getJobDescription());
		System.out.println(""+job.getSkillsRequired());
		System.out.println(""+job.getLocation());
		System.out.println(""+job.getSalary());
	}
	
	@Ignore
	@Test
	public void getAllJobsTest()
	{
		List<Job> listOfJobs=jobService.getJob();
		for(Job eachJob:listOfJobs) {
			System.out.println(""+eachJob.getCompanyName());
			System.out.println(""+eachJob.getId());
			System.out.println(""+eachJob.getJobTitle());
			System.out.println(""+eachJob.getJobDescription());
			System.out.println(""+eachJob.getSkillsRequired());
			System.out.println(""+eachJob.getLocation());
			System.out.println(""+eachJob.getSalary());
		}
	}
	
	@Ignore
	@Test
	public void applyForJobTest()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		applyForJob.setAppliedBy(userDetails);
		applyForJob.setAppliedFor(6);
		jobService.applyForJob(applyForJob);
	}
	
	@Ignore
	@Test
	public void checkIfAppliedForJobTest()
	{
		UserDetails userDetails=userDetailsService.getUserDetails("tom112");
		boolean result=jobService.checkIfApplied(7, userDetails);
		System.out.println("Result:"+result);
	}
	
	@Ignore
	@Test
	public void getAppliedUsersTest()
	{
		List<ApplyForJob> appliedUsers=jobService.getAllAppliedUser(7);
		for(ApplyForJob userApplied:appliedUsers) {
			System.out.println(""+userApplied.getAppliedBy().getUserName());
		}
	}
	
	@After
	public void tearDown(){
		context.close();
	}

}
