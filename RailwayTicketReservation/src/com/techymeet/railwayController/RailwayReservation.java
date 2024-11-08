package com.techymeet.railwayController;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techymeet.railwayBo.BerthPreference;
import com.techymeet.railwayBo.Gender;
import com.techymeet.railwayBo.PassengerBO;
import com.techymeet.railwayService.RailwayService;
import com.techymeet.railwayService.RailwayServiceImpl;



public class RailwayReservation {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Railway Reservation....!");
		boolean status = true;
		
		while(status) {
			System.out.println("Please choose one option..");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter the Booking details");
				createRailway();
				break;
				
			case 2:
				System.out.println("Print the bookings ");
			   
			     display();
			    break;
			 
			case 3:
				System.out.println("Cancel the ticket..");
				cancel();
				break;
				
			case 4:
				status = false;
				System.out.println("Exit..");
				break;
			default :
				System.out.println("Invalid option. Please try again....");
			}
		}
	}

	private static void cancel() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		   RailwayService rs = new RailwayServiceImpl();
		   int deleteId = sc.nextInt();
			int status = rs.cancelTicket(deleteId);
			if(0 < status) {
				System.out.println("Passenger Deleted Successfully ...");
			}else {
				System.out.println("Passenger not deleted....");
			}
			
			System.out.println("Redirect to list....");
			display();
	}

	private static void display() {
		// TODO Auto-generated method stub
		RailwayService rs = new RailwayServiceImpl();
	 List<PassengerBO> passengers =  rs.getAllPassenger();
	   if(0<passengers.size() && !passengers.isEmpty() && null != passengers) {
		   for(PassengerBO passenger:passengers) {
			   System.out.println();
			   System.out.println("Passenger Id " + passenger.getId());
			   System.out.println("PassengerName " + passenger.getName());
			   System.out.println("Passenger Age " + passenger.getAge());
			   System.out.println("Passenger Gender" + passenger.getGender());
			   System.out.println("Passenger Berth "+passenger.getBerthPrefernce());
		   }
	   }else {
		   System.out.println("No record found ");
	   }
		
	}

	private static void createRailway() {
		// TODO Auto-generated method stub
	   RailwayService rs = new RailwayServiceImpl();
	 //  PassengerBO passenger = new PassengerBO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID");
		int id = sc.nextInt();
		//passenger.setId(id);
		sc.nextLine();
		System.out.println("Enter the name:");
		String name = sc.next();
		//passenger.setName(name);
		System.out.println("Enter the Age :");
		int age = sc.nextInt();
		//passenger.setAge(age);
		System.out.println("Enter the Gender");
	//	passenger.setGender(Gender.MALE);
      //  passenger.setBerthPrefernce(BerthPreference.Middle_Berth);
	//		String gender = sc.next();
//		System.out.println("Enter the Berth Prefernce");
//		String berthPreference = sc.next();
	PassengerBO passenger = new PassengerBO(id,name,age,Gender.MALE,BerthPreference.Middle_Berth);
	int  status = rs.createPassenger(passenger);
		if(0<status) {
			System.out.println("Created Successfully...!");
		}else {
			System.out.println("not created Successfully..!");
		}
	}

}
