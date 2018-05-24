package com.sandesh.internship.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sandesh.internship.models.Installment;
import com.sandesh.internship.services.CourseService;
import com.sandesh.internship.services.StudentService;

/**
 * This is row mapper for the installment object.
 * @author Sandesh
 *
 */
public class InstallmentMapper implements RowMapper<Installment> {
	
	private StudentService sService;
	private CourseService cService;
	
	public InstallmentMapper() {}
	public InstallmentMapper(StudentService sService, CourseService cService) {
		this.sService = sService;
		this.cService = cService;
	}

	@Override
	public Installment mapRow(ResultSet rs, int index) throws SQLException {
		int studentId = rs.getInt("s_id");
		int courseId = rs.getInt("c_id");
		return new Installment(sService.jdbcGetById(studentId), cService.jdbcGet(courseId), rs.getLong("t_install"));
	}

}
