package com.DAO;

import java.util.List;
import java.util.Map;

import com.Model.Package;

public interface Package_interface {
	public List<Package> findAll();//package fee should not visible for agent
	public List<Package> findAllByCustomerId(int CustId);
	public List<Package> findAllByAgentId(int agentId);
	public String getCustomerMobile(int cust_id);
	public String getAgentMobile(int agent_id);
	public List<Package> statusPending();
	public Map<String, Double> getMyEarnings(int agentId);
	public boolean addAgent(int agentId, int packId);
	public List<Package> findfewByCustomerId(int custId);
	public boolean updateDeliveryStatus(int pid,String status);
	public boolean agentQuitelivery(int pid);
//	public void selectById(int id,Users user)throws SQLException;//package fee should not visible for agent
//	public void selectByDestination(String destination,Users user)throws SQLException;//package fee should not visible for agent
//	public void selectByStatus(String status,Users user)throws SQLException;//package fee should not visible for agent
//	public void selectByAgentId(int id,Users user)throws SQLException;//package fee should not visible for agent
//	public void selectByPackageFee(int fee,Users user)throws SQLException;//package fee should not visible for agent
	
	//row level operations
		public boolean addPackage(Package obj);//user.role==customer,user.role==admin
		
		
//		public void updateDestination(Package pbj,Users user)throws SQLException;//user.role==customer,user.role==admin
//		public void updateStatus(Package obj,Users user)throws SQLException;//user.role==agent,user.role==admin
//		public void updateAgentId(Package obj,Users user)throws SQLException;//user.role==admin
//		public void updatePackageFee(Package obj,Users user)throws SQLException;//user.role==admin
//		public void updateId(Package obj,Users user)throws SQLException;//user.role==admin
//		public void updateAll(Package obj,Users user)throws SQLException;//user.role==admin
//		
//		
//	public void deleteById(int id,Users user)throws SQLException;//user.role==admin if status ==deliverd or cancelled
	

}
