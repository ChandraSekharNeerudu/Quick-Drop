package com.Controller;

import java.io.IOException;
import java.util.List;

import com.DAO.AgentService;
import com.DAO.CustomerService;
import com.DAO.PackageService;
import com.DAO.UsersService;
import com.Model.Package;
import com.Model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users(request.getParameter("username"),request.getParameter("password"));
		UsersService userserv=new UsersService();
		user=userserv.isExist(user);
		
		if(user!=null)
		{
			if(user.getRole().equals("CUSTOMER") )
			{
				System.out.println("he is the customer");
				HttpSession session=request.getSession();
				session.setAttribute("un", request.getParameter("username"));
				CustomerService custserv=new CustomerService();
				String customerName=custserv.getNameByUserId(user.getId());
				session.setAttribute("customerFullName", customerName);  
				int id=custserv.getIdByUserId(user.getId());
				System.out.println("customer Id :"+id);
				session.setAttribute("customerTableId", id);   
			
		        PackageService pkgService = new PackageService();
		        List<Package> fewpackageList = pkgService.findfewByCustomerId(id);
		        
		        // 4. Set the list as a Request Attribute
		        request.setAttribute("fewpackageList", fewpackageList);
				RequestDispatcher rd=request.getRequestDispatcher("Customer_home.jsp");
				rd.forward(request, response);
			}
			else if(user.getRole().equals("AGENT"))
			{
				System.out.println("he is the agent");
				HttpSession session=request.getSession();
				session.setAttribute("un", request.getParameter("username"));
				AgentService agentserv=new AgentService();
				String agentName=agentserv.getNameByUserId(user.getId());
				session.setAttribute("agentFullName",agentName ); 
				int id=agentserv.getIdByUserId(user.getId());
				session.setAttribute("agentTableId", id); 
				
				PackageService pkgService = new PackageService();
		        List<Package> assignedPackages = pkgService.findAllByAgentId(id);
		        request.setAttribute("assignedPackages", assignedPackages);
		      
				RequestDispatcher rd=request.getRequestDispatcher("Agent_home.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("he is the admin");
				HttpSession session=request.getSession();
				session.setAttribute("un",user.getUserName());
				session.setAttribute("id",userserv.getIdByUserName(user.getUserName()) );
				RequestDispatcher rd=request.getRequestDispatcher("Admin_home.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("loginstatus", "Invalid Credentials,Username or password is wrong");
			//System.out.println("Invalid Credentials,Username or password is wrong");
			response.sendRedirect("login.jsp?error=1");
//			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
//			rd.forward(request, response);
		}
		
	}

}
