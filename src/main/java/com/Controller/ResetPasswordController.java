package com.Controller;

import java.io.IOException;

import com.DAO.UsersService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResetPasswordController() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("newpassword");
		System.out.println(username);
		System.out.println(password);
		UsersService userserv=new UsersService();
		boolean status=userserv.updatePasswordByUsername(username,password);
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
		{
			// user not found
			request.setAttribute("msg2", "Something went wrong Password not Upadated");
			response.sendRedirect("Reset_Password.jsp");
//			RequestDispatcher rd=request.getRequestDispatcher("Reset_Password.jsp");
//			rd.forward(request, response);
		}
	}

}
