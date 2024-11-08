package com.techfire.linkedin;

import java.sql.Timestamp;
import java.util.List;

public class Notification {

	private String id;
	private User user;
	private NotificationType type;
	private String content;
	private Timestamp timestamp;
	
	
	
	
	public Notification(String id, User user, NotificationType type, String content, Timestamp timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.type = type;
		this.content = content;
		this.timestamp = timestamp;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public NotificationType getType() {
		return type;
	}
	public void setType(NotificationType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
