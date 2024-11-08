package com.techfire.linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinkedInDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 LinkedInService linkedinService = new LinkedInService();
	 User user1 = new User("1","Gobi","gobi@gmail.com","1234",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
		linkedinService.register(user1);	
		User user2 = new User("2","nivas","nivas@gmail.com","1234",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
		linkedinService.register(user2);
		User loggedIn = linkedinService.loginUser("gobi@gmail.com", "1234");
		if(loggedIn != null) {
			System.out.println("User logged In :"+loggedIn.getName());
		}else {
			System.out.println("Invalid email or password");
		}
		
		
		Profile profile = new Profile();
		profile.setHeadline("Software Engineer");
		profile.setSummary("Passionate about coding and problem-solving");
		loggedIn.setProfile(profile);
		linkedinService.updateuserProfile(loggedIn);
		
		
		
		linkedinService.sendConnectionRequest(user1, user2);
		
		linkedinService.acceptConnectionRequest(user2, user1);
		
		Jobposting jobposting = new Jobposting("1", "software Developer", "We are hiring !", Arrays.asList("Java","Python"), 
				"chennai", new Timestamp(System.currentTimeMillis()));
		linkedinService.postJobPosting(jobposting);
		
		
		List<User> search = linkedinService.searchUsers("gobi");
		for(User user:search) {
			System.out.println("Name" + user.getName());
			System.out.println("HeadLine" + user.getProfile().getHeadline());
			System.out.println();
		}
		
		List<Jobposting> jobPostings = linkedinService.searchJobPosting("Software");
		for(Jobposting jobPosting:jobPostings) {
			System.out.println("Title" + jobPosting.getTitle());
			System.out.println("Description" + jobPosting.getDescription());
			System.out.println();
		}
		
		linkedinService.sendMessage(user1, user2, "hi nivas, hope you're doing well..!");
		
		List<Notification> notifications = linkedinService.getNotifications(user2.getId());
		System.out.println("Notifications:");
		for(Notification notification :notifications) {
			System.out.println("Type :" + notification.getType());
			System.out.println("Content :" + notification.getContent());
			System.out.println();
		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Welcome to LinkedIn");
//		boolean status = true;
//		
//		while(status) {
//			System.out.println("1. User Signup");
//			System.out.println("2. User SignIn");
//			System.out.println("3. Update User Profile");
//			System.out.println("4. Send Connection Request");
//			System.out.println("5. Accept Connection Request");
//			System.out.println("6. Job Posting");
//			System.out.println("7. Search Users");
//			System.out.println("8. Search for Job Posting");
//			System.out.println("9. Send Message");
//			System.out.println("10. Notification");
//			
//			int choice = sc.nextInt();
//			switch(choice) {
//			  
//			case 1:
//				userRegister();
//				break;
//		
//			case 2:
//				searchUsers();
//				break;
//			case 3:
//			    searchJobPosting();
//			    break;
//			case 4:
//				
//				break;
//			case 5:
//				notification();
//				break;
//			case 6:
//				status = false;
//				break;
//			default:
//				System.out.println("please choose valid choice:");
//			}
//		}
	}

//	private static void notification() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void searchJobPosting() {
//		// TODO Auto-generated method stub
//		List<Jobposting> jobPostings = linkedinService.searchJobPosting("Software");
//		for(Jobposting jobPosting:jobPostings) {
//			System.out.println("Title" + jobPosting.getTitle());
//			System.out.println("Description" + jobPosting.getDescription());
//			System.out.println();
//		}
//	}
//
//	private static void searchUsers() {
//		// TODO Auto-generated method stub
//		List<User> search = linkedinService.searchUsers("gobi");
//		for(User user:search) {
//			System.out.println("Name" + user.getName());
//			System.out.println("HeadLine" + user.getProfile().getHeadline());
//			System.out.println();
//		}
//	}
//
//
//	private static void userRegister() {
//		// TODO Auto-generated method stub
//		User user1 = new User("1","Gobi","gobi@gmail.com","1234",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
//		linkedinService.register(user1);	
//		User user2 = new User("2","nivas","nivas@gmail.com","1234",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
//		linkedinService.register(user2);
//		User loggedIn = linkedinService.loginUser("gobi@gmail.com", "1234");
//		if(loggedIn != null) {
//			System.out.println("User logged In :"+loggedIn.getName());
//		}else {
//			System.out.println("Invalid email or password");
//		}
//		
//		
//		Profile profile = new Profile();
//		profile.setHeadline("Software Engineer");
//		profile.setSummary("Passionate about coding and problem-solving");
//		loggedIn.setProfile(profile);
//		linkedinService.updateuserProfile(loggedIn);
//		
//		linkedinService.sendConnectionRequest(user1, user2);
//		
//		linkedinService.acceptConnectionRequest(user2, user1);
//		
//		Jobposting jobposting = new Jobposting("1", "software Developer", "We are hiring !", Arrays.asList("Java","Python"), 
//				"chennai", new Timestamp(System.currentTimeMillis()));
//		linkedinService.postJobPosting(jobposting);
//	}

}
