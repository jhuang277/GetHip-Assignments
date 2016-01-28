package org.jason.gallup.wall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jason.gallup.wall.model.Note;

import database.DatabaseClass;

public class NoteService {

	private static Map<Long, Note> notes = DatabaseClass.getNotes();
	
	public NoteService() {
		notes.put(1L, new Note(1L, "Study for Calculus", "jason"));
		notes.put(2L, new Note(2L, "Buy shoes", "jason"));
		notes.put(3L, new Note(3L, "Make the next iPhone", "steve"));
		notes.put(4L, new Note(4L, "Make money", "steve"));
		notes.put(5L, new Note(5L, "Be rich", "warren"));
		
	}
	
	public static List<Note> getAllNotes() {

		return new ArrayList<Note>(notes.values());
	}
	
	public Note getNote(long id) {
		return notes.get(id);
	}
	
	public Note addNote(Note message) {
		
		message.setId(notes.size() + 1);
		notes.put(message.getId(), message);
		
		return message;
	}
	
	public Note updateNote(Note message) {
		
		if(message.getId() <= 0) {
			return null;
		}
		notes.put(message.getId(), message);
		return message;
	}
	
	public Note removeNote(long id) {
		return notes.remove(id);
	}
	
}
