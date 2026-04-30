package com.DAO;

import java.util.List;

import com.Model.Customer_profile;

public interface Customer_interface {
	public boolean register(Customer_profile obj);
	public List<Customer_profile> findAll(int offset,int recordsPerPage);
	public int getIdByUserId(int  userId);
	public String getNameByUserId(int userId);
	public String getMobileById(int custId);
	public int count();

}
