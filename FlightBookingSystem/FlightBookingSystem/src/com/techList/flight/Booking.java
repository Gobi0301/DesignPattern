package com.techList.flight;

public class Booking {

	private Flight flight;
	private int numberOfSeats;
	private MealOption mealOption;
	private boolean ispeakHour;
	
	public Booking(Flight flight, int numberOfSeats, MealOption mealOption, boolean ispeakHour) {
		super();
		this.flight = flight;
		this.numberOfSeats = numberOfSeats;
		this.mealOption = mealOption;
		this.ispeakHour = ispeakHour;
	}
	
	public double calculateTotalCost() {
		double basePrice = flight.getBaseTicketPrice() * numberOfSeats;
		double mealPrice = mealOption.getPrice() * numberOfSeats;
		double surgeMultiplier = ispeakHour ? 1.2:1.0;
		return (basePrice + mealPrice) * surgeMultiplier;
	}
	
	public void bookSeats() {
		if(numberOfSeats <= flight.getAvailableSeats()) {
			flight.reduceAvailableSeats(numberOfSeats);
			System.out.println("Booking successful ! Total Cost: "+calculateTotalCost());
		}else {
			System.out.println("Insufficient seats available.");
		}
	}
}
