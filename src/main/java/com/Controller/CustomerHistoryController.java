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
        List<Package> packageList = pkgService.findAllByCustomerId((Integer)session.getAttribute("customerTableId"));
        
        // 4. Set the list as a Request Attribute
        request.setAttribute("packageList", packageList);
		RequestDispatcher rd=request.getRequestDispatcher("Customer_history.jsp");
		rd.forward(request, response);
	}

}
