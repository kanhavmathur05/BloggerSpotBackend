package com.collaborationproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserDetails {
	@Id
	private String userName; 
	@NotNull
	private String firstName;
	private String lastName;
	@NotNull
	private String password;
	@NotNull
	private String role;
	@Column(unique=true,nullable=false)
	private String email;
	@NotNull
	private String address;
	@NotNull
	private long mobile;
	private boolean onlineStatus;
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName=userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role=role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile=mobile;
	}
	public boolean isOnlineStatus() {
		return onlineStatus;
	}
	public void setOnline_status(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

}