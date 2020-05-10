package com.signzy.assignment.service;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.signzy.assignment.dao.DeviceDao;
import com.signzy.assignment.dao.OperationDao;
import com.signzy.assignment.dto.Device;
import com.signzy.assignment.dto.OperationDto;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceDao deviceDao;

	@Autowired 
	private OperationDao operationDao;
	
	public Device addDevice(Device device) {
		Device deviceCopy=new Device(device);
		if(deviceCopy.getActiveStatus()==null) {
			deviceCopy.setActiveStatus(false);
		}
		deviceDao.create(deviceCopy);
		return device;
	}
	
	public List<Device> getDevices(Boolean status,Integer offset,Integer limit){
		List<Device> devices;
		if(limit==null) limit=10;
		if(offset==null) offset=0;
		if(status==null)
			devices= deviceDao.getDevices(limit, offset);
		else
			devices= deviceDao.getDevicesByStatus(status, limit, offset);
		
		devices.forEach(device->{
			List<OperationDto> operations=operationDao.getAllOperationByDeviceId(device.getId());
			device.setOperations(operations);
			if(operations.size()>0)
				device.setLasOperation(operations.get(0));
		});
		
		return devices;
	}
	
	public Device changeStatus(Device device) throws Exception {
		Device tempDevice=null;
		if(device.getId()!=null) {
			tempDevice=deviceDao.get(device.getId());
		}else if(device.getMacAddress()!=null) {
			tempDevice=deviceDao.getDeviceByMacId(device.getMacAddress());
		}else {
			throw new InvalidParameterException("invalide param");
		}
		if(tempDevice.getActiveStatus()==device.getActiveStatus()) {
			throw new Exception();
		}else {
			tempDevice.setActiveStatus(device.getActiveStatus());
			deviceDao.updateStatus(tempDevice);
		}
		return tempDevice;
	}
	
	@Transactional
	public int removeDevice(String macAddress) {
		return deviceDao.disableDevice(macAddress);
	}
}
