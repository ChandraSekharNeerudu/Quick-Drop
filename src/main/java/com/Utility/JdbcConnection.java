package com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	public static Connection getConnection() 
	{
    	Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quick_Drop", "root","root");
			
		}catch(Exception e) {
			System.out.println("Connection failed");
			System.out.println(e);
			new Exception("Can't Connect to the Database");
		}
		return con;
	}

}
