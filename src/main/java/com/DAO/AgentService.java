package com.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Agent_profle;
import com.Model.Customer_profile;
import com.Utility.JdbcConnection;

public class AgentService implements Agent_interface{
	
	public void createTable() {
		try(Connection con=JdbcConnection.getConnection()){
			String query="CREATE TABLE IF NOT EXISTS agent_profile(agent_id int primary key auto_increment,user_id int ,agent_name varchar(30),mobile varchar(30),mail varchar(30),address varchar(30),vehicle_type varchar(30),vehicle_no varchar(30),foreign  key(user_id) references users(user_id))";
			PreparedStatement ps=con.prepareStatement(query);
			ps.execute();
		}catch(Exception e) {
			System.out.println("this exception is at creating the Agent table");
			e.printStackTrace();
		}
	}
	@Override
	public boolean register(Agent_profle obj) {
		
		try(Connection con=JdbcConnection.getConnection()){
			String query="insert into agent_profile (user_id,agent_name,mobile,mail,address,vehicle_type,vehicle_no) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, obj.getUserId());
			ps.setString(2,obj.getAgentName());
			ps.setString(3,obj.getMobile());
			ps.setString(4,obj.getMail());
			ps.setString(5,obj.getAddress());
			ps.setString(6,obj.getVehicleType());
			ps.setString(7,obj.getVehicleNo());
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
	public List<Agent_profle> findAll() {
		List<Agent_profle> list=new ArrayList<>();
		try(Connection con=JdbcConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("select * from Agent_profile");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Agent_profle obj=new Agent_profle(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
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
		 String query ="select agent_id from agent_profile where user_id=?";
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
		
		 String query ="select agent_name from agent_profile where user_id=?";
		 try (Connection con = JdbcConnection.getConnection();
		      PreparedStatement ps = con.prepareStatement(query)) {
			 ps.setInt(1,userId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 return rs.getString("agent_name");
			 }
			 
		 }catch(Exception e) { e.printStackTrace(); }
		return "";
	}
	public String getMobileBtId(int agentId) {
		String query="select mobile from agent_profile where agent_id=?";
		 try (Connection con = JdbcConnection.getConnection();
			      PreparedStatement ps = con.prepareStatement(query)) {
				 ps.setInt(1,agentId);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 return rs.getString("mobile");
				 }
		 }catch(Exception e) { e.printStackTrace(); }
		return "";
	}
	
}
