package com.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.DAO.PackageService;
import com.Model.Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AddPackageController")
public class AddPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddPackageController() {
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            // 1. Extract parameters from the request
	            String source = request.getParameter("source");
	            System.out.println(source);
	            String destination = request.getParameter("destination");
	            System.out.println(destination);
	            String reciever = request.getParameter("reciever");
	            System.out.println(reciever);
	            String recievermobile = request.getParameter("recievermobile");
	            System.out.println(recievermobile);
	            
	            // 2. Parse Numeric Values (Always use try-catch for safety)
	            double packagefee = Double.parseDouble(request.getParameter("packagefee"));
	            System.out.println(packagefee);
	            int customerId = Integer.parseInt(request.getParameter("customerid"));
	            System.out.println(customerId);
	            System.out.println("customer Name "+request.getParameter("customername"));
	            
	            // 3. Logic calculation
	            double deliveryfee = (packagefee / 100) * 15;
	            System.out.println(deliveryfee);
	            
	            // 4. Create the Date object
	            // Ensure your Package constructor is: 
	            // public Package(String, String, String, String, int, Date, double, double)
	            Date curdate = new Date();
	            System.out.println(curdate);

	            // 5. Initialize the Object
	            Package obj = new Package(
	                source, 
	                destination, 
	                reciever, 
	                recievermobile, 
	                customerId, 
	                curdate, 
	                packagefee, 
	                deliveryfee
	            );

	            // 6. Use the Service to save the data
	            PackageService packserv = new PackageService();
	            boolean success = packserv.addPackage(obj);

	            if (success) {
	                // 1. Get the current session
	                HttpSession session = request.getSession();
	                
	                
	                // 2. Re-fetch the updated list from the Database
	                PackageService pkgService = new PackageService();
	                List<Package> updatedList = pkgService.findfewByCustomerId(customerId);
	                
	                // 3. Update the session attribute so the JSP sees the NEW data
	                session.setAttribute("fewpackageList", updatedList);

	                // 4. Now redirect to the success page
	                response.sendRedirect("Addsuccess.jsp");
	            } else {
	                //response.getWriter().println("Failed to save package.");
	             // Show error page or back to form
	                response.sendRedirect("AddPackage.jsp?error=1");
	            }

	        } catch (NumberFormatException e) {
	            response.getWriter().println("Error: Invalid numeric input for ID or Fee.");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("An unexpected error occurred.");
	        }
	    }
				
		
	}


