package com.sandesh.internship.services;

import com.sandesh.internship.models.Student;

/**
 * This contains all course related services
 * @author Sandesh
 * @since 28-11-2017
 */
public interface EnrollService {

	/**
	 * This method removes the student enrollment information from enroll table.
	 * @param	id	Takes param as student id
	 * @return boolean	True if record is removed otherwise false
	 */
	boolean jdbcRemoveEnrollByStudentId(int id);

	/**
	 * This method insert the enrollment information.
	 * @param studentId		This represents student id to be inserted.
	 * @param courseId		This represents course id to be inserted.
	 * @param acceptablePrice	This is the acceptable price.
	 */
	void jdbcInsertEnroll(int studentId, int courseId, long acceptablePrice);

	/**
	 * This method insert the enrollment information.
	 * @param student	This represents student object for which the enrollment info has to be set.
	 */
	void jdbcInsertEnroll(Student student);

}
