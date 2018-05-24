package com.sandesh.internship.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.sandesh.internship.models.Student;
import com.sandesh.internship.services.StudentService;

/**
 * This is a converter class.
 * It converts student id in string format to the student object.
 * @author Sandesh
 *
 */
public class StudentConverter implements Converter<String, Student>{
	
	@Autowired
	private StudentService studentService;

	@Override
	public Student convert(String id) {
		return studentService.jdbcGetById(Integer.valueOf(id));
	}

}
