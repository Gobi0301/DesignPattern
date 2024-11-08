package com.techList.flight;

public class Flight {

	private String flightNumber;
	private int availableSeats;
	private double baseTicketPrice;
	
	public Flight(String flightNumber,int availableSeats,double baseTicketPrice) {
		this.flightNumber = flightNumber;
		this.availableSeats = availableSeats;
		this.baseTicketPrice = baseTicketPrice;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public double getBaseTicketPrice() {
		return baseTicketPrice;
	}
	
	public void reduceAvailableSeats(int seats) {
		this.availableSeats -=seats;
	}
}
