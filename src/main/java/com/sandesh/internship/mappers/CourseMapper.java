package com.sandesh.internship.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sandesh.internship.models.Course;

/**
 * This is row mapper for the course object.
 * @author Sandesh
 *
 */
public class CourseMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int index) throws SQLException {
		return new Course(rs.getInt("c_id"), rs.getString("name"), rs.getLong("price"),
				rs.getString("start_time"), rs.getString("end_time"));
	}
}
