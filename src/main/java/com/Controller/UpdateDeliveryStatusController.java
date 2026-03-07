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


@WebServlet("/UpdateDeliveryStatusController")
public class UpdateDeliveryStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateDeliveryStatusController() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get the Package ID (from the hidden input)
	    String pidString = request.getParameter("pid");
	    int pid = Integer.parseInt(pidString);
	    String agentIdString=request.getParameter("aid");
	    int agentId=Integer.parseInt(agentIdString);

	    // 2. Get the Status (from the <select> dropdown)
	    String status = request.getParameter("status");

	    if ("Pending".equals(status)) { 
	        
	       // update  package set agent_id=?,agent_mobile=?,status=? where pkg_id=?;
	        PackageService packserv=new PackageService();
	        boolean flag=packserv.agentQuitelivery(pid);
	        if(flag) {
	        	HttpSession session=request.getSession();
	        	PackageService pkgService = new PackageService();
		        List<Package> UpadatedassignedPackages = pkgService.findAllByAgentId(agentId);
				
		        session.setAttribute("assignedPackages", UpadatedassignedPackages);
	            response.sendRedirect("StatusUpdateSuccess.jsp");
	        }
	        else {
	        	response.getWriter().append("status not updated ")  ;
	        }
	    } 
	    else {
	        PackageService packserv=new PackageService();
	        boolean flag=packserv.updateDeliveryStatus(pid,status);
	        if(flag) {
	        	HttpSession session=request.getSession();
	        	PackageService pkgService = new PackageService();
		        List<Package> UpadatedassignedPackages = pkgService.findAllByAgentId(agentId);
				
		        session.setAttribute("assignedPackages", UpadatedassignedPackages);
	            response.sendRedirect("StatusUpdateSuccess.jsp");
	        }
	        else {
	        	response.getWriter().append("status not updated ")  ;
	        }
	    }
	}

}
