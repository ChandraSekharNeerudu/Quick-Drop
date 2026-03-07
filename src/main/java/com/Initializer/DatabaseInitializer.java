package com.Initializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.DAO.AgentService;
import com.DAO.CustomerService;
import com.DAO.PackageService;
import com.DAO.UsersService;



import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		String userName="root";
		String password="root";
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 1. Connect to MySQL Server
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, password);
            Statement st = con.createStatement();
            
            // 2. Create the Database
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS Quick_Drop");
            st.close();
            con.close();
            
            // 3. Now call your Table creation methods
            new UsersService().createTable();
            new CustomerService().createTable();
            new AgentService().createTable();
            new PackageService().createTable();
            
            System.out.println("Database 'Quick_Drop' and Tables verified successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
