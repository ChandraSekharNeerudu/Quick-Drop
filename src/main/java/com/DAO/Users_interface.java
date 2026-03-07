package com.DAO;

import java.util.List;

import com.Model.Users;

public interface Users_interface {
	public Users isExist(Users user);
	public List<Users> findAll() ;
	public boolean findByUsername(String username);//only admin can see password
	public int getIdByUserName(String username);
	public boolean updatePasswordByUsername(String username,String password);
//	public void details(Users user)throws SQLException;//get details by providing credentials username and password
//	public void selectByRole(String role)throws SQLException;//only admin can see password
	
	//row level operations
			public int register(Users user);
			
			
//			public void updatePassword( String password,Users user)throws SQLException;//same username and passward
//			public void updateName(String name,Users user)throws SQLException;//same username and passward
//			public void updateRole(String role,Users user)throws SQLException;//only admin can able to change role
//			public void updateAll(Users user1,Users user)throws SQLException;//only admin can able to change
//			
//			
//		public void deleteById(int id)throws SQLException;
//		

}
