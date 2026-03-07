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
		List<Agent_profle> list=new ArrayList<>();
		list=agentserv.findAll();
		HttpSession session=request.getSession();
		session.setAttribute("agents", list);
		RequestDispatcher rd=request.getRequestDispatcher("AllAgentDetails.jsp");
		rd.forward(request, response);
	}

}
