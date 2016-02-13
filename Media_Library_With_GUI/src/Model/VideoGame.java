package Model;

import java.io.Serializable;
/**
 * One object of class VideoGame represents one videogame's information
 */
public class VideoGame extends Media implements Serializable {//CP & DM
	/**
	 * default constructor
	 */
	public VideoGame() {}

	/**
	 * non-default constructor
	 */
	public VideoGame(String format,String title, String location, String note) {
		super(format, title, location, note);
	}
	
	/**
	 * returns the current value of type
	 */
	public String getMediaType() {
		return "Video Game";
	}
	
	public String toString(){
		return super.toString();
	}
}


