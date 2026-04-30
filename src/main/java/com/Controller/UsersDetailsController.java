package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.UsersService;
import com.Model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UsersDetailsController")
public class UsersDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsersDetailsController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersService userserv=new UsersService();
		int recordsPerPage = 10;
		int page =1; // Default to page 1
		if(request.getParameter("page") != null) {
		    page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page - 1) * recordsPerPage;
		List<Users> list=new ArrayList<>();
		list=userserv.findAll(offset,recordsPerPage);
		HttpSession session=request.getSession();
		session.setAttribute("users", list);
		
		
		// 1. Get the total count of packages for this customer
		int totalUserRecords = userserv.count();
		// 2. Calculate total pages (e.g., 13 records / 5 per page = 3 pages)
		int totalUserPages = (int) Math.ceil((double) totalUserRecords / recordsPerPage);
		// 3. Pass this to the JSP
		request.setAttribute("totalUserPages", totalUserPages);
		RequestDispatcher rd=request.getRequestDispatcher("AllUsersDetails.jsp");
		rd.forward(request, response);
	}

}
