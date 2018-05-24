package com.sandesh.internship.services;

import java.util.List;

import com.sandesh.internship.models.Installment;
import com.sandesh.internship.models.Student;

/**
 * This contains all course related services
 * @author Sandesh
 * @since 29-11-2017
 */
public interface InstallmentService {

	/**
	 * This method list all the installment information associated with the students.
	 * @return
	 */
	List<Installment> jdbcListAll();

	/**
	 * This method inserts the student installment record in the database.
	 * @param student	It is the student object parameter passed by the caller.
	 */
	void jdbcInsertInstallment(Student student);

	/**
	 * This method inserts the student installment record in the database.
	 * This is an overloaded version of the method which accepts a student object.
	 * @param sid	Represents the student id.
	 * @param cid	Represents the course id.
	 * @param iAmount	Represents the installment amount.
	 */
	void jdbcInsertInstallment(int sid, int cid, long iAmount);

}
