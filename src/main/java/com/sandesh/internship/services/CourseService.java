package com.sandesh.internship.services;

import java.util.List;

import com.sandesh.internship.models.Course;

/**
 * This contains all course related services
 * @author Sandesh
 * @since 25-11-2017
 */
public interface CourseService {

	/**
	 * Get all course objects from the database.
	 * @return List of courses
	 * 
	 */
	List<Course> jdbcGetAll();

	/**
	 * This method get the course object from database with respect to the course id provided
	 * @param	id	Takes param as course id
	 * @return Course	Return back course object
	 */
	Course jdbcGet(int id);
	
	/**
	 * Add Course in the database
	 * @param 	Course Takes course object as param
	 * @return	void
	 */
	void jdbcInsertCourse(Course course);

	/**
	 * It removes the course 
	 * It might throw an exception if anything goes wrong
	 * @param	id	It is an id of the course to be removed
	 * @exception	ex	It is a generic exception
	 * @return	boolean	true if any row is removed otherwise false
	 * @deprecated The remove functionality is deprecated. It hinders the design principle.
	 */
	boolean jdbcRemoveCourse(int id);

	/**
	 * This block code update the course information
	 * @param	course	It represents the course to be updated
	 * @return	boolean	true if any row is updated otherwise false
	 */
	boolean jdbcUpdateCourse(Course course);


}