package airlinemanagementsystem.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {

	private List<Flight> flights;

	public FlightSearch(List<Flight> flights) {
		super();
		this.flights = flights;
	}
	
   public List<Flight> searchFlights(String source,String destination,LocalDate date){
	   
	   return flights.stream()
			   .filter(flight -> flight.getSource().equalsIgnoreCase(source)
					   && flight.getDestination().equalsIgnoreCase(destination)
					   && flight.getDepatureTime().toLocalDate().equals(date))
			   .collect(Collectors.toList());
   }


	
}
