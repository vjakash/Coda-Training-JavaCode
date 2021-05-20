package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//@Entity
public class LoginForm {
//	@Id
	private int uid;
	
	@NotEmpty(message = "Enter username")
	private String username;
	
	@NotEmpty(message = "Enter Password")
	@Size(min = 8,message = "Password requires minimum 8 characters")
	private String password;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
