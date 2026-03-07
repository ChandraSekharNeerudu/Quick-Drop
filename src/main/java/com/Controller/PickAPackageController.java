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


@WebServlet("/PickAPackageController")
public class PickAPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PickAPackageController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageService packserv=new PackageService();
		List<Package> unAssignedPackages=packserv.statusPending();
		System.out.println(unAssignedPackages==null);
		request.setAttribute("unAssignedPackages", unAssignedPackages);
		RequestDispatcher rd=request.getRequestDispatcher("PiackAPackage.jsp");
		rd.forward(request, response);
	}

}
