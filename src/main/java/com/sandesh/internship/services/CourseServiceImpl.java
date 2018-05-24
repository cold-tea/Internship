package com.sandesh.internship.services;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.sandesh.internship.mappers.CourseMapper;
import com.sandesh.internship.models.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	private NamedParameterJdbcTemplate namedParamJdbcTemp;
	
	public CourseServiceImpl(DataSource dataSource) {
		namedParamJdbcTemp = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public List<Course> jdbcGetAll() {
		return namedParamJdbcTemp.query("SELECT * FROM course", new CourseMapper());
	}

	
	@Override
	public Course jdbcGet(int id) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("cid", id);
		return namedParamJdbcTemp.queryForObject("SELECT * FROM course WHERE c_id = :cid", 
				source, new CourseMapper());
	}
	
	@Override
	public void jdbcInsertCourse(Course course) {
		String sql = "Insert into course (name, price, start_time, end_time) values (:name, :price, :stime, :etime)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("name", course.getName());
		source.addValue("price", course.getPrice());
		source.addValue("stime", course.getStartTime());
		source.addValue("etime", course.getEndTime());
		KeyHolder holder = new GeneratedKeyHolder();
		namedParamJdbcTemp.update(sql, source, holder);
	}
		
	@Override
	public boolean jdbcRemoveCourse(int id) {
		String sql = "Delete from Course where c_id = :cid";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("cid", id);
		int result;
		try {
			result = namedParamJdbcTemp.update(sql, source);
		} catch (Exception ex) {
			result = 0;
		}
		if (result > 0) return true;
		return false;
	}
	
	
	@Override
	public boolean jdbcUpdateCourse(Course course) {
		String sql = "Update Course set name=:name, price=:price, start_time=:stime, end_time=:etime where c_id=:id";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("name", course.getName());
		source.addValue("price", course.getPrice());
		source.addValue("stime", course.getStartTime());
		source.addValue("etime", course.getEndTime());
		source.addValue("id", course.getId());
		int result;
		try {
			result = namedParamJdbcTemp.update(sql, source);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = 0;
		}
		if (result > 0) return true;
		return false;
	}
}
