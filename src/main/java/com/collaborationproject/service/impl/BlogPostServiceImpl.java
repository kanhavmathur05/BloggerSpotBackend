package com.collaborationproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborationproject.dao.BlogPostDAO;
import com.collaborationproject.model.BlogComment;
import com.collaborationproject.model.BlogPost;
import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.BlogPostService;

@Service(value="blogPostService")
public class BlogPostServiceImpl implements BlogPostService{

	@Autowired
	BlogPostDAO blogPostDAO;
	
	public void insertOrUpdateBlogPost(BlogPost blogPost) {
		try
		{
			blogPostDAO.insertOrUpdateBlogPost(blogPost);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public List<BlogPost> getBlogPosts(String approved) {
		List<BlogPost> blogPosts=blogPostDAO.getBlogPosts(approved);
		if(blogPosts!=null)
		{
			return blogPosts;
		}
		else
		{
			return null;
		}
	}

	@Override
	public BlogPost getBlogPostById(int ID) {
		BlogPost blogPostById=blogPostDAO.getBlogPostById(ID);
		if(blogPostById!=null)
		{
			return blogPostById;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<BlogPost> getBlogPostsByUser(UserDetails user) {
		List<BlogPost> blogPostsBytUser=blogPostDAO.getBlogPostsByUser(user);
		if(blogPostsBytUser!=null)
		{
			return blogPostsBytUser;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		blogPostDAO.deleteBlogPost(blogPost);
	}

	@Override
	public void addBlogComment(BlogComment blogComment) {
		blogPostDAO.addBlogComment(blogComment);
	}

	@Override
	public List<BlogComment> getAllBlogComment(BlogPost blogPost) {
		List<BlogComment> allBlogComment=blogPostDAO.getAllBlogComment(blogPost);
		if(allBlogComment!=null)
		{
			return allBlogComment;
		}
		else
		{
			return null;
		}
	}

}
