package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Profile;
import com.j256.ormlite.dao.Dao;

@Path("/profiles")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	@GET
	@Path("/{profileName}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		Profile pro = null;
		try {
			pro = getDao().queryForId(profileName);
			if(pro == null){
				System.out.println("Error: Profile not found.");
			}else{
				return pro;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error.");
		}			
			
		return pro;
	}
		
	@POST
    @Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		try {
			Profile profileAdd = getDao().createIfNotExists(profile);
			if(profileAdd == null){
				// handle error
			}else{
				return profileAdd;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  null;
		
	}
	
	@PUT
	@Produces("text/plain")
    @Consumes("application/json")
	public String updateProfile(Profile pro) {
		try {
			int num = getDao().update(pro);
			if(num == 1){
				return "Update successful for employee " + pro.getProfileName();
			}else{
				return "Could not update " + pro.getProfileName();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + pro.getProfileName();
		}
	}
	
	 @DELETE
	 @Path("/{profileName}")
	 @Produces("text/plain")
	 public String deleteEmployee(@PathParam("profileName") String profileName){
	    try {
	    	int num = getDao().deleteById(profileName);
			if(num == 1){
				return "Profile was deleted successfully";
			}else{
				return "An error has occured. Unable to delete profile";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error in sql statement";
		}
	 }
	
	 private Dao<Profile, String> getDao(){
	    Dao<Profile, String> dao = DataSourceManager.getInstance().getDao(Profile.class);
	    return dao;
	 }
	
}
