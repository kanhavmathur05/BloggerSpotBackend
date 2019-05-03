package com.collaborationproject.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborationproject.dao.BlogPostDAO;
import com.collaborationproject.model.BlogComment;
import com.collaborationproject.model.BlogPost;
import com.collaborationproject.model.UserDetails;

@Transactional
@Repository(value="blogPostDAO")
public class BlogPostDAOImpl implements BlogPostDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public BlogPost insertOrUpdateBlogPost(BlogPost blogPost) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogPost);
			return blogPost;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<BlogPost> getBlogPosts(String approved) {
		List<BlogPost> blogPostsList;
		try {
			System.out.println("Value of approved in backend::::"+approved);
			if(approved.equals("A"))
			{
				Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogPost.class);
				cr.add(Restrictions.eq("approved", approved));
				blogPostsList=cr.list();
				System.out.println("DAO IMPL List Returns:::::");
				for(BlogPost listElement:blogPostsList)
				{
					System.out.println(""+listElement.getApproved());
				}
//				blogPostsList=sessionFactory.getCurrentSession().createQuery("from BlogPost").list();
			}
			else
			{
				blogPostsList=sessionFactory.getCurrentSession().createQuery("from BlogPost").list();
				System.out.println("DAO IMPL List Returns:::::");
				for(BlogPost listElement:blogPostsList)
				{
					System.out.println(""+listElement.getApproved());
				}
			}
			return blogPostsList;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;

		}
	}

	@Override
	public BlogPost getBlogPostById(int ID) {
		BlogPost blogPost;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogPost.class);
			cr.add(Restrictions.eq("blogID",ID));
			blogPost=(BlogPost) cr.uniqueResult();
			return blogPost;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BlogPost> getBlogPostsByUser(UserDetails user) {
		List<BlogPost> blogPostsByUser;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogPost.class);
			cr.add(Restrictions.eq("postedBy", user));
			blogPostsByUser=cr.list();
			return blogPostsByUser;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		try {
			sessionFactory.getCurrentSession().delete(blogPost);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().save(blogComment);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public List<BlogComment> getAllBlogComment(BlogPost blogPost) {
		List<BlogComment> blogComments;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogComment.class);
			cr.add(Restrictions.eq("blogPost", blogPost));
			blogComments=cr.list();
			return blogComments;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
