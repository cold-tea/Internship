package com.sandesh.internship.services;

import java.util.List;

import com.sandesh.internship.models.Student;
import com.sandesh.internship.models.StudentCourse;

/**
 * This contains all student related services
 * @author Sandesh
 * @since 25-11-2017
 */
public interface StudentService {

	/**
	 * 1. It inserts the student information in student table.
	 * 2. After that it delegates control to EnrollService for updating enroll table.
	 * 3. And again it delegates control to InstallmentService for updating installment table.
	 * 3rd step is carried out if installment provided is greater than Zero.
	 * @param student
	 */
	void jdbcInsertStudent(Student student);
	
	/**
	 * Get all student objects from the database.
	 * @return List of students
	 * 
	 */
	List<Student> jdbcGetAll();
	
	/**
	 * It removes the student 
	 * It might throw an exception if anything goes wrong
	 * @param	student	It is a student to be removed
	 * @exception	ex	It is a generic exception
	 * @return	boolean	true if any row is removed otherwise false
	 * @deprecated The remove functionality is deprecated. It hinders the design principle.
	 */
	boolean jdbcRemoveStudent(Student student);
	
	/**
	 * This method get the student object from database with respect to the student id provided
	 * @param	id	Takes param as student id
	 * @return Course	Return back student object
	 */
	Student jdbcGetById(int id);
	
	/**
	 * Returns all the courses learnt by student
	 * @param stdId
	 * @return
	 */
	List<StudentCourse> jdbcGetCoursesFromEnroll(int stdId);
	
	/**
	 * This block code update the student information
	 * @param	studentModel	It represents the student to be updated
	 * @return	boolean	true if any row is updated otherwise false
	 */
	boolean jdbcUpdateStudent(Student studentModel);
}