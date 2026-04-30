package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Customer_profile;
import com.Utility.JdbcConnection;

public class CustomerService implements Customer_interface{
	public void createTable() {
		try(Connection con=JdbcConnection.getConnection()){
			String query="CREATE TABLE IF NOT EXISTS customer_profile(cust_id int primary key auto_increment,user_id int ,customer_name varchar(30),mobile varchar(30),mail varchar(30),address varchar(30),foreign  key(user_id) references users(user_id))";
			PreparedStatement ps=con.prepareStatement(query);
			ps.execute();
		}catch(Exception e) {
			System.out.println("this exception is creating at the Customer table");
			e.printStackTrace();
		}
	}

	@Override
	public boolean register(Customer_profile obj) {
		
		try(Connection con=JdbcConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("insert into customer_profile (user_id,customer_name,mobile,mail,address) values(?,?,?,?,?)");
			ps.setInt(1,obj.getUserId());
			ps.setString(2,obj.getCutomerName());
			ps.setString(3,obj.getMobile());
			ps.setString(4,obj.getMail());
			ps.setString(5,obj.getAddress());
			int n=ps.executeUpdate();
			if(n>0)
			{
				return true;
			}
		}catch(Exception e) {
			System.out.println("this exception is from userservice register");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer_profile> findAll(int offset,int recordsPerPage) {
		List<Customer_profile> list=new ArrayList<>();
		try(Connection con=JdbcConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("select * from Customer_profile limit ?,?");
			ps.setInt(1, offset);
			ps.setInt(2, recordsPerPage);;
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer_profile obj=new Customer_profile(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(obj);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getIdByUserId(int userId) {
		int id=0;
		 String query ="select cust_id from customer_profile where user_id=?";
		 try (Connection con = JdbcConnection.getConnection();
		      PreparedStatement ps = con.prepareStatement(query)) {
			 ps.setInt(1,userId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 id=rs.getInt(1);
			 }
			 
		 }catch(Exception e) { e.printStackTrace(); }
		return id;
	}

	@Override
	public String getNameByUserId(int userId) {
		
		 String query ="select customer_name from customer_profile where user_id=?";
		 try (Connection con = JdbcConnection.getConnection();
		      PreparedStatement ps = con.prepareStatement(query)) {
			 ps.setInt(1,userId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 return rs.getString("customer_name");
			 }
			 
		 }catch(Exception e) { e.printStackTrace(); }
		return "";
	}

	public String getMobileById(int custId) {
		String query="select mobile from customer_profile where cust_id=?";
		 try (Connection con = JdbcConnection.getConnection();
			      PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setInt(1,custId);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 { 
					 return rs.getString(1);
				 }
		 }catch(Exception e) { e.printStackTrace(); }
		return "";
	}

	public int count() {
		String query="select count(*) from customer_profile";
		int count=0;
		try(Connection con=JdbcConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		}catch(Exception e) { e.printStackTrace(); }
		return count;
	}

}
