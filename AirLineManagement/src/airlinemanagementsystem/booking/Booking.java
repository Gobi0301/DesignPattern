package airlinemanagementsystem.booking;

import airlinemanagementsystem.Passenger;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.seat.Seat;

public class Booking {

	private String bookingNumber;
	private Flight flight;
	private Passenger passenger;
	private Seat seat;
	private double price;
	private BookingStatus status;
	
	
	public Booking(String bookingNumber, Flight flight, Passenger passenger, Seat seat, double price) {
		super();
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.passenger = passenger;
		this.seat = seat;
		this.price = price;
		this.status = BookingStatus.CONFIRMED;
	}
	
	public void cancel() {
		status = BookingStatus.CANCELLED;
	}
	
	public String getBookingNumber() {
		return bookingNumber;
	}
	
}
