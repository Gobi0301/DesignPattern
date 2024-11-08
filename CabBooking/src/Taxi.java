import java.util.ArrayList;
import java.util.List;

public class Taxi {

	static int taxicount = 0;
	int id;
	boolean booked;
	int freeTime;
	char currentspot;
	int totalEarnings;
	List<String> trips;
	
	Taxi(){
		booked = false;
		currentspot = 'A';
		freeTime = 6;
		totalEarnings = 0;
		trips = new ArrayList<String>();
		taxicount = taxicount + 1;
		id = taxicount;
	}
	public void setDetails(boolean booked , char currentspot,int freeTime,int totalEarnings,String tripDetail) {
		this.booked = booked;
		this.currentspot = currentspot;
		this.freeTime = freeTime;
		this.totalEarnings = totalEarnings;
		this.trips.add(tripDetail);
	}
	
	public void printDetails() {
		System.out.println(" Taxi "+ this.id + " TotalEarnings "+this.totalEarnings);
		System.out.println("TaxiId "+" "+" BookingId"+" "+"CustomerId"+" "+"From"+" "+ "To" + " "+"PickupTime"+" "+"DropTime"+" "+"Amount");
		for(String trip:trips) {
			System.out.println(id + "                   "+trip);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	
}
