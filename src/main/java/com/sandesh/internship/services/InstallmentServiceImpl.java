package com.sandesh.internship.services;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.sandesh.internship.mappers.InstallmentMapper;
import com.sandesh.internship.models.Installment;
import com.sandesh.internship.models.Student;

@Service
@Transactional
public class InstallmentServiceImpl implements InstallmentService {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	private NamedParameterJdbcTemplate namedParamJdbcTemp;
	
	public InstallmentServiceImpl(DataSource dataSource) {
		namedParamJdbcTemp = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Installment> jdbcListAll() {
		String sql = "select i.s_id, i.c_id, sum(i_amount) 't_install' from installment i group by i.s_id, i.c_id";
		List<Installment> installments = namedParamJdbcTemp.query(sql, 
				new InstallmentMapper(studentService, courseService));
		for(Installment installment : installments) {
			String enrollSql = "select applicable_price from enroll where s_id=:sid and c_id=:cid";
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("sid", installment.getStudent().getId());
			source.addValue("cid", installment.getCourse().getId());
			long applicablePrice = namedParamJdbcTemp.queryForObject(enrollSql, source, Long.class);
			installment.setApplicablePrice(applicablePrice);
		}
		return installments;
	}
	
	@Override
	public void jdbcInsertInstallment(Student student) {
		String sql = "Insert into Installment (s_id, c_id, i_amount) values " +
				"(:sid, :cid, :amount)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", student.getId());
		source.addValue("cid", student.getCourse().getId());
		source.addValue("amount", student.getInstallmentAmount());
		namedParamJdbcTemp.update(sql, source);
	}
	
	@Override
	public void jdbcInsertInstallment(int sid, int cid, long iAmount) {
		String sql = "Insert into Installment (s_id, c_id, i_amount) values " +
				"(:sid, :cid, :amount)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sid", sid);
		source.addValue("cid", cid);
		source.addValue("amount", iAmount);
		namedParamJdbcTemp.update(sql, source);
	}
}
