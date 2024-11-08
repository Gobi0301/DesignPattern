package com.techfire.linkedin;

import java.sql.Timestamp;
import java.util.List;

public class Jobposting {

	private String id;
	private String title;
	private String description;
	private List<String> requirements;
	private String locations;
	private Timestamp  postDate;
	
	
public Jobposting(String id, String title, String description, List<String> requirements, String locations,
			Timestamp postDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.requirements = requirements;
		this.locations = locations;
		this.postDate = postDate;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<String> requirements) {
		this.requirements = requirements;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public Timestamp getPostDate() {
		return postDate;
	}
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	
	
}
