package com.sandesh.internship.models;

public class StudentCourse {

	private int id;
	private String name;
	private long price;
	private long applicablePrice;
	
	public StudentCourse() {}
	public StudentCourse(int id, String name, long price, long applicablePrice) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.applicablePrice = applicablePrice;
	}
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getApplicablePrice() {
		return applicablePrice;
	}
	public void setApplicablePrice(long applicablePrice) {
		this.applicablePrice = applicablePrice;
	}
	
	
}
