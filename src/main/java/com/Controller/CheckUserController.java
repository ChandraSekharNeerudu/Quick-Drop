package com.Controller;

import java.io.IOException;

import com.DAO.UsersService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CheckUserController")
public class CheckUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckUserController() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		UsersService userserv=new UsersService();
		boolean status=userserv.findByUsername(username);
		if(status)
		{
			request.setAttribute("username", username);
			RequestDispatcher rd=request.getRequestDispatcher("Reset_Password.jsp");
			rd.forward(request, response);
		}
		else
		{
			// user not found
			request.setAttribute("msg1", " User not found");

			RequestDispatcher rd = request.getRequestDispatcher("forgot_password.jsp");
			rd.forward(request, response);
		}
	}

}
