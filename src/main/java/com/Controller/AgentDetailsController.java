package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.AgentService;
import com.Model.Agent_profle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AgentDetailsController")
public class AgentDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AgentDetailsController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgentService agentserv=new AgentService();
		int recordsPerPage = 5;
		int page =1; // Default to page 1
		if(request.getParameter("page") != null) {
		    page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page - 1) * recordsPerPage;
		List<Agent_profle> list=new ArrayList<>();
		list=agentserv.findAll(offset,recordsPerPage);
		HttpSession session=request.getSession();
		session.setAttribute("agents", list);
		
		// 1. Get the total count of packages for this customer
		int totalRecords = agentserv.count();
		// 2. Calculate total pages (e.g., 13 records / 5 per page = 3 pages)
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		// 3. Pass this to the JSP
		request.setAttribute("totalAgentPages", totalPages);
				
		RequestDispatcher rd=request.getRequestDispatcher("AllAgentDetails.jsp");
		rd.forward(request, response);
	}

}
