package com.techfire.linkedin;

import java.util.List;

public class User {

	private String id;
	private String name;
	private String email;
	private String password;
	private Profile profile;
	private List<Connection> connections;
	private List<Message> inbox;
	private List<Message> sentMessages;
	
	public User(String id, String name, String email, String password, Profile profile, List<Connection> connections,
			List<Message> inbox, List<Message> sentMessages) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.connections = connections;
		this.inbox = inbox;
		this.sentMessages = sentMessages;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public List<Connection> getConnections() {
		return connections;
	}
	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}
	public List<Message> getInbox() {
		return inbox;
	}
	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}
	public List<Message> getSentMessages() {
		return sentMessages;
	}
	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}
	
}
