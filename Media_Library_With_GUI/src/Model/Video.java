package Model;

import java.io.Serializable;

/**
 * One object of class Video represents one video's information
 */
public class Video extends Media implements Serializable {// CP & DM

	private String star;

	/**
	 * default constructor
	 */
	public Video() {}

	/**
	 * non-default constructor
	 */
	public Video(String format, String title, String location, String note,
			String star) {
		super(format, title, location, note);
		initialize(star);
	}

	/**
	 * initialize star
	 */
	public void initialize(String star) {
		this.star = star;
	}

	/**
	 * returns the current value of type
	 */
	public String getMediaType() {
		return "Video";
	}

	/**
	 * returns the current value of star
	 */
	public String getStar() {
		return star;
	}

	/**
	 * sets the value of star
	 */
	public void setStar(String star) {
		this.star = star;
	}

	/**
	 * returns a String containing all the data stored in this object.
	 */
	public String toString() {
		return super.toString() + "Star: " + star + "\n";
	}
}
