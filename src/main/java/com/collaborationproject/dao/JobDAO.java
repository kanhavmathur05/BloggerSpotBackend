package com.collaborationproject.dao;

import java.util.List;

import com.collaborationproject.model.ApplyForJob;
import com.collaborationproject.model.Job;

public interface JobDAO {
	public void insertOrUpdateJob(Job job);
	public void deleteJob(Job job);
	public List<Job> getJob();
	public Job getJobById(int id);
	public List<ApplyForJob> getAllAppliedUser(int jobId);
	public void applyForJob(ApplyForJob applyForJob);
	public boolean checkIfApplied(int jobId,String username);
}
