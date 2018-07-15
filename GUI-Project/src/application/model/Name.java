package application.model;
/**
 * @author Shane Bogard
 *
 */

public class Name {
	/** the first part of the name */
	private String first;
	/** the middle part of the name */
	private String middle;
	/** the last part of the name */
	private String last;
	
	/**
	 * Constructs a new Name object consisting of a first, middle and last name.
	 * @param first String literal specifying the first part of the name
	 * @param middle String literal specifying the middle part of the name
	 * @param last String literal specifying the last part of the name
	 */
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
	
	/**
	 * Constructs a Name object consisting of a first and last name
	 * @param first String literal specifying the first part of the name
	 * @param last String literal specifying the last part of the name
	 */
	public Name(String first, String last) {
		this(first, "", last);
	}
	
	/**
	 * Constructs a new Name object with empty name attributes
	 */
	public Name() {
		this("","","");
	}
	
	/**
	 * Changes the first part of the name into a new first name.
	 * @param first String literal specifying the new first name
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	
	/**
	 * Returns the first name from this name.
	 * @return String literal representing the first name
	 */
	public String getFirst() {
		return first;
	}
	
	/**
	 * Changes the middle part of the name into a new middle name.
	 * @param middle String literal specifying the new middle name
	 */
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	
	/**
	 * Returns the middle name from this name
	 * @return String literal representing the middle part of this name
	 */
	public String getMiddle() {
		return middle;
	}
	
	/**
	 * Returns the initial of the middle part of this name
	 * @return String literal representing the middle name initial
	 */
	public String getMiddleInitial() {
		switch(middle.length()) {
			case 0: case 1: 
				return middle;
			default:
				return middle.substring(0, 1).toUpperCase();
		}
	}
	
	/**
	 * Changes the last part of this name
	 * @param last String literal specifying the new last part of this name
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	/**
	 * Returns the last part of this name
	 * @return String literal representing the last part of this name
	 */
	public String getLast() {
		return last;
	}
	
	/**
	 * Returns a boolean value that represents if this name object is equal
	 * to another name object.
	 * @Object o Object to compare this name to
	 * @return boolean value
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Name)) return false;
		Name other = (Name) o;
		return first.equalsIgnoreCase(other.getFirst()) && middle.equalsIgnoreCase(other.getMiddle())
				&& last.equalsIgnoreCase(other.getLast());
	}
	
	/**
	 * Returns a string literal representation of this name object
	 */
	public String toString() {
		return first + " " + ((!middle.equals("")) ? middle + " " : "") + last;
	}
	
}
