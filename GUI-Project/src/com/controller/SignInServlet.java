package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.Customer;

/**
 * @author Erwin Herrera
 * @author Manuel Ben Bravo
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: set content type for an html page
		response.setContentType("text/html");
				
		CustomerHandler Cushandle = new CustomerHandler();
		Customer Cust = null;
		PrintWriter out = response.getWriter();

	
		try {
			Cust = Cushandle.getCust(request.getParameter("email"), request.getParameter("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// No info found redirect to loginPage
		if(Cust == null) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Invalid email/password. Please try again.');");  
			out.println("window.location.replace(\"loginPage.jsp\");");
			out.println("</script>"); 
//			response.sendRedirect("loginPage.jsp");
		}else {
			//print out user creds
			out.println("<html><body>");
			out.println("</br></br>");
			out.println("Cust to string = " + Cust.getEmail() + " " + Cust.getName().toString() + " " + Cust.getId() + "<br>");
			out.println("<a href=\"./registeredCustomerViews/signedInCusWebsite.jsp\">Continue to homepage.</a>");
			out.println("</body></html>");
			out.close();
		}
		
		
	}

}
