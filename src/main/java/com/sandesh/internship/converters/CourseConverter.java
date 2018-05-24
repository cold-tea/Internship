package com.sandesh.internship.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.sandesh.internship.models.Course;
import com.sandesh.internship.services.CourseService;

/**
 * This is a converter class.
 * It converts course id in string format to the course object.
 * @author Sandesh
 *
 */
public class CourseConverter implements Converter<String, Course> {
	
	@Autowired
	private CourseService courseService;

	@Override
	public Course convert(String id) {		
		return courseService.jdbcGet(Integer.valueOf(id));
	}

}
