package com.Controller;

import java.io.IOException;
import java.util.List;

import com.DAO.PackageService;
import com.Model.Package;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/PickUpedController")
public class PickUpedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PickUpedController() {
        
    }

	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false) ;
  	    if (session == null || session.getAttribute("agentTableId") == null) {
  	        // Redirect to login if the agent is not logged in
  	        response.sendRedirect("login.jsp?msg=Session Expired");
  	        return; 
  	    }
  		PackageService packserv=new PackageService();
  		System.out.println(session.getAttribute("agentTableId"));
  		System.out.println(request.getParameter("pid"));
  		int agentId=(int) session.getAttribute("agentTableId");
  		int packId=Integer.parseInt(request.getParameter("pid"));
  		boolean status=packserv.addAgent(agentId,packId);
  		if(status)
  		{
  			PackageService pkgService = new PackageService();
  	        List<Package> UpadatedassignedPackages = pkgService.findAllByAgentId(agentId);
  			
  	        session.setAttribute("assignedPackages", UpadatedassignedPackages);
  	     
              response.sendRedirect("PickUped.jsp");
  		}
  		 else {
               response.getWriter().println("Failed to Pick a package.");
            // Show error page or back to form
               response.sendRedirect("PiackAPacage.jsp?error=1");
           }
		
		
		
		
		//f testing purpose
//		System.out.println("!!! I AM IN THE CONTROLLER !!! PID is: " + request.getParameter("pid"));
//		HttpSession session = request.getSession(false);
//		System.out.println("agent name :"+session.getAttribute("agentFullName"));
//		System.out.println("agent id :"+session.getAttribute("agentTableId"));
//		if (session == null) {
//		    System.out.println("DEBUG: No session exists at all!");
//		} else {
//		    java.util.Enumeration<String> attrs = session.getAttributeNames();
//		    while(attrs.hasMoreElements()) {
//		        System.out.println("Session Attr: " + attrs.nextElement());
//		    }
//		}
	}

}
