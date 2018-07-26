package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddtoCartServlet
 * @author Manuel Ben Bravo
 */
@WebServlet("/AddtoCartServlet")
public class AddtoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		String itemID = request.getParameter("itemID");
		String itemQuantity = request.getParameter("numberOfItem");
		String cartID = "car000";
		int itemQ = Integer.parseInt(itemQuantity);

		
		CartHandler cartHandler = new CartHandler();
		
		cartHandler.addCartItem(cartID, "guest", itemID, itemQ);
		
		
		request.setAttribute("itemID", itemID);
		request.setAttribute("item", itemQ);
		request.getRequestDispatcher("cartPage.jsp").forward(request, response);
		
	}

}
