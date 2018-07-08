package tests;
/**
 * Tests the ItemHandler class to ensure the class can pull
 * results from the database
 * @author Shane Bogard
 */

import com.controller.ItemHandler;
import application.model.Item;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemHandlerTest {
	
	/**
	 * Prints an ArrayList of item objects to standard out
	 * @param items An ArrayList of item objects
	 */
	public static void printItemList(ArrayList<Item> items) {
		for(Item item : items)
			System.out.println(item.toString());
		System.out.println();
	}

	public static void main(String[] args) throws SQLException {
		ItemHandler itemHandler = new ItemHandler();
		ArrayList<Item> items = new ArrayList<Item>();
		System.out.println("***ALL ITEMS***");
		items = itemHandler.getAllItems();
		printItemList(items);
		System.out.println("***BY DEPT***");
		System.out.println("+++ELECTRONICS+++");
		items = itemHandler.getItemsByDept("electronics");
		printItemList(items);
		System.out.println("+++BOOKS+++");
		items = itemHandler.getItemsByDept("books");
		printItemList(items);
		System.out.println("+++AUTO+++");
		items = itemHandler.getItemsByDept("auto");
		printItemList(items);
		System.out.println("+++CLOTHING+++");
		items = itemHandler.getItemsByDept("clothing");
		printItemList(items);
		System.out.println("+++HOME+++");
		items = itemHandler.getItemsByDept("home");
		printItemList(items);
		
		itemHandler.closeConnection();
	}

}
