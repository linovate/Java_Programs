package Model;

import java.io.Serializable;

/**
 * One object of class Book represents one book's information
 */
public class Book extends Media implements Serializable {// CP & DM
	
	private String author;

	/**
	 * default constructor
	 */
	public Book() {}

	/**
	 * non-default constructor
	 */
	public Book(String format, String title, String location, String note,
			String author) {
		super(format, title, location, note);
		initialize(author);
	}

	/**
	 * initialize author
	 */
	public void initialize(String author) {
		this.author = author;
	}

	/**
	 * returns the current value of type
	 */
	public String getMediaType() {
		return "Book";
	}

	/**
	 * returns the current value of author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * sets the value of author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns a String containing all the data stored in this object.
	 */
	public String toString() {
		return super.toString() + "Author: " + author + "\n";
	}
}
