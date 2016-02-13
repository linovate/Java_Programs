package Model;

import java.io.Serializable;

/**
 * One object of class Song represents one song's information
 */
public class Song extends Media implements Serializable {// CP & DM

	private String artist, genre;

	/**
	 * default constructor
	 */
	public Song() {}

	/**
	 * non-default constructor
	 */
	public Song(String format, String title, String location, String note,
			String artist, String genre) {
		super(format, title, location, note);
		initialize(artist, genre);
	}

	/**
	 * initialize the parameters of song
	 */
	public void initialize(String artist, String genre) {
		this.artist = artist;
		this.genre = genre;
	}

	/**
	 * returns the current value of type
	 */
	public String getMediaType() {
		return "Song";
	}

	/**
	 * returns the current value of artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * sets the value of artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * returns the current value of genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * sets the value of genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * returns a String containing all the data stored in this object.
	 */
	public String toString() {
		return super.toString() + "Artist: " + artist + "\nGenre: " + genre
				+ "\n";
	}
}
