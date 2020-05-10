package com.signzy.assignment.dao;


import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.signzy.assignment.dto.Device;

@Repository
public class DeviceDao extends ADAORepository<Device, Long>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final ResourceBundle  QUERY_BUNDLE = ResourceBundle.getBundle("query");
	
	
	@Override
	@Transactional
	public void create(Device device) {
		String createDevices=QUERY_BUNDLE.getString("createDevices");
		insert(createDevices,getCreateDeviceParams(device));
	}

	@Override
	public Device get(Long deviceId) {
		String getDevice="Select * from devices where id=?";
		return jdbcTemplate.queryForObject(getDevice, new Object[] {deviceId},new BeanPropertyRowMapper<>(Device.class));
	}

	@Override
	public void update(Device Device) {
		
	}

	@Override
	public void delete(Long Device) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Device> getDevices(Integer limit,Integer offset){
		String getAllDevices=QUERY_BUNDLE.getString("getAllDevice");
		List<Device> devices= jdbcTemplate.query(getAllDevices, new Object[] {limit,offset},new BeanPropertyRowMapper<>(Device.class));
		return devices;
	}
	
	public List<Device> getDevicesByStatus(Boolean status,Integer limit,Integer offset){
		String getDevices=QUERY_BUNDLE.getString("getDevices");
		List<Device> devices= jdbcTemplate.query(getDevices, new Object[] {status,limit,offset},new BeanPropertyRowMapper<>(Device.class));
		return devices;
	}
	
	public Device getDeviceByMacId(String macId) {
		String  getDevicesByMacAddress=QUERY_BUNDLE.getString("getDevicesByMacAddress");
		return jdbcTemplate.queryForObject(getDevicesByMacAddress, new Object[] {macId},new BeanPropertyRowMapper<>(Device.class));
	}
	
	@Transactional
	public int updateStatus(Device device) {
		String updateStatus=QUERY_BUNDLE.getString("updateStatus");
		return jdbcTemplate.update (updateStatus, new Object[] {device.getActiveStatus(), device.getMacAddress()});
	}
	
	@Transactional
	public int disableDevice(String macAddress) {
		String disableDevice= QUERY_BUNDLE.getString("disableDevice");
		return jdbcTemplate.update(disableDevice, new Object[] {(String)macAddress});
	}
	private Object[] getCreateDeviceParams(Device device) {
		return new Object[] {device.getActiveStatus(),device.getName(),device.getInfo(),device.getMacAddress()};
	}
	
	
	


}
