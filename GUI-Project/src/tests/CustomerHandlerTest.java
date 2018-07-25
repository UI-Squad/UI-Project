package tests;

import java.sql.SQLException;
import com.controller.CustomerHandler;
import application.model.Cart;
import application.model.Customer;

public class CustomerHandlerTest {

	public static void main(String[] args) throws SQLException {
		CustomerHandler handler = new CustomerHandler();
		/*handler.addCust("jjones@email.com", "password", "cdf002", "Joe", "Jameson", "Jones", 
					"123 Townsville Rd, Townsville, TX, 78255", 1234567890, "car002");*/
		Customer customer = handler.getCust("jjones@email.com", "password");
		//handler.addCust("bobsmith@gmail.com", "password", "Bob", "Smith");
		//handler.addCust("test123@gmail.com", "123", "Testing", "123");
		//Customer customer = handler.getCust("bobsmith@gmail.com", "password");
		System.out.println(customer.toString());
		System.out.println("***GET CUSTOMER'S CART***");
		Cart cart = handler.getCustomerCart(customer);
		System.out.println(cart.toString());
		// UPDATE CART
		//customer.setCart(handler.getCustomerCart(customer));
		handler.closeConnection();
	}

	
}
