package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.MediaList;
import View.MainMenuFrame;
/**
 * Controller of this program, which instantiates a MainMenuFrame initially.
 * Also consists of methods that interact with the GUI and model.
 */
public class Controller {// HL & CP & DM

	private static MediaList myList = new MediaList();

	public static void main(String[] args) {
//		loadFromDisk("mymedialist.ser");
		MainMenuFrame mmf = new MainMenuFrame();
		mmf.setVisible(true);
		
		myList.addBook("txt", "The Way Back", "Palo Alto", "second edition", "Tom Pawlik");
		myList.addBook("hard cover", "Mars", "Los Altos", "page 10-15 missing", "Ben Bova");
		myList.addBook("epub", "Mars", "Cupertino", "", "Eva");
		myList.addSong("mp3", "Cowboy", "San Jose", "320kbps", "kent", "britpop");
		myList.addSong("ape", "Mars", "Milpitas", "single", "May Day", "Rock");
		myList.addVideo("avi", "Fight Club", "Santa Clara", "rated R", "5");
		myList.addVideoGame("PS4", "Battlefield", "New Haven", "violent");
	}

	/**
	 * Writes the current media list to disk, returns true for success, false
	 * for failure. Also adds the filename to the filename listing. -DM
	 */
	public static boolean save() {
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("mymedialist.ser");
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(myList);
			outFile.close();
			outObject.close();
			return true;
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: "
					+ ioe.getMessage());
			return false;
		}
	}

	/**
	 * Loads a saved media list from the disk into program memory, returns true
	 * for success, false for failure. -DM
	 */
	public static boolean loadFromDisk(String name) {
		FileInputStream inFile;
		ObjectInputStream inObject;
		try {
			inFile = new FileInputStream(name);
			inObject = new ObjectInputStream(inFile);
			myList = (MediaList) inObject.readObject();
			inFile.close();
			inObject.close();
			return true;
		} catch (Exception ioe) {
			System.out.println("Error reading from the library file. "
					+ ioe.getMessage());
			return false;
		}
	}

	/**
	 * add a book entry to myList
	 */
	public static void addBookEntry(String format, String title,
			String location, String note, String author) {
		myList.addBook(format, title, location, note, author);
	}

	/**
	 * add a song entry to myList
	 */
	public static void addSongEntry(String format, String title,
			String location, String note, String artist, String genre) {
		myList.addSong(format, title, location, note, artist, genre);
	}

	/**
	 * add a video entry to myList
	 */
	public static void addVideoEntry(String format, String title,
			String location, String note, String star) {
		myList.addVideo(format, title, location, note, star);
	}

	/**
	 * add a video game entry to myList
	 */
	public static void addVideoGameEntry(String format, String title,
			String location, String note) {
		myList.addVideoGame(format, title, location, note);
	}

	/**
	 * returns all the entries in the library
	 */
	public static String wholeList() {
		return myList.toString();
	}

	/**
	 * returns all the entries of a specific media type
	 */
	public static String mediaTypeList(String type) {
		return myList.mediaTypeEntries(type);
	}

	/**
	 * ask for a type and title and then print all matching entries
	 */
	public static String searchResult(String type, String title) {
		return myList.search(type, title);
	}

	/**
	 * delete an entry in the library
	 */
	public static void deleteEntry(int index) {
		myList.delete(index);
	}
}
