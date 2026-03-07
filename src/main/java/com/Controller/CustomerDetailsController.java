package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CustomerService;
import com.Model.Customer_profile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CustomerDetailsController")
public class CustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerDetailsController() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService custserv=new CustomerService();
		List<Customer_profile> list=new ArrayList<>();
		list=custserv.findAll();
			HttpSession session=request.getSession();
			session.setAttribute("customers", list);
			RequestDispatcher rd=request.getRequestDispatcher("AllCustomersDetails.jsp");
			rd.forward(request, response);
	}

}
