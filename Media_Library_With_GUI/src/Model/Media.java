package Model;

import java.io.Serializable;

/**
 * One object of class Media represents one entry's information
 */
public class Media implements Serializable, Comparable<Media> {// CP & DM
	
	private String title, format, location, note, type;

	/**
	 * default constructor
	 */
	public Media(){}

	/**
	 * non-default constructor
	 */
	public Media(String format, String title, String location, String note) {
		initialize(format, title, location, note);
	}

	/**
	 * initialize the parameters of media
	 */
	public void initialize(String format, String title, String location,
			String note) {
		this.format = format;
		this.title = title;
		this.location = location;
		this.note = note;
	}

	/**
	 * returns the current value of type
	 */
	public String getMediaType() {
		return type;
	}

	/**
	 * sets the value of type
	 */
	public void setMediaType(String type) {
		this.type = type;
	}

	/**
	 * returns the current value of title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * sets the value of title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * returns the current value of format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * sets the value of format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * returns the current value of location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * sets the value of location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * returns the current value of note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * sets the value of note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * returns a String containing all the data stored in this object.
	 */
	public String toString() {
		return "Format: " + format + "\nTitle: " + title + "\nLocation: "
				+ location + "\nNote: " + note + "\n";
	}

	/**
	 * compares two entries and orders them by title.
	 */
	public int compareTo(Media m) {
		int compareTitle = this.title.compareTo(m.title);
		return compareTitle;
	}
}

