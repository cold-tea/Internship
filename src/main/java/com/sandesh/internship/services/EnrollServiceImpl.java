package com.sandesh.internship.services;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.sandesh.internship.models.Student;

@Service
@Transactional
public class EnrollServiceImpl implements EnrollService{
	
	private NamedParameterJdbcTemplate namedParamJdbcTemp;
	
	public EnrollServiceImpl(DataSource dataSource) {
		namedParamJdbcTemp = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean jdbcRemoveEnrollByStudentId(int id) {
		String sql = "Delete From enroll where s_id = :sid";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", id);
		int result;
		try {
			result = namedParamJdbcTemp.update(sql, source);
		} catch(Exception ex) {
			result = 0;
		}
		if(result > 0) return true;
		return false;	
	}
	
	@Override
	public void jdbcInsertEnroll(Student student) {
		String sql = "Insert into Enroll (s_id, c_id, applicable_price) values (:sid, :cid, :aprice)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", student.getId());
		source.addValue("cid", student.getCourse().getId());
		source.addValue("aprice", student.getApplicableAmount());
		namedParamJdbcTemp.update(sql, source, keyHolder);
	}
	
	@Override
	public void jdbcInsertEnroll(int studentId, int courseId, long acceptablePrice) {
		String sql = "Insert into Enroll (s_id, c_id, applicable_price) values (:sid, :cid, :aprice)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", studentId);
		source.addValue("cid", courseId);
		source.addValue("aprice", acceptablePrice);
		namedParamJdbcTemp.update(sql, source, keyHolder);
	}
}
