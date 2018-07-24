package tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.controller.DataFetcher;
import com.controller.ItemHandler;

import application.model.Item;

/**
 * 
 * @author Shane Bogard
 * @author Erwin Herrera
 *
 */
public class DataFetcherTest {
	
//	private ResultSet resultSet;
//	private DataFetcher fetcher;
//	
//	public DataFetcherTest() {
//		fetcher = new DataFetcher();
//		resultSet = null;
//	}
	
	public static void main(String[] args) {
		DataFetcher fetchTest = new DataFetcher();
		fetchTest.connect();
		
		
		Scanner sc = new Scanner(System.in);  

		System.out.println("ENTER ITEM INFORMATION");
		System.out.println();

		System.out.print("Enter itemID (abc123 format) ");  
		String itemId = sc.nextLine();  
		System.out.print("Enter itemName ");  
		String name = sc.nextLine();  
		System.out.print("Enter itemDescription ");  
		String description = sc.nextLine();
		System.out.println();
		System.out.print("Enter department ");
		String dept = sc.nextLine();
		System.out.println();
		System.out.print("Enter item price ");
		double price = sc.nextDouble();
		System.out.println();
		System.out.print("Enter inStock number of items ");
		int inStock = sc.nextInt();

		System.out.println("All information entered.");
		sc.close();  

		fetchTest.addItemToInventory(itemId, name, description, dept, price, inStock);
		
		fetchTest.fetchAllInventory();
		
		fetchTest.close();
		
	}

	/**
	 * This method returns all elements in the mySQL table.
	 * @return
	 * @throws SQLException
	 */
//	public String showInventory() throws SQLException {
//		resultSet = fetcher.fetchAllInventory();
//		String result = "";
//		while(resultSet.next()) {			
//			result += resultSet.getString("itemId") + " "
//							+ resultSet.getString("name") + " "
//							+ resultSet.getString("description") + " "
//							+ resultSet.getDouble("price") + " " 
//							+ resultSet.getInt("inStock") + "<br>";
//		}
//		return result;
//	}
	
//	/**
//	 * 
//	 * This method returns the names of items
//	 * @return
//	 * @throws SQLException
//	 */
//	public ArrayList<String> showItemName() throws SQLException {
//		ArrayList<String> itemNameList = new ArrayList<String>();
//		resultSet = fetcher.fetchAllInventory();
//		String itemName = "";
//		while(resultSet.next()) {
//			itemName = resultSet.getString("name");
//			itemNameList.add(itemName);
//		}		
//		return itemNameList;
//	}
//	
//	
//	/**
//	 * This method returns the prices of items
//	 * @return
//	 * @throws SQLException
//	 */
//	public ArrayList<Double> showPrice() throws SQLException {
//		ArrayList<Double> priceList = new ArrayList<Double>();
//		resultSet = fetcher.fetchAllInventory();
//		double price = 0.0;
//		while(resultSet.next()) {
//			price = resultSet.getDouble("price");
//			priceList.add(price);
//		}
//		return priceList;
//	}
//	
//	
//	/**
//	 * This method returns the descriptions of items
//	 * @return
//	 * @throws SQLException
//	 */
//	public ArrayList<String> showProductDescriptions() throws SQLException {
//		ArrayList<String> descriptionList = new ArrayList<String>();
//		resultSet = fetcher.fetchAllInventory();
//		String itemName = "";
//		while(resultSet.next()) {
//			itemName = resultSet.getString("description");
//			descriptionList.add(itemName);
//		}		
//		return descriptionList;
//	}
//	
//	
//	/**
//	 * This returns all items in cart of a customer.
//	 * @return
//	 * @throws SQLException
//	 */
//	public String showCart(String cartId) throws SQLException {
//		resultSet = fetcher.fetchCart(cartId);
//		String result = "";
//		while(resultSet.next()) {			
//			result += resultSet.getString("cartId") + " "
//							+ resultSet.getString("customerId") + " "
//							+ resultSet.getString("itemId") + " "
//							+ resultSet.getString("quantity") + " "
//							+ resultSet.getDouble("price") + "<br>"; 
//		}
//		return result;
//	
	}
/*	
 * 
 * 
 * public void fetchCustomer() {
		String email = "johnSmith@gmail.com";
		String password = "P@ssw0rd";
		
		resultSet = fetcher.fetchCustomer(email, password);
		while(resultSet.next()) {
			
		}
	
	}
	*/
	


	
