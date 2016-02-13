package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * One object of class MediaList represents a list of all the entries 
 * in the personal library.
 */
public class MediaList implements Serializable {//CP & DM

	private ArrayList<Media> list = new ArrayList<Media>();

	/**
	 * adds a book entry to the list
	 */
	public void addBook(String format, String title, String location, String note,String author) {
		list.add(new Book(format, title, location, note,author));
	}

	/**
	 * adds a song entry to the list
	 */
	public void addSong(String format, String title, String location, String note,String artist, String genre) {
		list.add(new Song(format, title, location, note,artist,genre));
	}
	
	/**
	 * adds a video entry to the list
	 */
	public void addVideo(String format, String title, String location, String note,String star) {
		list.add(new Video(format, title, location, note,star));
	}
	
	/**
	 * adds a game entry to the list
	 */
	public void addVideoGame(String format, String title, String location, String note) {
		list.add(new VideoGame(format, title, location, note));
	}
	
	/**
	 * sort all the entries by title
	 */
	public void sortList() {
		Collections.sort(list);
	}
	
	/**
	 * Delete an entry from the media library.
	 */
	public void delete(int index) {
		list.remove(index);
	}
	
	/**
	 * Retrieve every entry of a particular title in one media type.
	 */
	public String search(String type, String title) {
		sortList();
		String s = "";
		int count = 0;
		for(int i=0; i<list.size(); i++){
			if((list.get(i).getTitle().equals(title) || title.equals("")) && 
					(list.get(i).getMediaType().equals(type) || type.equals(""))){//if the user leaves the title of type blank,it will show him all the entries
				s = s + "Index Number: " + i +"\n"+ list.get(i).toString() + "\n";
				count++;
			}
		}		
		if(type.equals("")){
			return "Number of entries in the library matching the title: " + count + "\n\n" + s;
		}
		return "Number of " + type + "s matching the title: " + count + "\n\n" + s;
	}
	
	/**
	 * Returns all the entries of a specific media type sorted by title
	 */
	public String mediaTypeEntries(String type) {
		sortList();
		String s = "";
		int count = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getMediaType().equals(type)){
				s = s + list.get(i).toString() + "\n";
				count++;
			}
		}
		if (count == 1) {
			return "-------------" + type + " Entries-------------\nThere is " 
				       + count + " " + type + " entry in the library.\n\n" + s;
		}
		return "-------------" + type + " Entries-------------\nThere are " 
		       + count + " " + type + " entries in the library.\n\n" + s;
	}

	/**
	 * Returns all the entries in the entire media library sorted by media type
	 * and title.
	 */
	public String toString() {
		sortList();
		if (list.size() == 1) {
			return "There is " + list.size() + " entry in the library.\n" 
				       + mediaTypeEntries("Book") + mediaTypeEntries("Song") + mediaTypeEntries("Video") + mediaTypeEntries("Video Game");
		}
		else if (list.size() == 0){
			return "There are 0 entries in the library.\n";
		}
		return "There are " + list.size() + " entries in the library.\n" 
		       + mediaTypeEntries("Book") + mediaTypeEntries("Song") + mediaTypeEntries("Video") + mediaTypeEntries("Video Game");
	}
}
