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


@WebServlet("/PackageDetailsController")
public class PackageDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PackageDetailsController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageService pkgserv=new PackageService();
		List<Package> list=pkgserv.findAll();
		HttpSession session=request.getSession();
		session.setAttribute("packages", list);
		RequestDispatcher rd=request.getRequestDispatcher("AllPackagesDetails.jsp");
		rd.forward(request, response);
	}

}
