package com.sandesh.internship.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Course {

	private int id;
	private String name;
	private long price;
	private String startTime;
	private String endTime;
	
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	public Course() {}
	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Course(int id, String name, long price, String startTime, String endTime) {
		this(id, name);
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
