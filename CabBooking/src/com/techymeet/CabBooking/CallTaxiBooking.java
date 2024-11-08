package com.techymeet.CabBooking;

import java.util.Scanner;

public class CallTaxiBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Taxi[] taxi = new Taxi[10];
		int taxiId = 4,bookingId=0;
		Booking[] booking = new Booking[20];
		taxi[0] = new Taxi();
		taxi[1] = new Taxi();
		taxi[2] = new Taxi();
		taxi[3] = new Taxi();
		int choice,availability;
		while(true) {
			System.out.println("----------Call Taxi Booking ---------");
			System.out.println("1.Booking");
			System.out.println("2.Booking Details");
			System.out.println("3.Taxi Details");
			System.out.println("4.Exit");
			System.out.println("Enter ur choice ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				availability = addBooking(booking,bookingId,taxi,taxiId);
				//taxiId++;
				if(availability!=-1) {
					System.out.println("Your Booking is successfull with taxi no:"+ (availability));
					booking[bookingId].dropTime();
					calEarnings(booking,bookingId,taxi,availability,booking[bookingId].pickUpPoint,booking[bookingId].dropPoint);
					bookingId++;
				}
				else {
					System.out.println("No taxi is free for Your Pickuptime !!");
					System.out.println("you may chance your pickup time and try your booking!!");
				}
				break;
			case 2:
				System.out.println("BookingId    customerId     TaxiNo   PickUpPoint   DropPoint  PickUpTime  DropTime Earnings");
			    for(int bookingid= 0; bookingid<bookingId;bookingid++) {
			    	System.out.format("%-13d%-15d%-13d%-13s%-13s%-13d%-13d%-13d",bookingid,booking[bookingid].customer_id,booking[bookingid].taxiNo,booking[bookingid].pickUpPoint,booking[bookingid].dropPoint,booking[bookingid].pickUpTime,booking[bookingid].dropTime,booking[bookingid].earnings);
			    	System.out.println("");
			    }
			    break;
			case 3:
				for(int taxiid=0;taxiid<taxiId;taxiid++) {
					int temp = 0;
					System.out.println("---------------------------------------------------");
					System.out.format("%-10s%-10d%-10s%-10s","TaxiNo",taxiid,"CurrentPosition:",taxi[taxiid].currentPosition);
					System.out.println("");
					System.out.println("-----------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					for(int bookingid =0;bookingid<bookingId;bookingid++) {
						if(booking[bookingid].taxiNo == taxiid) {
							if(temp == 0) 
								System.out.println("BookingId    customerId     TaxiNo   PickUpPoint   DropPoint  PickUpTime  DropTime Earnings");
							System.out.format("%-13d%-15d%-13d%-13s%-13s%-13d%-13d%-13d",bookingid,booking[bookingid].customer_id,booking[bookingid].taxiNo,booking[bookingid].pickUpPoint,booking[bookingid].dropPoint,booking[bookingid].pickUpTime,booking[bookingid].dropTime,booking[bookingid].earnings);
							System.out.println("");
						
							break;
							
						}
					}
					
					System.out.format("%-10s%-10d", "TotalEarnings:",taxi[taxiid].earnings);
					System.out.println();
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Please enter valid option");
			}
		}

	}

	private static void calEarnings(Booking[] booking, int bookingId, Taxi[] taxi, int availability, char pickUpPoint,
			char dropPoint) {
		// TODO Auto-generated method stub
		int earning;
		earning = (((Math.abs(pickUpPoint-dropPoint)*15)-5)*10)+100;
		booking[bookingId].earnings = earning;
		int taxiId = 0;
		taxi[taxiId ].earnings += earning; 
		
	}

	private static int addBooking(Booking[] booking, int bookingId, Taxi[] taxi, int taxiId) {
		// TODO Auto-generated method stub
		int availability,customer_id,pickUpTime;
		char pickUpPoint,dropPoint;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer id");
		customer_id  = sc.nextInt();
		System.out.println("Enter PickUp Point(a-f)");
		sc.nextLine();
		pickUpPoint = sc.next().charAt(0);
		System.out.println("Enter DropPoint point(a-f");
		dropPoint = sc.next().charAt(0);
		System.out.println("Enter PickUp time");
		pickUpTime = sc.nextInt();
		booking[bookingId] = new Booking(customer_id,pickUpTime,dropPoint,pickUpPoint);
		availability = booking[bookingId].checkAvailability(taxi, taxiId);
		return availability;
		
		
	}

}
