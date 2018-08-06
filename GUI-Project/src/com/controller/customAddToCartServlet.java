package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.Cart;

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
//		CustomerHandler cusHandle = new CustomerHandler();
		CartHandler cartHandler = new CartHandler();
		Cart cart = new Cart();
		String itemID = request.getParameter("itemID");
		String itemQuantity = request.getParameter("numberOfItem");
		String cusID = (String)request.getSession().getAttribute("cusID");
		String cartID = null;
		
		System.out.println("CUSTOMER ID FROM CUSTOM ADD SERVLET " + cusID);
		
		try {
			cart = cartHandler.getCartbyCustomerIdtwo(cusID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		cartID = cart.getCartId();
		
		int itemQ = Integer.parseInt(itemQuantity);
		
		System.out.println("CART ID FROM CUSTOM ADD SERVLET " + cartID);

		
		//cartHandler.addCartItem(cartID, itemID, itemQ);
		cartHandler.addCartItem(cartID, cusID, itemID, itemQ);
		
		
		request.setAttribute("itemID", itemID);
		request.setAttribute("item", itemQ);
		request.getRequestDispatcher("./registeredCustomerViews/customCart2.jsp").forward(request, response);	}

}
