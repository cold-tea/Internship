package com.sandesh.internship.services;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.sandesh.internship.mappers.StudentCourseMapper;
import com.sandesh.internship.mappers.StudentMapper;
import com.sandesh.internship.models.Student;
import com.sandesh.internship.models.StudentCourse;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private EnrollService enrollService;
	@Autowired
	private InstallmentService installmentService;

	private NamedParameterJdbcTemplate namedParamJdbcTemp;
	
	public StudentServiceImpl(DataSource dataSource) {
		namedParamJdbcTemp = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Student> jdbcGetAll() {
		String sql = "Select * From Student";
		List<Student> students = namedParamJdbcTemp.query(sql, new StudentMapper());
		return students;
	}

	
	@Override
	public void jdbcInsertStudent(Student student) {
		String sql = "Insert into Student (f_name, l_name, gender)"
				+ " values (:fName,:lName,:gender)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("fName", student.getfName());
		source.addValue("lName", student.getlName());
		source.addValue("gender", student.getGender());
		namedParamJdbcTemp.update(sql, source, keyHolder);
		student.setId((keyHolder.getKey()).intValue());
		//enrollService.jdbcInsertEnroll(student);
		//if(student.getInstallmentAmount() > 0)
			//installmentService.jdbcInsertInstallment(student);
	}

	@Override
	public boolean jdbcRemoveStudent(Student student) {
		int id = student.getId();
		String sql = "Delete from student where s_id = :sid";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", id);
		int result;
		try {
			result = namedParamJdbcTemp.update(sql, source);
		} catch (Exception exception) {
			result = 0;
		}
		if (result > 0) return true;
		return false;
	}

	@Override
	public Student jdbcGetById(int id) {
		String sql = "Select * from student where s_id = :sid";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", id);
		Student student = namedParamJdbcTemp.queryForObject(sql, source, new StudentMapper());
		student.setStuCourses(jdbcGetCoursesFromEnroll(id));
		return student;
	}

	

	@Override
	public List<StudentCourse> jdbcGetCoursesFromEnroll(int stdId) {
		String sql = "select c.c_id, c.name, c.price, e.applicable_price from student s join enroll e on e.s_id = s.s_id" +
				" join course c on c.c_id = e.c_id where s.s_id = :sid";
		List<StudentCourse> stuCourses = new ArrayList<>();
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", stdId);
		stuCourses = namedParamJdbcTemp.query(sql, source, new StudentCourseMapper());
		return stuCourses;
	}

	@Override
	public boolean jdbcUpdateStudent(Student studentModel) {
		String sql = "Update student set f_name = :fName, l_name = :lName, gender = :gender where s_id = :sid";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("fName", studentModel.getfName());
		source.addValue("lName", studentModel.getlName());
		source.addValue("gender", studentModel.getGender());
		source.addValue("sid", studentModel.getId());
		int result = namedParamJdbcTemp.update(sql, source);
		if (result > 0) return true;
		return false;
	}

	
	
}
