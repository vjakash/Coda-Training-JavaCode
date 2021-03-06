package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", mobile=" + mobile
				+ ", email=" + email +  "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	
	@NotEmpty(message = "Enter username")
	private String username;
	
	
	@NotEmpty(message = "Enter Password")
	@Size(min = 8,message = "Password requires minimum 8 characters")
	private String password;
	
	@NotEmpty(message = "Enter mobile number")
	@Size(min = 10,max = 10,message = "Invalid number")
	private String mobile;
	
	@NotEmpty(message = "Enter Email id")
	@Email(message = "Invalid Email")
	private String email;
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy = "user",targetEntity=Address.class)
	private Set<Address>  addresses;
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
