package com.collaborationproject.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.collaborationproject.dao.JobDAO;
import com.collaborationproject.model.ApplyForJob;
import com.collaborationproject.model.Job;

public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertOrUpdateJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public List<Job> getJob() {
		List<Job> allJobsList;
		try
		{
			allJobsList=sessionFactory.getCurrentSession().createQuery("from Job").list();
			return allJobsList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Job getJobById(int id) {
		Job job;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(Job.class);
			cr.add(Restrictions.eq("id", id));
			job=(Job) cr.uniqueResult();
			return job;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public List<ApplyForJob> getAllAppliedUser(int jobId) {
		return null;
	}

	@Override
	public void applyForJob(ApplyForJob applyForJob) {
		
	}

	@Override
	public boolean checkIfApplied(int jobId, String userName) {
		return false;
	}
}
