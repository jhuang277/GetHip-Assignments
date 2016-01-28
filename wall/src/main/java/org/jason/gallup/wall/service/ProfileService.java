package org.jason.gallup.wall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jason.gallup.wall.model.Profile;
import database.DatabaseClass;

public class ProfileService {
	
	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("jason", new Profile(1L, "jason", "Jason", "Huang"));
		profiles.put("steve", new Profile(2L, "steve", "Steve", "Jobs"));
		profiles.put("warren", new Profile(3L, "warren", "Warren", "Buffet"));
	}
	
	public List<Profile> getAllProfiles() {
		
		return new ArrayList<Profile>(profiles.values()); 
		
	}

	public Profile getProfile(String profileName) {
		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public Profile deleteProfile(Profile profile) {
		
		return profiles.remove(profile);
	}
	
	
	

}
