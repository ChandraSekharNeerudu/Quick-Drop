
package com.Model;

import java.time.LocalDate;
import java.util.Date;

public class Package {
	private int pkgId;
	private String source;
	private String destination;
	private String reciever;
	private String recieverMobile;
	private int customerId;//FK
	private int agentId;//FK
	private String status;//PENDING,IN_TRANSPORT,DELIVERED,CANCELLED
	private Date date;
	private double packageFee;
	private double deliveryFee;
	private String customerMobile;
	private String agentMobile;
	
	
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getAgentMobile() {
		return agentMobile;
	}
	public void setAgentMobile(String agentMobile) {
		this.agentMobile = agentMobile;
	}
	public Package() {
		
	}
	public Package(int pkgId,String source, String destination,String reciever,String recieverMobile,int customerId, int agentId,String status,Date date, double packageFee,double deliveryFee) {
		this.pkgId=pkgId;
		this.source=source;
		this.destination = destination;
		this.customerId=customerId;
		this.status = status;
		this.agentId = agentId;
		this.packageFee = packageFee;
		this.deliveryFee=deliveryFee;
		this.reciever=reciever;
		this.recieverMobile=recieverMobile;
		this.date=date;
	}
	public Package(int pkgId,String source, String destination,String reciever,int customerId, int agentId,String status,Date date, double packageFee,double deliveryFee) {
		this.pkgId=pkgId;
		this.source=source;
		this.destination = destination;
		this.customerId=customerId;
		this.status = status;
		this.agentId = agentId;
		this.packageFee = packageFee;
		this.deliveryFee=deliveryFee;
		this.reciever=reciever;
		this.date=date;
	}
	
	public Package(String source, String destination,String reciever,String recieverMobile,int customerId,Date date,double packageFee,double deliveryFee) {
		this.source=source;
		this.destination = destination;
		this.customerId=customerId;
		this.reciever=reciever;
		this.recieverMobile=recieverMobile;
		this.date=date;
		this.packageFee=packageFee;
		this.deliveryFee=deliveryFee;
	}
	
	
	public int getPkgId() {
		return pkgId;
	}
	public void setPkgId(int pkgId) {
		this.pkgId = pkgId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPackageFee() {
		return packageFee;
	}
	public void setPackageFee(double packageFee) {
		this.packageFee = packageFee;
	}
	public double getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public String getRecieverMobile() {
		return recieverMobile;
	}
	public void setRecieverMobile(String recieverMobile) {
		this.recieverMobile = recieverMobile;
	}
	
}
