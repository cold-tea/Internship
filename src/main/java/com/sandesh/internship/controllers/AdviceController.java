package com.sandesh.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sandesh.internship.models.Course;
import com.sandesh.internship.services.CourseService;

@ControllerAdvice
public class AdviceController {
	
	@Autowired
	private CourseService courseService;

	@ModelAttribute(name="courses")
	public List<Course> allCourses() {
		return courseService.jdbcGetAll();
	}
}
