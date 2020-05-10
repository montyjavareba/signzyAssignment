package com.signzy.assignment.dao;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class ADAORepository<T,I> implements DAORepository<T, I> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	protected int insert(String sql, Object[] args) {
		return jdbcTemplate.update(con -> {
			final PreparedStatement ps = con.prepareStatement(sql);
			new ArgumentPreparedStatementSetter(args).setValues(ps);
			return ps;
		});
	}
}
