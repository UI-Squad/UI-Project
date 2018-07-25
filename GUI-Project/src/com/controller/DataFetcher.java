package com.controller;
/**
 * @author Shane Bogard
 * @author Manuel Ben Bravo
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import javax.xml.bind.DatatypeConverter;


public class DataFetcher {
	
	private static final String USER = "uiuser";
	private static final String PASS = "uipassword1";
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection connect;

	public DataFetcher(PreparedStatement preparedStatement, ResultSet resultSet, Connection connect) {
		this.preparedStatement = preparedStatement;
		this.resultSet = resultSet;
		this.connect = connect;
	}
	
	/**
	 * Constructs a new DataFetcher object.
	 */
	public DataFetcher() {
		this(null, null, null);
	}
	
	/**
	 * Opens connection to mySQL database.
	 */
	public void connect() {
		try {
			// This will load the MySQL driver, each DBMS has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://45.17.26.63/ui_database?serverTimezone=UTC", USER, PASS);
			
			/*	this.connect = DriverManager
					.getConnection("jdbc:mysql://uidbinstance.cut52ysezncx.us-west-2.rds.amazonaws.com/storedb", 
									USER, PASS);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a row from the Inventory table specified by itemId.
	 * @param itemId String literal specifying the itemId
	 * @return ResultSet results of the SQL query
	 */
	public ResultSet fetchItem(String itemId) {
		try {
			preparedStatement = connect.prepareStatement("select i.* from Inventory i"
								+ " where i.itemId = ?");
			preparedStatement.setString(1, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Changes the attributes of a specified Inventory item with the exception of it's unique ID. 
	 * @param itemId String literal specifying the item to update
	 * @param name String literal specifying the new name of the item
	 * @param description String literal specifying the new item's description
	 * @param dept String literal specifying the item's new department
	 * @param price String literal specifying the item's new price
	 * @param inStock String literal specifying the new in stock quantity of the item
	 */
	public void updateInventoryItem(String itemId, String name, String description, String dept,
							double price, int inStock) {
		try {
			preparedStatement = connect.prepareStatement("UPDATE Inventory i SET i.name = ?, i.description = ?"
					+ ", i.dept = ?, i.price = ?, i.inStock = ? WHERE i.itemId = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, dept);
			preparedStatement.setDouble(4, price);
			preparedStatement.setInt(5, inStock);
			preparedStatement.setString(6, itemId);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Changes the description for an item given the name 
	 * @param itemId String literal specifying the item to update
	 * @param name String literal specifying the new name of the item
	 * @param description String literal specifying the new item's description
	 * @param dept String literal specifying the item's new department
	 * @param price String literal specifying the item's new price
	 * @param inStock String literal specifying the new in stock quantity of the item
	 */
	public void updateInventoryItemDescription(String name, String description) {
		try {
			preparedStatement = connect.prepareStatement("UPDATE Inventory i SET i.description = ? WHERE i.name = ?");
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, name);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Adds an item to inventory 
	 * @param itemId String literal specifying the item to update
	 * @param name String literal specifying the new name of the item
	 * @param description String literal specifying the new item's description
	 * @param dept String literal specifying the item's new department
	 * @param price String literal specifying the item's new price
	 * @param inStock String literal specifying the new in stock quantity of the item
	 */
	public void addItemToInventory(String itemId, String name, String description, String dept,
							double price, int inStock) {
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Inventory (name, description, dept, price, inStock, itemId) VALUES (?,?,?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, dept);
			preparedStatement.setDouble(4, price);
			preparedStatement.setInt(5, inStock);
			preparedStatement.setString(6, itemId);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Changes a specified item's inStock field in the Inventory table. 
	 * @param itemId String literal specifying the itemId
	 * @param quantity Integer value specifying the new quantity in stock
	 */
	public void updateInventoryStock(String itemId, int quantity) {
		try {
			preparedStatement = connect.prepareStatement("UPDATE Inventory i SET i.inStock = ?"
								+ " WHERE i.itemId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setString(2, itemId);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	/**
	 * Changes a Subtracts item's inStock field in the Inventory table. 
	 * Used after an item is ordered to update Inventory
	 * @param itemId String literal specifying the itemId
	 * @param quantity Integer value specifying the new quantity in stock
	 */
	public void subtractInventoryStock(String itemId, int quantity) {
		try {
			preparedStatement = connect.prepareStatement("UPDATE Inventory i SET i.inStock = i.inStock - ?"
								+ " WHERE i.itemId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setString(2, itemId);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public int fetchInventoryItemStock(String itemId) {
		int stock = 0;
		try {
			preparedStatement = connect.prepareStatement("Select i.inStock from Inventory i where i.itemId = ?");
			preparedStatement.setString(1,  itemId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			stock = resultSet.getInt("inStock");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
	
	/**
	 * Returns all fields from the Inventory table in the UI database.
	* @return ResultSet the results of the SQL query
	*/
	public ResultSet fetchAllInventory() {
		try {
			preparedStatement = connect.prepareStatement("select * from Inventory");
			resultSet = preparedStatement.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Returns resultSet from Inventory table specified by dept.
	 * @param dept A string literal specifying the department
	 * @return resultSet results of the SQL query
	 */
	public ResultSet fetchInventoryByDept(String dept) {
		try {
			preparedStatement = connect.prepareStatement("select i.* from Inventory i where i.dept = ?");
			preparedStatement.setString(1, dept);
			resultSet = preparedStatement.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * Returns all data fields from the Carts table and the price
	 * of each matching item from the Inventory table in the GUI Database
	 * that matches the specified cartId.
	 * @param cartId A string literal representing the cart id
	 * @return ResultSet the resulSet of the SQL query
	 */
	public ResultSet fetchCart(String cartId) {
		try {
			preparedStatement = connect.prepareStatement("select c.*, i.price from Carts c, Inventory i"
									+ " where c.cartId = ? and c.itemId = i.itemId");
			preparedStatement.setString(1, cartId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	/**
	 * Returns the CartID using the CustomerID
	 * @param cartId A string literal representing the cart id
	 * @return ResultSet the resulSet of the SQL query
	 */
	public ResultSet fetchCartbyCustomerId(String custID) {
		try {
			preparedStatement = connect.prepareStatement("SELECT c.curCart FROM Customers c WHERE c.CustomerID = ?");
			preparedStatement.setString(1, custID);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			resultSet = fetchCart(resultSet.getString("curCart"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	
	/**
	 * Registered customer
	 * @param cartId
	 * @param itemId
	 * @param quantity
	 */
	public void addCartItem(String cartId, String customerId, String itemId, int quantity) {
		try {
			preparedStatement = connect.prepareStatement("INSERT into `Carts` values(?, ?, ?, ?)");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, customerId);
			preparedStatement.setString(3,  itemId);
			preparedStatement.setInt(4, quantity);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			
		}
	}
	
	/**
	 * For guest 
	 * @param cartId
	 * @param itemId
	 * @param quantity
	 */
	public void addCartItem(String cartId, String itemId, int quantity) {
		try {
			fetchCart(cartId);
			resultSet.next();
			//String customerId = resultSet.getString("customerId");
			//if(customerId.equals("0") || customerId.equals(null))
				//customerId = "nul000";
			preparedStatement = connect.prepareStatement("INSERT into `Carts` values(?, ?, ?, ?)");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, "guest");
			preparedStatement.setString(3,  itemId);
			preparedStatement.setInt(4, quantity);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param cartId
	 * @param itemId
	 */
	public void removeCartItem(String cartId, String itemId) {
		try {
			preparedStatement = connect.prepareStatement("DELETE from Carts WHERE cartId = ? AND itemId = ?");
			preparedStatement.setString(1,  cartId);
			preparedStatement.setString(2, itemId);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
			
	/**
	 * Returns a ResultSet of items from the Inventory table and their matching quantities 
	 * in the Carts table by a specified cartId and joining the tables by itemId.
	 * @param cartId String literal specifying the cart Id
	 * @return ResultSet resulting SQL query
	 */
	public ResultSet fetchCartItems(String cartId) {
		try {
			preparedStatement = connect.prepareStatement("select i.itemId, i.name, i.description"
									+ ", i.dept, i.price, c.quantity from Inventory i, Carts c"
									+ " where c.cartId = ? and i.itemId = c.itemId");
			preparedStatement.setString(1, cartId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * 
	 * @param cartId
	 * @param itemId
	 * @return
	 */
	public ResultSet fetchCartItem(String cartId, String itemId) {
		try {
			preparedStatement = connect.prepareStatement("select c.* from Carts c where c.cartId = ?"
														+ " and c.itemId = ?");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
		
	public ResultSet fetchCustomer(String email, String password) {
		String myHash = hashPassword(password); // Hash password
		
		try {
			preparedStatement = connect.prepareStatement("SELECT c.* FROM Customers c WHERE c.email = ? AND c.password = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, myHash);
			resultSet = preparedStatement.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public void addCustomer(String email, String password, String firstNm, String lastNm) {
		String myHash = hashPassword(password); // Hash Password
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO `Customers` (email, password, firstNm, lastNm)"
													+ " VALUES(?, ?, ?, ?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, myHash);
			preparedStatement.setString(3, firstNm);
			preparedStatement.setString(4, lastNm);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Search Method to retrieve information from database
	
	 * @param search
	 * @return
	 */
	public ResultSet searchQuery(String search) {
		try {
			preparedStatement = connect.prepareStatement("SELECT * from Inventory WHERE name LIKE ? ? ?");
			preparedStatement.setString(1, "%");
			preparedStatement.setString(2, search);
			preparedStatement.setString(3, "%");
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
		
	}
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @param custId
	 * @param firstNm
	 * @param middleNm
	 * @param lastNm
	 * @param address
	 * @param phoneNm
	 * @param cartId
	 * @return
	 */
	public void addCustomer(String email, String password, String custId, String firstNm, 
						String middleNm, String lastNm, String address, long phoneNm, String cartId) {
			String myHash = hashPassword(password); // Hash Password
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO `Customers` " 
														+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, myHash);
				preparedStatement.setString(3, custId);
				preparedStatement.setString(4, firstNm);
				preparedStatement.setString(5, middleNm);
				preparedStatement.setString(6, lastNm);
				preparedStatement.setString(7, address);
				preparedStatement.setLong(8, phoneNm);
				preparedStatement.setString(9, cartId);
				preparedStatement.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Returns the results of performing a mySQL query on the order table by a specified orderId.
	 * @param orderId String literal specifying the order id
	 * @return ResultSet results of a mySQL query
	 */
	public ResultSet fetchOrder(String orderId){
		try {
			preparedStatement = connect.prepareStatement("select o.* from Orders o where o.orderId = ?");
			preparedStatement.setString(1, orderId);
			resultSet = preparedStatement.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	/**
	 * Adds a new order to the order table in the database.
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 * @param trackNm Integer value specifying the tracking number of the order
	 */
	public void addOrder(String orderId, String cartId, Date orderDt, Date shipDt, int trackNm) {
		try {
			
			preparedStatement = connect.prepareStatement("INSERT into `Orders` values( ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderId);
			preparedStatement.setString(2, cartId);
			preparedStatement.setDate(3, orderDt);
			preparedStatement.setDate(4, shipDt);
			preparedStatement.setInt(5, trackNm);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a new order to the order table in the database with a null tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 */
	public void addOrder(String orderId, String cartId, Date orderDt, Date shipDt) {
		try {
			
			preparedStatement = connect.prepareStatement("INSERT into `Orders` values( ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderId);
			preparedStatement.setString(2, cartId);
			preparedStatement.setDate(3, orderDt);
			preparedStatement.setDate(4, shipDt);
			preparedStatement.setNull(5, Types.NULL);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a new order to the order table in the database with a null ship date and tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 */
	public void addOrder(String orderId, String cartId, Date orderDt) {
		try {
			
			preparedStatement = connect.prepareStatement("INSERT into `Orders` values( ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderId);
			preparedStatement.setString(2, cartId);
			preparedStatement.setDate(3, orderDt);
			preparedStatement.setNull(4, Types.NULL);
			preparedStatement.setNull(5, Types.NULL);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a new order to the order table in the database that uses the current date as an order date
	 * with a null ship date and tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 */
	public void addOrder(String orderId, String cartId) {
		try {
			
			preparedStatement = connect.prepareStatement("INSERT into `Orders` values( ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderId);
			preparedStatement.setString(2, cartId);
			preparedStatement.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			preparedStatement.setNull(4, Types.NULL);
			preparedStatement.setNull(5, Types.NULL);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Hash Password Method 
	 * @param password
	 * @return String for Password
	 */
	public String hashPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();	
	    return myHash;
	}
	
	/**
	 * Returns a boolean value indicating if this Data Fetcher is still
	 * connected to the database.
	 * @return Boolean value
	 * @throws SQLException
	 */
	public boolean isConnected() {
		return (connect != null);
	}
	
	/**
	 * Closes the preparedStatment, resultSet and connect.
	 */
	public void close() {
		try {
			if(preparedStatement != null)
				preparedStatement.close();
			if(resultSet != null)
				resultSet.close();
			if(connect != null)
				connect.close();
		}
		catch (Exception e) {
			
		}
	}
	
}
