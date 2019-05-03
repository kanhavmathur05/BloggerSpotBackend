package com.collaborationproject.dao;

import java.util.List;

import com.collaborationproject.model.BlogComment;
import com.collaborationproject.model.BlogPost;
import com.collaborationproject.model.UserDetails;

public interface BlogPostDAO {
	BlogPost insertOrUpdateBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogPosts(String approved);
	BlogPost getBlogPostById(int ID);
	List<BlogPost> getBlogPostsByUser(UserDetails user);
	void deleteBlogPost(BlogPost blogPost);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComment(BlogPost blogPost);
}
