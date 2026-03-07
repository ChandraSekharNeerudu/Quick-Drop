package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.Model.Agent_profle;
import com.Model.Users;
public interface Agent_interface {
	public List<Agent_profle> findAll();//delivery fee should not visible for customer
	public String getNameByUserId(int userId);
	public int getIdByUserId(int userId);
	public String getMobileBtId(int agentId);
//	public void selectById(int id,Users user)throws SQLException;//delivery fee should not visible for customer
//	public void selectByName(String name,Users user)throws SQLException;//delivery fee should not visible for customer
//	public void selectByMobile(String mobile,Users user)throws SQLException;//only agent and admin can access it
//	public void selectByDeliveryFee(int fee,Users user)throws SQLException;//only agent and admin can access it
	
	//row level operations
		public boolean register(Agent_profle obj);//user.role==agent,user.role==admin
		
		
//		public void updateMobile(Agent_profle obj,Users user)throws SQLException;//user.role==agent,user.role==admin
//		public void updateName(Agent_profle obj,Users user)throws SQLException;//user.role==agent,user.role==admin
//		public void updateDeliveryFee(Agent_profle obj,Users user)throws SQLException;//user.role==admin
//		public void updateAll(Agent_profle obj,Users user)throws SQLException;//user.role==admin
//		
//		
//	public void deleteById(int id,Users user)throws SQLException;//user.role==agent,user.role==admin
	
}
