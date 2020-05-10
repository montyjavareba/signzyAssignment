package com.signzy.assignment.dao;

import java.util.List;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.signzy.assignment.dto.OperationDto;

@Repository
public class OperationDao extends ADAORepository<OperationDto, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final ResourceBundle QUERY_BUNDLE = ResourceBundle.getBundle("query");
	
	@Override
	@Transactional
	public void create(OperationDto operation) {
		String operationPerformed=QUERY_BUNDLE.getString("operationPerformed");
		insert(operationPerformed, new Object[] {operation.getDeviceId(),operation.getOperation(),operation.getDescription()});
	}

	@Override
	public OperationDto get(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OperationDto i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer i) {
		// TODO Auto-generated method stub
		
	}
	
	public List<OperationDto> getAllOperationByDeviceId(Long deviceId){
		String getOperationByDeviceId=QUERY_BUNDLE.getString("getOperationByDeviceId");
		return jdbcTemplate.query(getOperationByDeviceId, new Object[] {deviceId},new BeanPropertyRowMapper<>(OperationDto.class));
	}

}
