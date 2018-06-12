package tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.controller.DataFetcher;

public class DataFetcherTest {
	
	private ResultSet resultSet;
	private DataFetcher fetcher;
	
	public DataFetcherTest() {
		fetcher = new DataFetcher();
		resultSet = null;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String showInventory() throws SQLException {
		resultSet = fetcher.fetchAllInventory();
		String result = "";
		while(resultSet.next()) {			
			result += resultSet.getString("itemId") + " "
							+ resultSet.getString("name") + " "
							+ resultSet.getString("description") + " "
							+ resultSet.getDouble("price") + " " 
							+ resultSet.getInt("inStock") + "<br>";
		}
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String showCart(String cartId) throws SQLException {
		resultSet = fetcher.fetchCart(cartId);
		String result = "";
		while(resultSet.next()) {			
			result += resultSet.getString("cartId") + " "
							+ resultSet.getString("customerId") + " "
							+ resultSet.getString("itemId") + " "
							+ resultSet.getString("quantity") + " "
							+ resultSet.getDouble("price") + "<br>"; 
		}
		return result;
	}
}
