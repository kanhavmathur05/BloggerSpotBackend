package com.collaborationproject.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
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
		List<ApplyForJob> appliedUsers;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(ApplyForJob.class);
			cr.add(Restrictions.eq("appliedFor", jobId));
			appliedUsers=cr.list();
			return appliedUsers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		//return null;
		/*
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<ApplyForJob> query=session.createQuery("from ApplyForJob where applied_for=:id");
		query.setParameter("id", jobId);
		List<ApplyForJob> list=query.list();
		return list;
		*/
	}

	@Override
	public void applyForJob(ApplyForJob applyForJob) {
		sessionFactory.getCurrentSession().saveOrUpdate(applyForJob);
		/*Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(applyForJob);*/
	}

	@Override
	public boolean checkIfApplied(int jobId, String userName) {
		return false;
		/*
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<ApplyForJob> query=session.createQuery("from ApplyForJob where applied_for=:id and applied_by.username=:username");
		query.setParameter("id", jobId);
		query.setParameter("username", username);
		if(query.uniqueResult()==null)
			return false;
		return true;*/
	}
}
