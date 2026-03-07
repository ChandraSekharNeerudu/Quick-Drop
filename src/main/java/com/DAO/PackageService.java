package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Model.Package;
import com.Utility.JdbcConnection;

public class PackageService implements Package_interface {
	
	public void createTable(){
		System.out.println("i am reached the PackageService createTable()");
		try(Connection con=JdbcConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("CREATE TABLE IF NOT EXISTS  package (pkg_id int primary key auto_increment,source varchar(50),destination varchar(50),reciever varchar(50),reciever_mobile varchar(15),cust_id int,customer_mobile varchar(15),agent_id int,agent_mobile varchar(15),\r\n"
					+ "status ENUM('PENDING', 'IN_TRANSPORT', 'DELIVERED', 'CANCELLED') DEFAULT 'PENDING',date date, package_fee double,delivery_fee double,foreign key (cust_id) references customer_profile(cust_id),\r\n"
					+ "foreign key (agent_id) references agent_profile(agent_id))");
			ps.execute();
		}catch(SQLException e) {
			System.out.println("something went wrong while creating package table in PackageService");
			e.printStackTrace();
		}
	}
	@Override
	public boolean addPackage(Package obj) {

		try(Connection con=JdbcConnection.getConnection()){
			String query="insert into package(source,destination,reciever,reciever_mobile,cust_id,date,package_fee,delivery_fee,customer_mobile) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, obj.getSource());
			ps.setString(2, obj.getDestination());
			ps.setString(3, obj.getReciever());
			ps.setString(4, obj.getRecieverMobile());
			ps.setInt(5, obj.getCustomerId());
			ps.setDate(6,new java.sql.Date(obj.getDate().getTime()));
			ps.setDouble(7, obj.getPackageFee());
			ps.setDouble(8, obj.getDeliveryFee());
			ps.setString(9,getCustomerMobile(obj.getCustomerId()));
			int n=ps.executeUpdate();
			if(n>0)
			{
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Package> findAll() {
		List<Package> list=new ArrayList();
		try(Connection con=JdbcConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("select * from package");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Package obj=new Package( rs.getInt("pkg_id"),rs.getString("source"),rs.getString("destination"),rs.getString("reciever"), rs.getInt("cust_id"), rs.getInt("agent_id"),rs.getString("status"),rs.getDate("date"),rs.getDouble("package_fee"),rs.getDouble("delivery_fee"));
				list.add(obj);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<Package> findAllByCustomerId(int CustId) {
		List<Package> list = new ArrayList<>();
	    String query ="select * from package where cust_id=?";
	                   
	    try (Connection con = JdbcConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setInt(1,CustId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Package pkg = new Package();
	            pkg.setPkgId(rs.getInt("pkg_id"));
	            pkg.setSource(rs.getString("source"));
	            pkg.setDestination(rs.getString("destination"));
	            pkg.setReciever(rs.getString("reciever"));
	            pkg.setAgentId(rs.getInt("agent_id"));
	            pkg.setAgentMobile(rs.getString("agent_mobile"));
	            pkg.setStatus(rs.getString("status"));
	            pkg.setDate(rs.getDate("date"));
	            pkg.setPackageFee(rs.getDouble("package_fee"));
	            
	            list.add(pkg);
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return list;
	}
	
	@Override
	public List<Package> findAllByAgentId(int agentId) {
		List<Package> list = new ArrayList<>();
	    String query ="select * from package where agent_id=?";
	                   
	    try (Connection con = JdbcConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setInt(1,agentId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Package pkg = new Package();
	            pkg.setPkgId(rs.getInt("pkg_id"));
	            pkg.setSource(rs.getString("source"));
	            pkg.setDestination(rs.getString("destination"));
	            pkg.setReciever(rs.getString("reciever"));
	            pkg.setRecieverMobile(rs.getString("reciever_mobile"));
	            pkg.setCustomerId(rs.getInt("cust_id"));
	            pkg.setCustomerMobile(rs.getString("customer_mobile"));
	            pkg.setStatus(rs.getString("status"));
	            pkg.setDate(rs.getDate("date"));
	            pkg.setDeliveryFee(rs.getDouble("delivery_fee"));
	            
	            list.add(pkg);
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return list;
	}
	
	@Override
	public String getCustomerMobile(int cust_id) {
		String query ="select mobile from customer_profile where cust_id=?";
        
	    try (Connection con = JdbcConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	    	ps.setInt(1, cust_id);
	    	ResultSet rs=ps.executeQuery();
	    	if(rs.next())
	    	{
	    		return rs.getString(1);
	    	}
	    	
	    }catch (Exception e) { e.printStackTrace(); }
		return "";
	}
	@Override
	public String getAgentMobile(int agent_id) {
String query ="select agent_mobile from package where agent_id=?";
        
	    try (Connection con = JdbcConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	    	ps.setInt(1, agent_id);
	    	ResultSet rs=ps.executeQuery();
	    	if(rs.next())
	    	{
	    		return rs.getString(1);
	    	}
	    	
	    }catch (Exception e) { e.printStackTrace(); }
		return "";
	}
	public List<Package> statusPending() {
		List<Package> list=new ArrayList<>();
		String query="select * from Package where status=?";
		try (Connection con = JdbcConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, "Pending");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
	            Package pkg = new Package();
	            pkg.setPkgId(rs.getInt("pkg_id"));
	            pkg.setSource(rs.getString("source"));
	            pkg.setDestination(rs.getString("destination"));
	            pkg.setReciever(rs.getString("reciever"));
	            pkg.setRecieverMobile(rs.getString("reciever_mobile"));
	            pkg.setCustomerId(rs.getInt("cust_id"));
	            pkg.setCustomerMobile(rs.getString("customer_mobile"));
	            pkg.setStatus(rs.getString("status"));
	            pkg.setDate(rs.getDate("date"));
	            pkg.setDeliveryFee(rs.getDouble("delivery_fee"));
	       
	            list.add(pkg);
	        }
			
		}catch (Exception e) { e.printStackTrace(); }
		return list;
	}
	public Map<String, Double> getMyEarnings(int agentId) {
		Map<String, Double> earnings = new HashMap<>();
	    double money=0;
	    // 1. Current Month Query
	    String currentMonthQ = "SELECT SUM(delivery_fee) FROM package WHERE agent_id = ? AND status = 'Delivered' AND MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(date) = YEAR(CURRENT_DATE)";
	    
	    // 2. Last Month Query
	    String lastMonthQ = "SELECT SUM(delivery_fee) FROM package WHERE agent_id = ? AND status = 'Delivered' AND MONTH(date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AND YEAR(date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)";
	    
	    // 3. Total Query (What you already have)
	    String totalQ = "SELECT SUM(delivery_fee) FROM package WHERE agent_id = ? AND status = 'Delivered'";

	    // Execute these and put them in the map:
	    try (Connection con = JdbcConnection.getConnection();) {
	    	try(PreparedStatement ps = con.prepareStatement(currentMonthQ)){
	    		ps.setInt(1, agentId);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		        {
		        	System.out.println(rs.getDouble(1));
		             money= rs.getDouble(1);
		             earnings.put("thisMonth",money);
		        }
	        }catch (SQLException e) {
	        	System.out.println("exception at thismonth");
		        e.printStackTrace();
		    }
	    	
	    	try(PreparedStatement ps = con.prepareStatement(lastMonthQ)){
	    		ps.setInt(1, agentId);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		        {
		        	System.out.println(rs.getDouble(1));
		             money= rs.getDouble(1);
		             earnings.put("lastMonth", money);
		        }
	        }catch (SQLException e) {
	        	System.out.println("exception at lastmonth");
		        e.printStackTrace();
		    }
	    	
	    	try(PreparedStatement ps = con.prepareStatement(totalQ)){
	    		ps.setInt(1, agentId);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		        {
		        	System.out.println(rs.getDouble(1));
		             money= rs.getDouble(1);
		             earnings.put("total",money);
		        } 
	        }catch (SQLException e) {
	        	System.out.println("exception at total");
		        e.printStackTrace();
		    }
	    	
	    }catch (SQLException e) {
	    	System.out.println("exception at getMyEarnings");
	        e.printStackTrace();
	    }
		return earnings;
	    
	}
	public boolean addAgent(int agentId, int packId) {
		String query="update  package set agent_id=?,agent_mobile=?,status=? where pkg_id=?";
		try (Connection con = JdbcConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1,agentId);
			AgentService agentserv=new AgentService();
			ps.setString(2,agentserv.getMobileBtId(agentId));
			ps.setString(3, "IN_TRANSPORT");
			ps.setInt(4, packId);
			
			int n=ps.executeUpdate();
			if(n>0)
			{
				return true;
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	public List<Package> findfewByCustomerId(int custId) {
		List<Package> list = new ArrayList<>();
	    String query ="select * from package where cust_id=? order by pkg_id desc limit 0,3;";
	                   
	    try (Connection con = JdbcConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setInt(1,custId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Package pkg = new Package();
	            pkg.setPkgId(rs.getInt("pkg_id"));
	            pkg.setSource(rs.getString("source"));
	            pkg.setDestination(rs.getString("destination"));
	            pkg.setReciever(rs.getString("reciever"));
	            pkg.setAgentId(rs.getInt("agent_id"));
	            pkg.setAgentMobile(rs.getString("agent_mobile"));
	            pkg.setStatus(rs.getString("status"));
	            pkg.setDate(rs.getDate("date"));
	            pkg.setPackageFee(rs.getDouble("package_fee"));
	            
	            list.add(pkg);
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return list;
	}
	public boolean updateDeliveryStatus(int pid,String status) {
		String query = "UPDATE package SET status = ? WHERE pkg_id = ?";
		int n=0;
		 try (Connection con = JdbcConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(query)) {
			 ps.setString(1, status);
			 ps.setInt(2, pid);
			 n=ps.executeUpdate();
			 if(n>0) {
				 return true;
			 }
		 }catch (Exception e) { e.printStackTrace(); }
		return false;
	}
	public boolean agentQuitelivery(int pid) {
		String query = "UPDATE package SET agent_id =?,agent_mobile=?, status =? WHERE pkg_id = ?";
		int n=0;
		 try (Connection con = JdbcConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(query)) {
			// 1. Setting the Foreign Key (agent_id) to NULL in the database
			    ps.setNull(1, java.sql.Types.INTEGER); 
			    
			    // 2. Setting the agent_mobile to NULL
			    ps.setNull(2, java.sql.Types.VARCHAR); 
			    
			    // 3. Setting the status back to Pending
			    ps.setString(3, "Pending");
			    
			    // 4. Identifying the specific package
			    ps.setInt(4, pid);
			    
			    n=ps.executeUpdate();
			    if(n>0)
			    {
			    	return true;
			    }
			    
		 }catch (Exception e) { e.printStackTrace(); }
		 return false;
	}	
   
	
	
//	@Override
//	public void selectById(int id, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Package where id=?");
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Customer") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5)+"-->"+rs.getInt(6));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the Packages with that id");
//		
//	}
//	@Override
//	public void selectByDestination(String destination, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Package where destination=?");
//		ps.setString(1, destination);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Customer") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5)+"-->"+rs.getInt(6));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the Packages with the given destination");
//		
//	}
//	@Override
//	public void selectByStatus(String status, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Package where status=?");
//		ps.setString(1, status);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Customer") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5)+"-->"+rs.getInt(6));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the Packages with the given status");
//		
//	}
//	@Override
//	public void selectByAgentId(int id, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Package where agentId=?");
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Customer") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5)+"-->"+rs.getInt(6));
//				}
//			}
//			else
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the agents with that agentId");
//		
//	}
//	@Override
//	public void selectByPackageFee(int fee, Users user) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("select * from Package where packageFee=?");
//		ps.setInt(1, fee);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next())
//		{
//			if(user.getRole().equalsIgnoreCase("Customer") || user.getRole().equalsIgnoreCase("Admin"))
//			{
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getString(4)+"-->"+rs.getString(5)+"-->"+rs.getInt(6));
//				}
//			}
//		}
//		else System.out.println("currently we dont have the Packages with that fee");
//	
//	}
//	@Override
//	public void insert(Package obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("insert into Package (destination,customerName,status,agentId,deliveryFee) values(?,?,?,?,?)");
//			ps.setString(1,obj.getDestination());
//			ps.setString(2,obj.getCustomerName());
//			ps.setString(3,obj.getStatus());
//			ps.setInt(4, obj.getAgentId());
//			ps.setInt(5, obj.getPackageFee());
//			int n=0;
//			n=ps.executeUpdate();
//			
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//		
//	}
//	@Override
//	public void updateDestination(Package obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Package set destination=? where id=?");
//			ps.setString(1, obj.getDestination());
//			ps.setInt(2, obj.getId());
//			int n=0;
//			n=ps.executeUpdate();
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//		
//	}
//	@Override
//	public void updateStatus(Package obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Package set status=? where id=?");
//			ps.setString(1, obj.getStatus());
//			ps.setInt(2, obj.getId());
//			int n=0;
//			n=ps.executeUpdate();
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//		
//	}
//	@Override
//	public void updateAgentId(Package obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Package set agentId=? where id=?");
//			ps.setInt(1, obj.getAgentId());
//			ps.setInt(2, obj.getId());
//			int n=0;
//			n=ps.executeUpdate();
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//
//		
//	}
//	@Override
//	public void updatePackageFee(Package obj, Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("update Package set packageFee=? where id=?");
//			ps.setInt(1, obj.getPackageFee());
//			ps.setInt(2, obj.getId());
//			int n=0;
//			n=ps.executeUpdate();
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//
//		
//	}
//	@Override
//	public void updateId(Package obj, Users user) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void updateAll(Package obj, Users user) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void deleteById(int id,Users user) throws SQLException {
//		if(user.getRole().equalsIgnoreCase("Admin"))
//		{
//			PreparedStatement ps=con.prepareStatement("delete from Package where id=?");
//			ps.setInt(1, id);
//			int n=0;
//			n=ps.executeUpdate();
//			if(n==0)
//			{
//				System.out.println("Something went wrong");
//			}
//			else System.out.println(n+"rows are effected");
//		}
//		
//	}
}
