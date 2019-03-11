package com.collaborationproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Job {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	@NotNull
	private String jobTitle;
	@NotNull
	private String jobDescription;
	private String skillsRequired;
	private int salary,vacancies,experience;
	@NotNull
	private String location;
	@NotNull
	private String companyName;
	@NotNull
	private long contact;
	@NotNull
	private Date postedOn;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle=jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}	
	public void setJob_description(String jobDescription) {
		this.jobDescription=jobDescription;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkills_required(String skillsRequired) {
		this.skillsRequired=skillsRequired;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName=companyName;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact=contact;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience=experience;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn=postedOn;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies=vacancies;
	}
}
	