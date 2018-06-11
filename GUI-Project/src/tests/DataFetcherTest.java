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
			result = resultSet.getString("itemId") + " "
							+ resultSet.getString("name") + " "
							+ resultSet.getString("description") + " "
							+ resultSet.getDouble("price") + " " 
							+ resultSet.getInt("qty") + "\n";
		}
		return result;
	}
}
