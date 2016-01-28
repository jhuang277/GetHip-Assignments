package org.jason.gallup.wall.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jason.gallup.wall.model.Note;
import org.jason.gallup.wall.service.NoteService;

@Path("/myWall")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

	NoteService messageService = new NoteService();
	
	
	@GET
	public List<Note> getMessages() {
		
		return messageService.getAllNotes();
		
	}
	
	@POST
	public Note addMessage(Note message) {

		return messageService.addNote(message);
		
	}
	
	@PUT
	@Path("/{messageId}")
	public Note updateMessage(@PathParam("messageId") long id, Note message) {
		message.setId(id);
		return messageService.updateNote(message);
	}
	
	@DELETE
	@Path("{messageId}")
	public void removeMessage(@PathParam("messageId") long id) {
		messageService.removeNote(id);
	}
	
	@GET
	@Path("/{messageId}")
	public Note getMessage(@PathParam("messageId") long messageId) {
		
		return messageService.getNote(messageId);
	}
	
}
