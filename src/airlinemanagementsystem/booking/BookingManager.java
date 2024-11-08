package airlinemanagementsystem.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import airlinemanagementsystem.Passenger;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.seat.Seat;

public class BookingManager {

	private static BookingManager instance;
	private Map<String,Booking> bookings;
	private Object lock  = new Object();
	private AtomicInteger bookingCounter = new AtomicInteger(0);
	
	private BookingManager() {
		bookings = new HashMap<>();
	}

	public static synchronized BookingManager getInstance() {
		if(instance == null) {
			instance = new BookingManager();
		}
		
		return instance;
	}
	
	public Booking createBooking(Flight flight,Passenger passenger , Seat seat,double price) {
		String bookingNumber = generateBookingNumber();
		Booking booking = new Booking(bookingNumber,flight,passenger,seat,price);
		synchronized (lock) {
			bookings.put(bookingNumber, booking);
		}
		return booking;
	}

	private String generateBookingNumber() {
		// TODO Auto-generated method stub
		int bookingId = bookingCounter.incrementAndGet();
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return "BKG" + timeStamp + String.format("%06d", bookingId);
	}
	
	public void cancelBooking(String bookingNumber) {
		synchronized (lock) {
				Booking booking = bookings.get(bookingNumber);
				if(booking != null) {
					booking.cancel();
				}
		}
	}
	
	
}
