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
		List<Users> list=new ArrayList<>();
		list=userserv.findAll();
		HttpSession session=request.getSession();
		session.setAttribute("users", list);
		RequestDispatcher rd=request.getRequestDispatcher("AllUsersDetails.jsp");
		rd.forward(request, response);
	}

}
