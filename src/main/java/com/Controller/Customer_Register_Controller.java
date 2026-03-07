package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.CustomerService;
import com.DAO.UsersService;
import com.Model.Customer_profile;
import com.Model.Users;

@WebServlet("/Customer_Register_Controller")
public class Customer_Register_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Customer_Register_Controller() {
      
    }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setRole("CUSTOMER");
		UsersService userserv=new UsersService();
		int userid=userserv.register(user);
		if(userid<1)
		{
			System.out.println("Customer not inserted into the users table");
			return;
		}
		System.out.println("userid :"+userid);
		Customer_profile customer=new Customer_profile();
		customer.setUserId(userid);
		customer.setCutomerName(request.getParameter("customername"));
		customer.setMobile(request.getParameter("mobile"));
		customer.setMail(request.getParameter("e-mail"));
		customer.setAddress(request.getParameter("address"));
		CustomerService customerserv=new CustomerService();
		boolean status=customerserv.register(customer);
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Customer_Register.jsp");
			rd.forward(request, response);
		}
	}
}


