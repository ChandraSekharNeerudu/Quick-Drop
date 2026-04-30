package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.DAO.PackageService;
import com.Model.Package;


@WebServlet("/CustomerHistoryController")
public class CustomerHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerHistoryController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageService pkgService = new PackageService();
		HttpSession session=request.getSession();
		if(session.getAttribute("customerTableId")==null) {
			System.out.println("customer Id is null");
			return ;
		}
		int recordsPerPage = 5;
		int page =1; // Default to page 1
		if(request.getParameter("page") != null) {
		    page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page - 1) * recordsPerPage;
        List<Package> packageList = pkgService.findAllByCustomerId((Integer)session.getAttribute("customerTableId"),offset,recordsPerPage);
        
        // 4. Set the list as a Request Attribute
        request.setAttribute("packageList", packageList);
        
		// 1. Get the total count of packages for this customer
		int totalRecords = pkgService.getCountById((Integer) session.getAttribute("customerTableId"));
		// 2. Calculate total pages (e.g., 13 records / 5 per page = 3 pages)
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		// 3. Pass this to the JSP
		request.setAttribute("totalPages", totalPages);
		
		RequestDispatcher rd=request.getRequestDispatcher("Customer_history.jsp");
		rd.forward(request, response);
	}

}
