package tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.controller.DataFetcher;

public class DataFetcherTest {

	public static void printInventory(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {			
			System.out.println(resultSet.getString("itemId") + " "
							+ resultSet.getString("name") + " "
							+ resultSet.getString("description") + " "
							+ resultSet.getDouble("price") + " " 
							+ resultSet.getInt("qty"));
		}
	}
	
	public static void main(String[] args) throws SQLException{
		DataFetcher fetcher = new DataFetcher();
		ResultSet resultSet = null;
		
		resultSet = fetcher.fetchAllInventory();
		printInventory(resultSet);
	}
}
