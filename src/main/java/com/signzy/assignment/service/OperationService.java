package com.signzy.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signzy.assignment.dao.DeviceDao;
import com.signzy.assignment.dao.OperationDao;
import com.signzy.assignment.dto.Device;
import com.signzy.assignment.dto.OperationDto;

@Service
public class OperationService {
	@Autowired
	private OperationDao operationDao;
	
	@Autowired
	private DeviceDao deviceDao;
	
	public String performOperation(OperationDto operation)throws Exception {
		Device device=deviceDao.get(operation.getDeviceId());
		if(device.getActiveStatus() && device.isEnable()) {
			operationDao.create(operation);
		}else {
			throw new Exception("device is not active or enable");
		}
			
		return "OperationPerformed";
	}
	
	public List<OperationDto> getOperationsByMacId(String macId){
		Device device=deviceDao.getDeviceByMacId(macId);
		return operationDao.getAllOperationByDeviceId(device.getId());
	}
}
