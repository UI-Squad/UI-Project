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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String password1 = request.getParameter("psw");
		String repassword = request.getParameter("psw-repeat");
		if(!password1.equals(repassword)) {//passwords do not match 
			//return to registerpage.jsp 
		}
		// Step 1: set content type
		response.setContentType("text/html");
		
		// Step 2: get the printwriter
		PrintWriter out = response.getWriter();
		
		// Step 3: generate the HTML content
		out.println("<html><body>");
		
		
		
		CustomerHandler Cushandle = new CustomerHandler();
		Customer Cust = null;
		
		try {
			Cust = Cushandle.addCust(request.getParameter("FirstName"), request.getParameter("LastName"),request.getParameter("email"),request.getParameter("psw"));
			out.println("</br></br>");
			
			//sign in user to browser, Create cookiee? Return to jsp file or create cookie here
			

		} catch (SQLException e) {
			out.println("The customer could not be created");
			e.printStackTrace();
		}
		
				
		//out.println("The customer is confirmed: "
			//		+ request.getParameter("email"));		
		out.println("</br></br>");
		out.println("<a href=\"Website.html\">Return to homepage.</a>");
		out.println("</body></html>");
	}

}
