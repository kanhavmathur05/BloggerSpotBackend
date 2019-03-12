package com.collaborationproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProfilePicture {
	@Id
	private String userName;
	@Lob
	private byte[] image;
	public String getUserName() {
		return userName;
	}	
	public void setUsername(String userName) {
		this.userName=userName;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image=image;
	}
	
}
	