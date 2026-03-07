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
		PackageService packserv=new PackageService();
		System.out.println(request.getParameter("aid"));
		System.out.println(request.getParameter("pid"));
		int agentId=Integer.parseInt(request.getParameter("aid"));
		int packId=Integer.parseInt(request.getParameter("pid"));
		boolean status=packserv.addAgent(agentId,packId);
		if(status)
		{
			HttpSession session=request.getSession();
			PackageService pkgService = new PackageService();
	        List<Package> UpadatedassignedPackages = pkgService.findAllByAgentId(agentId);
			
	        session.setAttribute("assignedPackages", UpadatedassignedPackages);
	     
            response.sendRedirect("PickUped.jsp");
		}
		 else {
             //response.getWriter().println("Failed to Pick a package.");
          // Show error page or back to form
             response.sendRedirect("AddPackage.jsp?error=1");
         }
	}

}
