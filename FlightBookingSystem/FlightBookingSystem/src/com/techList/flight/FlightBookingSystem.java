package com.techList.flight;

import java.util.Scanner;

public class FlightBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean status = true;
		System.out.println("Welocme to Flight Booking System!");
		while(status) {
			System.out.println("Enter the choices:");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter the Flight details");
				System.out.println("Enter the flight Number :");
				String flightNo = sc.next();
				System.out.println("Enter the Available Seats....");
				int avaliableSeat = sc.nextInt();
				System.out.println("Enter the Base ticket Prices..");
				double baseTicketPrice = sc.nextDouble();
				Flight flight = new Flight(flightNo, avaliableSeat, baseTicketPrice);
				System.out.println("Enter the Booking Details ");
				System.out.println("Enter the Number of Seats...");
				int noOfSeats = sc.nextInt();
				System.out.println("Provide its a peak hours");
				boolean isPeak = sc.nextBoolean();
				System.out.println("Available Meal Option ");
				for(MealOption optionMeal : MealOption.values()) {
					System.out.println(optionMeal.name());
				}
				System.out.println("Enter the Meal Option...");
				String meal = sc.next();
				MealOption optionMeal = null;
				try {
					 optionMeal = MealOption.valueOf(meal);
				}catch(IllegalArgumentException e) {
					System.out.println("Invalid meal option.Pleas select a valid option...");
				}
				Booking booking = new Booking(flight, noOfSeats, optionMeal, isPeak);
				  
				booking.bookSeats();
				break;
				
			case 2:
				display();
			}
		}
		
		sc.close();
		

	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("Flight Details");
		
	}

}
