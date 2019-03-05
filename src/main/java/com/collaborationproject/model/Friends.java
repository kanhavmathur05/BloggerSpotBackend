package com.collaborationproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friends {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fromID;
	private String toID;
	private char status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getFromID() {
		return fromID;
	}
	public void setFromID(String fromID) {
		this.fromID=fromID;
	}
	public String getToID() {
		return toID;
	}
	public void setToID(String toID) {
		this.toID=toID;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status=status;
	}
}

