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
		
		
		PrintWriter out = response.getWriter();
		
		// Step 3: generate the HTML content
		out.println("<html><body>");
		
		String password1 = request.getParameter("psw");
		String repassword = request.getParameter("psw-repeat");
		if(!password1.equals(repassword)) {//passwords do not match 
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Passwords do not match. Please try again.');");  
			out.println("window.location.replace(\"registerPage.jsp\");");
			out.println("</script>"); 
		}
		// Step 1: set content type
		response.setContentType("text/html");
		
		// Step 2: get the printwriter
		
		// Step 3: generate the HTML content
		
		String fname, lname, email;
		fname =request.getParameter("FirstName");
		lname = request.getParameter("LastName");
		email = request.getParameter("email");
		CustomerHandler Cushandle = new CustomerHandler();
		CartHandler cartHandle = new CartHandler(Cushandle.getFetcher());
		
		Customer Cust = null;
		String cusID = null;
		String cusName = null;

		
		try {
			Cust = Cushandle.addCust(email, password1, fname, lname);	
			Cust = Cushandle.getCust(email, password1);
			cartHandle.addCartItem(Cust.getEmail(), Cust.getCart().getCartId(), "", 0);

		} catch (SQLException e) {
			out.println("The customer could not be created");
			e.printStackTrace();
		}
		
		cusID = Cust.getId();
		cusName = Cust.getName().getFirst();
		request.getSession().setAttribute("cusName", cusName);
		//request.getSession().setAttribute("cusID", cusID);

				
		out.println("</br></br>");
		out.println("<a href=\"./registeredCustomerViews/signedInCusWebsite.jsp\"> Welcome! Click here to Enter the website.</a>");
		out.println("</body></html>");
	}

}
