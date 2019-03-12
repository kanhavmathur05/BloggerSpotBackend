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

import com.collaborationproject.model.BlogComment;
import com.collaborationproject.model.BlogPost;
import com.collaborationproject.model.UserDetails;
import com.collaborationproject.service.BlogPostService;
import com.collaborationproject.service.UserDetailsService;

public class BlogPostTestCase {

	BlogPostService blogPostService;
	UserDetailsService userDetailsService;
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	BlogPost blogPost;
	BlogComment blogComment;
	
	@Before
	public void setUp(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collaborationproject");
		context.refresh();
		blogPost=(BlogPost) context.getBean("blogPost");
		userDetails=(UserDetails) context.getBean("userDetails");
		blogComment=(BlogComment) context.getBean("blogComment");
		blogPostService=(BlogPostService) context.getBean("blogPostService");
		userDetailsService=(UserDetailsService) context.getBean("userDetailsService");
	}
	
	@Ignore
	@Test
	public void addBlogPostTestCase()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		blogPost.setBlogTitle("Blog Title 2");
		blogPost.setBlogDescription("This is Blog Description 2!");
		blogPost.setPostedBy(userDetails);
		blogPost.setPostedOn(new Date());
		blogPost.setApproved("A");
		
		blogPostService.insertOrUpdateBlogPost(blogPost);
	}
	
	@Ignore
	@Test
	public void updateBlogPostTestCase()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		blogPost.setBlogID(1);
		blogPost.setBlogTitle("Blog Title changed");
		blogPost.setBlogDescription("This is new Blog Description!");
		blogPost.setPostedBy(userDetails);
		blogPost.setPostedOn(new Date());
		blogPost.setApproved("N");
		
		blogPostService.insertOrUpdateBlogPost(blogPost);
	}
	
	@Ignore
	@Test
	public void blogPostByIdTest()
	{
		blogPost=blogPostService.getBlogPostById(1);
		System.out.println(""+blogPost.getBlogID());
		System.out.println(""+blogPost.getBlogTitle());
		System.out.println(""+blogPost.getBlogDescription());
		System.out.println(""+blogPost.getPostedBy());
		System.out.println(""+blogPost.getPostedOn());
	}
	
	@Ignore
	@Test
	public void getBlogsList()
	{
		List<BlogPost> blogPosts=blogPostService.getBlogPosts("N");
		for(BlogPost post:blogPosts)
		{
			System.out.println(""+post.getBlogID());
			System.out.println(""+post.getBlogTitle());
			System.out.println(""+post.getBlogDescription());
			System.out.println(""+post.getPostedBy());
			System.out.println(""+post.getPostedOn());
		}
	}
	
	@Ignore
	@Test
	public void getBlogsListByUser()
	{
		userDetails=userDetailsService.getUserDetails("tom12");
		List<BlogPost> blogPosts=blogPostService.getBlogPostsByUser(userDetails);
		for(BlogPost post:blogPosts)
		{
			System.out.println(""+post.getBlogID());
			System.out.println(""+post.getBlogTitle());
			System.out.println(""+post.getBlogDescription());
			System.out.println(""+post.getPostedBy());
			System.out.println(""+post.getPostedOn());
		}
	}
	
	@Ignore
	@Test
	public void deleteBlogPost()
	{
		blogPost=blogPostService.getBlogPostById(3);
		blogPostService.deleteBlogPost(blogPost);
	}
	
	@Ignore
	@Test
	public void addBlogCommentTest()
	{	userDetails=userDetailsService.getUserDetails("tom12");
		blogPost=blogPostService.getBlogPostById(1);
		blogComment.setCommentedBy(userDetails);
		blogComment.setCommentedOn(new Date());
		blogComment.setCommentText("This is a new comment on the blog");
		blogComment.setBlogPost(blogPost);
		blogPostService.addBlogComment(blogComment);
	}
	
	@Test
	public void getBlogCommentsTest()
	{
		List<BlogComment> blogComments=blogPostService.getAllBlogComment(1);
		for(BlogComment comment:blogComments)
		{
			System.out.println(""+comment.getID());
			System.out.println(""+comment.getBlogPost());
			System.out.println(""+comment.getCommentText());
			System.out.println(""+comment.getCommentedBy());
			System.out.println(""+comment.getCommentedOn());
		}
	}
	
	@After
	public void tearDown(){
		context.close();
	}

}
