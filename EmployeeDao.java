package com.employee;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class EmployeeDao extends JdbcDaoSupport {
	
	@Autowired
	DataSource datasource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}
	
	public void insert(Employee emp) {
			String sql = "insert into employee values("+emp.getEid()+", '"+emp.getEname()+"',"+emp.getEsalary()+")";
			JdbcTemplate jt = getJdbcTemplate();
			jt.execute(sql);
	}

}
