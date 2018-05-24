package com.sandesh.internship.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sandesh.internship.models.Student;

/**
 * This is row mapper for the student object.
 * @author Sandesh
 *
 */
public class StudentMapper implements RowMapper<Student>{
	

	@Override
	public Student mapRow(ResultSet rs, int index) throws SQLException {
		return new Student(rs.getInt("s_id"), rs.getString("f_name"),
				rs.getString("l_name"), rs.getString("gender"));
	}

}
