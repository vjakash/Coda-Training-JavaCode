package com.model;

public class AddToCartForm {
	
	private int id;
	private String name;
	private float price;
	private float qty;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "AddToCartForm [item_id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
}
