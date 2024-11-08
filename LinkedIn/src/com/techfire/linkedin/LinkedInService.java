package com.techfire.linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedInService {

	private static LinkedInService instance;
	private Map<String,User> users;
	private Map<String,Jobposting> jobPosting;
	private Map<String,List<Notification>> notification;
	
	
	public LinkedInService() {
		users = new ConcurrentHashMap<>();
		jobPosting = new ConcurrentHashMap<>();
		notification = new ConcurrentHashMap<>();
  }
	
	public static synchronized LinkedInService getInstance() {
		if(instance == null) {
			instance = new LinkedInService();
		}
		return instance;
	}
	
	public void register(User user) {
		users.put(user.getId(), user);
	}
	
	public User loginUser(String email,String password) {
		
	     for(User user : users.values()) {
	    	 if(user.getEmail().equals(email) && user.getPassword().equals(password));
	    	 return user;
	     }
	     
	     return null;
	}
	
	public void updateuserProfile(User user) {
		users.put(user.getId(), user);
	}
	
	
	public void sendConnectionRequest(User sender,User receiver) {
		Connection connection = new Connection(sender,new Timestamp(System.currentTimeMillis()));
		receiver.getConnections().add(connection);
		Notification notification = new Notification(generateNotificationId(), receiver, NotificationType.MESSAGE,
				"New connection request from "+sender.getName(), new Timestamp(System.currentTimeMillis()));
		addNotification(receiver.getId(),notification);
	}


	public void acceptConnectionRequest(User user,User connectionUser) {
		for(Connection connection : user.getConnections()) {
			if(connection.getUser().equals(connectionUser)) {
				user.getConnections().add(new Connection(connectionUser, new Timestamp(System.currentTimeMillis())));
				break;
			}
		}
	}
	
	public List<User> searchUsers(String keyword){
		List<User> result = new ArrayList<>();
		for(User user : users.values()) {
			if(user.getName().contains(keyword)) {
				result.add(user);
			}
		}
		return result;
	}
	
	
	public void postJobPosting(Jobposting jobPostings) {
		jobPosting.put(jobPostings.getId(), jobPostings);
		for(User user :users.values()) {
			Notification notification = new Notification(generateNotificationId(), user, NotificationType.JOB_POSTING,
					"New Job Posting :" +jobPostings.getTitle(), new Timestamp(System.currentTimeMillis()));
			addNotification(user.getId(), notification);
		}
	}
	
	
	public List<Jobposting> searchJobPosting(String keyword){
		List<Jobposting> result = new ArrayList<>();
		for(Jobposting jobPosting:jobPosting.values()) {
			if(jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
				result.add(jobPosting);
			}
		}
		return result;
	}
	
	
	public void sendMessage(User sender,User receiver,String content) {
		Message message = new Message(generateMessageId(),sender,receiver,content,new Timestamp(System.currentTimeMillis()));
		receiver.getInbox().add(message);
		sender.getSentMessages().add(message);
		Notification notification  = new Notification(generateNotificationId(), receiver, NotificationType.MESSAGE,
				"New Message From" + sender.getName(), new Timestamp(System.currentTimeMillis()));
		addNotification(receiver.getId(),notification);
	}
	
	private String generateMessageId() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	private void addNotification(String userId, Notification notifications) {
		// TODO Auto-generated method stub
		notification.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notifications);
	}

	private String generateNotificationId() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}
	
	public List<Notification> getNotifications(String userId){
		return notification.getOrDefault(userId, new ArrayList<>());
	}
	
 }
