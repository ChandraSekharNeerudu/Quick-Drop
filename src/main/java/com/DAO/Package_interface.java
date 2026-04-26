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
	
	public boolean addPackage(Package obj);

}
