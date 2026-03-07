package com.Controller;

import java.io.IOException;
import java.util.Map;

import com.DAO.PackageService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/MyEarningsController")
public class MyEarningsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyEarningsController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int agentId=(int) session.getAttribute("agentTableId");
		PackageService packserv=new PackageService();
		Map<String,Double> Myearnings=packserv.getMyEarnings(agentId);
		session.setAttribute("thisMonth", Myearnings.get("thisMonth"));
		session.setAttribute("lastMonth", Myearnings.get("lastMonth"));
		session.setAttribute("totalEarnings", Myearnings.get("total"));
		RequestDispatcher rd=request.getRequestDispatcher("MyEarnings.jsp");
		rd.forward(request, response);
	}

}
