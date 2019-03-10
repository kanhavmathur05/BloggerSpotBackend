package com.collaborationproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborationproject.dao.JobDAO;
import com.collaborationproject.model.ApplyForJob;
import com.collaborationproject.model.Job;
import com.collaborationproject.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobDAO jobDAO;
	
	@Override
	public void insertOrUpdateJob(Job job) {
		jobDAO.insertOrUpdateJob(job);
	}

	@Override
	public void deleteJob(Job job) {
		jobDAO.deleteJob(job);
	}

	@Override
	public List<Job> getJob() {
		List<Job> jobs=jobDAO.getJob();
		if(jobs!=null)
		{
			return jobs;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Job getJobById(int id) {
		Job jobById=jobDAO.getJobById(id);
		if(jobById!=null)
		{
			return jobById;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<ApplyForJob> getAllAppliedUser(int jobId) {
		List<ApplyForJob> allAppliedUsers=jobDAO.getAllAppliedUser(jobId);
		if(allAppliedUsers!=null)
		{
			return allAppliedUsers;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void applyForJob(ApplyForJob applyForJob) {
		jobDAO.applyForJob(applyForJob);
	}

	@Override
	public boolean checkIfApplied(int jobId, String userName) {
		if(jobDAO.checkIfApplied(jobId, userName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
