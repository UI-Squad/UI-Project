package tests;

import java.sql.SQLException;

import com.controller.CustomerHandler;
import application.model.Customer;

public class CustomerHandlerTest {

	public static void main(String[] args) throws SQLException {
		CustomerHandler handler = new CustomerHandler();
		/*handler.addCust("jjones@email.com", "password", "cdf002", "Joe", "Jameson", "Jones", 
					"123 Townsville Rd, Townsville, TX, 78255", 1234567890, "car002");*/
		Customer customer = handler.getCust("jjones@email.com", "password");
		System.out.println(customer.toString());
		handler.closeConnection();
	}

}
