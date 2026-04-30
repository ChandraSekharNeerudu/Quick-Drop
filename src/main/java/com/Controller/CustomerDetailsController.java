package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CustomerService;
import com.Model.Customer_profile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustomerDetailsController")
public class CustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerDetailsController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService custserv = new CustomerService();
		int recordsPerPage = 5;
		int page = 1; // Default to page 1
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page - 1) * recordsPerPage;
		List<Customer_profile> list = new ArrayList<>();
		list = custserv.findAll(offset, recordsPerPage);
		HttpSession session = request.getSession();
		session.setAttribute("customers", list);

		// 1. Get the total count of packages for this customer
		int totalRecords = custserv.count();
		// 2. Calculate total pages (e.g., 13 records / 5 per page = 3 pages)
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		// 3. Pass this to the JSP
		request.setAttribute("totalCustomerPages", totalPages);
		RequestDispatcher rd = request.getRequestDispatcher("AllCustomersDetails.jsp");
		rd.forward(request, response);
	}

}
