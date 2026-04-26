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
	
	public boolean register(Agent_profle obj);
		
		

}
