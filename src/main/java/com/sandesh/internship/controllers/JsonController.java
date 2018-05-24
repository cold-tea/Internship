package com.sandesh.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandesh.internship.models.Student;
import com.sandesh.internship.services.StudentService;

/**
 * This controller class has mapping for different URLs which requires JSON.
 * RESTful web services can be enhanced using this controller.
 * @deprecated	 Currently the usage of this class is deprecated as the app is not yet converted to REST arch.
 * @author Sandesh
 * 
 */

@RestController
public class JsonController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/student/list/json", method = RequestMethod.GET)
	public List<Student> listStudentsJson() {
		return studentService.jdbcGetAll();
	}
	
	@RequestMapping(value="student/post/json", method = RequestMethod.POST)
	public Student postStudentsJson(@RequestBody Student student) {
		studentService.jdbcInsertStudent(student);
		return student;
	}
	
	@RequestMapping(value="student/query/json", method = RequestMethod.GET)
	public void handlingQueryParam(@RequestParam String name) {
		System.out.println("Query param sent is: " + name); 
	}
	
	@RequestMapping(value="student/form/json", method = RequestMethod.POST)
	public void handlingFormParam(@RequestParam String name) {
		System.out.println("Form param sent is: " + name); 
	}
	
	@RequestMapping(value="student/{name}/json", method = RequestMethod.GET)
	public void handlingPathParam(@PathVariable String name) {
		System.out.println("Path param sent is: " + name); 
	}
	
	
}
