package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	
	@NotEmpty(message = "Enter name")
	private String name;
	
	
	@NotEmpty(message = "Enter Doorno")
	private String doorno;
	
	@NotEmpty(message = "Enter Street")
	private String street;
	
	@NotEmpty(message = "Enter Area")
	private String area;
	
	@NotEmpty(message = "Enter City")
	private String city;
	
	@NotEmpty(message = "Enter Pincode")
	private String pincode;
	
	@ManyToOne()
	  @JoinColumn( name="uid" )
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", name=" + name + ", doorno=" + doorno + ", street=" + street
				+ ", area=" + area + ", city=" + city + ", pincode=" + pincode +  "]";
	}
	
}
