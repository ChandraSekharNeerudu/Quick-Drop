package com.DAO;

import java.util.List;

import com.Model.Users;

public interface Users_interface {
	public Users isExist(Users user);
	public List<Users> findAll() ;
	public boolean findByUsername(String username);//only admin can see password
	public int getIdByUserName(String username);
	public boolean updatePasswordByUsername(String username,String password);
	
	public int register(Users user);		

}
