package tests;
/**
 * @author Shane Bogard
 */

import java.sql.SQLException;
import com.controller.CartHandler;
import application.model.Cart;
import application.model.Item;

public class CartHandlerTest {
	
	public static void main(String[] args) throws SQLException {
		Item item = new Item("aut001", "Car Tire", 98.99);
		CartHandler cartHandler = new CartHandler();
		Cart cart = cartHandler.getCart("car001");
		System.out.println(cart.toString());
		System.out.println(cart.getItemTotal(item));
		cartHandler.closeConnection();
	}

}
