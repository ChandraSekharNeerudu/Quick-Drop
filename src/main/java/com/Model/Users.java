package com.Model;

import java.io.Serializable;

public class Users implements Serializable{
	private int id;
	private String userName;
	private String password;
	private String role;//ADMIN,AGENT,CUSTOMER
	
	public Users()
	{
		
	}
	public Users(int id,String userName,String password,String role)
	{
		this.id=id;
		this.userName=userName;
		this.password=password;
		this.role=role;
	}
	public Users(String userName, String password, String role) {
		
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public Users(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
