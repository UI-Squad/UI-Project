package tests;
/**
 * @author Shane Bogard
 */

import java.sql.SQLException;
import com.controller.OrderHandler;
import application.model.Order;

public class OrderHandlerTest {

	public static void main(String[] args) throws SQLException {
		OrderHandler handler = new OrderHandler();
		Order order = handler.getOrder("nio001");
		System.out.println(order.toString());
		handler.addOrder("nio002", "car002");
		order = handler.getOrder("nio002");
		System.out.println(order.toString());
		handler.closeConnection();
	}

}
