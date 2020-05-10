package com.signzy.assignment.dto;

import java.sql.Date;
import java.util.List;

public class Device {

	private Long  id;
	
	private String name;
	
	private Date registerDate;
	
	private Date deRegisterDate;
	
	private String info;
	
	private Boolean activeStatus;
	
	private String macAddress;
	
	private Boolean enable;
	
	private List<OperationDto> operations;
	
	private OperationDto lasOperation;
	
	public Device() {
	}
	
	public Device(Device device){
		this.id=device.id;
		this.activeStatus=device.activeStatus;
		this.deRegisterDate=device.deRegisterDate;
		this.registerDate=device.deRegisterDate;
		this.name=device.name;
		this.info=device.info;
		this.macAddress=device.macAddress;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Boolean getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Date getDeRegisterDate() {
		return deRegisterDate;
	}
	public void setDeRegisterDate(Date deRegisterDate) {
		this.deRegisterDate = deRegisterDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Boolean isEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public List<OperationDto> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationDto> operations) {
		this.operations = operations;
	}

	public OperationDto getLasOperation() {
		return lasOperation;
	}

	public void setLasOperation(OperationDto lasOperation) {
		this.lasOperation = lasOperation;
	}

	public Boolean getEnable() {
		return enable;
	}
	
	
	
}
