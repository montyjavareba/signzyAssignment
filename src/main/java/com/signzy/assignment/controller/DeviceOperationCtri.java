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

import com.signzy.assignment.dto.OperationDto;
import com.signzy.assignment.service.OperationService;

@RestController
@RequestMapping(value = "/operation")
public class DeviceOperationCtri {
	
	@Autowired
	private OperationService operationService;
	
	@RequestMapping(value = "/perform",method = RequestMethod.POST)
	public ResponseEntity<?> operationPerformed(@RequestBody OperationDto operation) throws Exception{
		return new ResponseEntity<String>(operationService.performOperation(operation),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	public ResponseEntity<?> getOperations(@RequestParam(required = true) String macid){
		return new ResponseEntity<List<OperationDto>>(operationService.getOperationsByMacId(macid),HttpStatus.OK);
	}
}
