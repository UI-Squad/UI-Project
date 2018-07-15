package application.model;
/**
 * @author Shane Bogard
 */
public class Address {

	/** the street location */
	private String street;
	/** this city name */
	private String city;
	/** the state name */
	private String state;
	/** the zip code */
	private String zipCd;
	/** address string */
	private String address;
	
	/**
	 * Construct a new address consisting of a street, city, state and zip code.
	 * @param street String literal specifying the street location of this address
	 * @param city String literal specifying the city of this address
	 * @param state String literal specifying the state of this address
	 * @param zipCd String literal specifying the zip code of this address
	 */
	public Address(String street, String city, String state, String zipCd) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCd = zipCd;
		setAddress();
	}
	
	/**
	 * 
	 * @param address
	 */
	public Address(String address) {
		this.address = address;
		//no functionality, empty string values for other attributes
		parseAddress();
	}
	
	/**
	 * Constructs a new address consisting of empty attributes
	 */
	public Address() {
		this("", "", "", "");
	}
	
	/**
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
		setAddress();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
		setAddress();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
		setAddress();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * 
	 * @param zipCd
	 */
	public void setZip(String zipCd) {
		this.zipCd = zipCd;
		setAddress();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getZip() {
		return zipCd;
	}
	
	private void setAddress() {
		address = street + ", " + city + ", " + state + " " + zipCd;
	}
	
	/**
	 * @param o
	 * @return
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Address)) return false;
		Address other = (Address) o;
		return street.equals(other.getStreet()) && city.equals(other.getCity())
				&& state.equals(other.getState()) && zipCd.equals(other.getZip());
	}
	
	private void parseAddress() {
		//does nothing for now (if ever)
		street = "";
		city = "";
		state = "";
		zipCd = "";
	}
	
	/**
	 * Returns a string literal representation of this object.
	 */
	public String toString() {
		return address;
	}
}
