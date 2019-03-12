package com.collaborationproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
public class BlogPost {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int blogID;
	@NotNull
	private String blogTitle;
	@Lob
	@NotNull
	private String blogDescription;
	private Date postedOn;
	@ManyToOne
	private UserDetails postedBy;
	private String approved;
	
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved=approved;
	}
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID=blogID;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription=blogDescription;
}	
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn=postedOn;
	}
	public UserDetails getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(UserDetails postedBy) {
		this.postedBy=postedBy;
	}
}
