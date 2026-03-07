package com.Controller;

import java.io.IOException;

import com.DAO.AgentService;
import com.DAO.UsersService;
import com.Model.Agent_profle;
import com.Model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Agent_Register_Controller")
public class Agent_Register_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Agent_Register_Controller() {
      
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setRole("AGENT");
		UsersService userserv=new UsersService();
		int userid=userserv.register(user);
		if(userid<1)
		{
			System.out.println("Customer not inserted into the users table");
			return;
		}
		System.out.println("userid :"+userid);
		Agent_profle obj=new Agent_profle();
		obj.setUserId(userid);
		obj.setAgentName(request.getParameter("agentname"));
		obj.setMobile(request.getParameter("mobile"));
		obj.setMail(request.getParameter("e-mail"));
		obj.setAddress(request.getParameter("address"));
		obj.setVehicleType(request.getParameter("vehicletype"));
		obj.setVehicleNo(request.getParameter("vehicleno"));
		AgentService agentserv=new AgentService();
		boolean status=agentserv.register(obj);
		
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Agent_Register.jsp");
			rd.forward(request, response);
		}
	}

}
