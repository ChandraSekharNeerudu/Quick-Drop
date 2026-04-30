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
		
		int recordsPerPage = 5;
		int page =1; // Default to page 1
		if(request.getParameter("page") != null) {
		    page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page - 1) * recordsPerPage;
		List<Package> list=pkgserv.findAll(offset,recordsPerPage);
		HttpSession session=request.getSession();
		session.setAttribute("packages", list);

		// 1. Get the total count of packages for this customer
		int totalRecords = pkgserv.count();
		// 2. Calculate total pages (e.g., 13 records / 5 per page = 3 pages)
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		// 3. Pass this to the JSP
		request.setAttribute("totalPkgPages", totalPages);
		
		RequestDispatcher rd=request.getRequestDispatcher("AllPackagesDetails.jsp");
		rd.forward(request, response);
	}

}
