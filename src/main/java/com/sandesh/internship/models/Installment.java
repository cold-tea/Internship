package com.sandesh.internship.models;

public class Installment {

	private Student student;
	private Course course;
	private long totalInstallment;
	private long applicablePrice;
	
	public Installment() {}
	public Installment(Student student, Course course, long installment) {
		this.student = student;
		this.course = course;
		this.totalInstallment = installment;
	}
	public Installment(Student student, Course course, long installment, long applicablePrice) {
		this(student, course, installment);
		this.applicablePrice = applicablePrice;
	}
	
	
	public long getApplicablePrice() {
		return applicablePrice;
	}
	public void setApplicablePrice(long applicablePrice) {
		this.applicablePrice = applicablePrice;
	}
	public long getTotalInstallment() {
		return totalInstallment;
	}
	public void setTotalInstallment(long totalInstallment) {
		this.totalInstallment = totalInstallment;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
