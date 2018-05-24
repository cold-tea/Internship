package com.sandesh.internship.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {


	private int id;
	@NotBlank(message="Please enter first name !")
	private String fName;
	@NotBlank(message="Please enter last name !")
	private String lName;
	@NotBlank(message="Please choose gender !")
	private String gender;
	@JsonIgnore
	private Course course = new Course();
	@JsonIgnore
	private long applicableAmount;
	@JsonIgnore
	private List<Course> courses = new ArrayList<>();
	@JsonIgnore
	private List<StudentCourse> stuCourses = new ArrayList<>();
	@JsonIgnore
	private long installmentAmount;
	
	public Student(){}
	public Student(int id, String fName, String lName, String gender) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
	}
	public Student(int id, String fName, String lName, String gender, List<Course> courses) {
		this(id, fName, lName, gender);
		this.courses = courses;
	}

	public long getInstallmentAmount() {
		return installmentAmount;
	}
	public void setInstallmentAmount(long installmentAmount) {
		this.installmentAmount = installmentAmount;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public long getApplicableAmount() {
		return applicableAmount;
	}
	public void setApplicableAmount(long applicableAmount) {
		this.applicableAmount = applicableAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<StudentCourse> getStuCourses() {
		return stuCourses;
	}
	public void setStuCourses(List<StudentCourse> stuCourses) {
		this.stuCourses = stuCourses;
	}
	
	
}
