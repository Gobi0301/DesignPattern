package airlinemanagementsystem.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import airlinemanagementsystem.seat.Seat;

public class Flight {

	private String flightNumber;
	private String source;
	private String destination;
	private LocalDateTime depatureTime;
	private LocalDateTime arrivalTime;
	private List<Seat> availableSeats;

	public Flight(String flightNumber, String source, String destination, LocalDateTime depatureTime,
			LocalDateTime arrivalTime) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = new ArrayList<>();
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDateTime getDepatureTime() {
		return depatureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}
	
	
	
	
	
}
