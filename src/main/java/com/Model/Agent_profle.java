package com.Model;

import java.io.Serializable;

public class Agent_profle implements Serializable{
	private int agentId;
	private int userId;
	private String agentName;
	private String mobile;
	private String mail;
	private String address;
	private String vehicleType;
	private String vehicleNo;
    public Agent_profle() {
		
	}
	public Agent_profle(int agentId, int userId, String agentName, String mobile, String mail, String address,
			String vehicleType, String vehicleNo) {
		super();
		this.agentId = agentId;
		this.userId = userId;
		this.agentName = agentName;
		this.mobile = mobile;
		this.mail = mail;
		this.address = address;
		this.vehicleType = vehicleType;
		this.vehicleNo = vehicleNo;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
    
	
}
