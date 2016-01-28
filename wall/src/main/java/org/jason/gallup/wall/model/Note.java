package org.jason.gallup.wall.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Note {
	
	private long id;
	private String note;
	private Date created;
	private String author;
	
	public Note() {
		
	}
	
	public Note(long id, String message, String author) {
		this.id = id;
		this.note = message;
		this.created = new Date();
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String message) {
		this.note = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
