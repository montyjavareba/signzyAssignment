package com.signzy.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.signzy.assignment.dto.Device;
import com.signzy.assignment.service.DeviceService;

@RestController
@RequestMapping(value = "/device")
public class DeviceCtrl {
	
	@Autowired 
	private DeviceService deviceService;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ResponseEntity<?> addDevice(@RequestBody Device devices){
		return new ResponseEntity<Device>(deviceService.addDevice(devices),HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove",method =  RequestMethod.GET)
	public ResponseEntity<?> removeDevice(@RequestParam(required = true) String macId){
		return new ResponseEntity<Integer>(deviceService.removeDevice(macId),HttpStatus.OK); 
	}
	
	
	@RequestMapping(value = "/getdevice",method = RequestMethod.GET)
	public ResponseEntity<?> getDevices(@RequestParam(required = false) Boolean isactive,@RequestParam(required = false) Integer limit,@RequestParam(required = false) Integer offset){
		return new ResponseEntity<List<Device>>(deviceService.getDevices(isactive, offset, limit),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changestatus",method = RequestMethod.POST)
	public ResponseEntity<?> changeStatus(@RequestBody Device device) throws Exception{
			return new ResponseEntity<Device>(deviceService.changeStatus(device),HttpStatus.OK);
		
	}

}
