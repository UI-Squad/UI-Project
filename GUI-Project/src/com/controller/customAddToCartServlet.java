package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class customAddToCartServlet
 */
@WebServlet("/customAddToCartServlet")
public class customAddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customAddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemID = request.getParameter("itemID");
		String itemQuantity = request.getParameter("numberOfItem");
		String cartID = "car002";	//Hardcoded for now but needs to change to whatever cartID is of signed in user
		int itemQ = Integer.parseInt(itemQuantity);
		
		CartHandler cartHandler = new CartHandler();
		
		cartHandler.addCartItem(cartID, itemID, itemQ);
		
		
		request.setAttribute("itemID", itemID);
		request.setAttribute("item", itemQ);
		request.getRequestDispatcher("./registeredCustomerViews/customCart2.jsp").forward(request, response);	}

}
