package database;

import java.util.HashMap;
import java.util.Map;

import org.jason.gallup.wall.model.Note;
import org.jason.gallup.wall.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Note> notes = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Note> getNotes() {
		
		return notes;
	}
	
	public static Map<String, Profile> getProfiles() {
		 
		return profiles;
	}
	
}
