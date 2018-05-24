package com.sandesh.internship.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sandesh.internship.models.StudentCourse;

/**
 * This is row mapper for the StudentCourse object.
 * @author Sandesh
 *
 */
public class StudentCourseMapper implements RowMapper<StudentCourse> {

	@Override
	public StudentCourse mapRow(ResultSet rs, int index) throws SQLException {
		return new StudentCourse(rs.getInt("c_id"), rs.getString("name"),
				rs.getLong("price"), rs.getLong("applicable_price"));
	}

	
}
