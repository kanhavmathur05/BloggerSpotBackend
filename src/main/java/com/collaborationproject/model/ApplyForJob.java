package com.collaborationproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ApplyForJob {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int appliedFor;
	@ManyToOne
	private UserDetails appliedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getAppliedFor() {
		return appliedFor;
	}
	public void setApplied_for(int appliedFor) {
		this.appliedFor=appliedFor;
	}
	public UserDetails getAppliedBy() {
		return appliedBy;
	}
	public void setApplied_by(UserDetails appliedBy) {
		this.appliedBy=appliedBy;
	}
	
}
