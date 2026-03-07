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
	

//	@Override
//	public void selectAll(Users user) throws SQLException {
//		String query="select * from Agent";
//		Statement st=con.createStatement();
//		ResultSet rs=st.executeQuery(query);
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getInt(4));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the agents");
//	}
	
//
//	@Override
//	public void selectById(int id, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Agent where agentId=?");
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getInt(4));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3));
//				}
//			}
//		}
//		else System.out.println("there is no Agent with that id once recheck the Agent id");
//		
//	}
//	@Override
//	public void selectByName(String name, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Agent where agentName=?");
//		ps.setString(1,name);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getInt(4));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3));
//				}
//			}
//		}
//		else System.out.println("there is no Agent with that name once recheck the Agent name ");
//	}
//
//
//	@Override
//	public void selectByMobile(String mobile, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Agent where mobile=?");
//		ps.setString(1, mobile);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getInt(4));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3));
//				}
//			}
//		}
//		else System.out.println("there is no Agent with that mobile number once recheck the Agent mobilenumber ");
//	}
//	
//
//	@Override
//	public void selectByDeliveryFee(int fee, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("select * from Agent where deliveryFee=?");
//			ps.setInt(1, fee);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next())
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getInt(4));
//				}
//			}
//			else System.out.println("there are no agents with the given delivery fee");
//		}
//		
//	}
//
	
//	@Override
//	public void updateMobile(Agent_profle obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Agent set mobile=? where agentId=?");
//			ps.setString(1, obj.getMobile());
//			ps.setInt(2, obj.getAgentId() );
//			
//			int n=0;
//			n=ps.executeUpdate();
//			
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//	}
//
//	@Override
//	public void updateName(Agent_profle obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Agent set agentName=? where agentId=?");
//			ps.setString(1, obj.getAgentName());
//			ps.setInt(2, obj.getAgentId() );
//			
//			int n=0;
//			n=ps.executeUpdate();
//			
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//	}
//
//	@Override
//	public void updateDeliveryFee(Agent_profle obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Agent"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Agent set delivery_fee=? where agentId=?");
//			ps.setInt(1, obj.getDelivery_fee());
//			ps.setInt(2, obj.getAgentId() );
//			
//			int n=0;
//			n=ps.executeUpdate();
//			
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//	}
//
//	@Override
//	public void updateAll(Agent_profle obj, Users user) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteById(int id, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Agent") || user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("delete from Agent where agentId=?");
//			ps.setInt(1, id);
//			
//			
//			int n=0;
//			n=ps.executeUpdate();
//			
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//			
//		}
		
	//}
	
}
