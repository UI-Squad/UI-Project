package com.controller;
/**
 * @author Shane Bogard
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataHandler {
	/** Retrieves data from server **/
	protected DataFetcher fetcher;
	
	/** Results of mySQL queries **/
	protected ResultSet results;
	
	public DataHandler(DataFetcher fetcher) {
		this.fetcher = fetcher;
		results = null;
		connect();
	}
	
	/**
	 * Constructs a new DataHandler superclass.
	 */
	public DataHandler() {
		this(new DataFetcher());
	}
	
	protected DataFetcher getFetcher() {
		return fetcher;
	}
	
	/** Parses the results of the database query into model logic */
	protected abstract void parseResults() throws SQLException; 
	
	/** Connects the DataFetcher to the database */
	public void connect() {
		if(!fetcher.isConnected()) 
			fetcher.connect();
	}
	
	/** Closes all DataFetcher connections to the database */
	public void closeConnection() {
		if(fetcher.isConnected())
			fetcher.close();
	}
}
