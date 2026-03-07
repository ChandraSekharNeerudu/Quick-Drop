package com.Model;

import java.io.Serializable;

public class Customer_profile implements Serializable {
	private int custId;
	private int userId;
	private String cutomerName;
	private String mobile;
	private String mail;
	private String address;
	
	
	public Customer_profile() {
		
	}


	public Customer_profile(int custId, int userId, String cutomerName, String mobile, String mail, String address) {
		super();
		this.custId = custId;
		this.userId = userId;
		this.cutomerName = cutomerName;
		this.mobile = mobile;
		this.mail = mail;
		this.address = address;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCutomerName() {
		return cutomerName;
	}


	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
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


	
	
}
